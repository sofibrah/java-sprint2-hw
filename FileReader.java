import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.io.IOException;




public class FileReader {
    public String currentYear;
    public HashMap<String, String> monthsList = new HashMap<>();
    public MonthlyReport[] monthlyReports;
    boolean MRis = false;

    public YearlyReport yearlyReport;
    boolean YRis = false;

    FileReader() {
        currentYear = "2021";
        monthsList.put("01", "Январь");
        monthsList.put("02", "Февраль");
        monthsList.put("03", "Март");
        monthsList.put("04", "Апрель");
        monthsList.put("05", "Май");
        monthsList.put("06", "Июнь");
        monthsList.put("07", "Июль");
        monthsList.put("08", "Август");
        monthsList.put("09", "Сентябрь");
        monthsList.put("10", "Октябрь");
        monthsList.put("11", "Ноябрь");
        monthsList.put("12", "Декабрь");
        monthlyReports = new MonthlyReport[monthsList.size()];
    }

    public void MonthReading() {
        int processedReports = 0;
        for (String monthNumber : monthsList.keySet()) {
            Path filePath = Path.of("./resources/" + "m." + currentYear + monthNumber + ".csv");
            if (Files.exists(filePath)) {
                try {
                    String csvData = Files.readString(filePath);
                    String[] lines = csvData.split("\\n");
                    HashMap<String, Integer> incomeList = new HashMap<>();
                    HashMap<String, Integer> expensesList = new HashMap<>();

                    for (int i = 0; i < lines.length; i++) {
                        String[] linesContent = lines[i].split(",");
                        String itemName = linesContent[0];
                        int itemSum = Integer.parseInt(linesContent[2]) * Integer.parseInt(linesContent[3]);

                        if (linesContent[1].equalsIgnoreCase("false")) {
                            incomeList.put(itemName, itemSum);
                        } else {
                            expensesList.put(itemName, itemSum);
                        }
                    }
                    monthlyReports[Integer.parseInt(monthNumber) - 1] = new MonthlyReport(monthsList.get(monthNumber), incomeList, expensesList);
                    processedReports++;

                } catch (IOException e) {
                    System.out.println("Не найден файл отчета " + "m." + currentYear + monthNumber + ".csv !");
                }
            }
        }
        if (processedReports == 0) {
            System.out.println(Main.wrongReport);
        } else {
            MRis = true;
            System.out.println("Обработано " + processedReports + " месячных отчетов");
        }
    }

    public void YearReading() {
        HashMap<String, Integer> incomeList = new HashMap<>();
        HashMap<String, Integer> expensesList = new HashMap<>();
        Path filePath = Path.of("./resources/" + "y." + currentYear + ".csv");


        String csvData = null;
        try {
            csvData = Files.readString(filePath);
            String[] lines = csvData.split("\\n");

            for (int i = 1; i < lines.length; i++) {
                String[] linesContent = lines[i].split(",");
                String monthNumber = linesContent[0];
                int monthsSum = Integer.parseInt(linesContent[1]);

                if (linesContent[2].equalsIgnoreCase("false")) {
                    incomeList.put(monthsList.get(monthNumber), monthsSum);
                } else {
                    expensesList.put(monthsList.get(monthNumber), monthsSum);
                }
            }
            yearlyReport = new YearlyReport(currentYear, incomeList, expensesList);
            YRis = true;
            System.out.println("Годовой отчет успешно считан!");
        } catch (IOException e) {
            System.out.println("Что-то пошло не так...");
        }
    }
}









//в этом классе происходит привязка программы к отчетам их обработка
// с помощью IOException и блока try catch предотвращаем возможную ошибку
//   ArrayList<String> readFileContents(String fileName) {
//     String path = "./resources/" + fileName;
//    try {
//      return new ArrayList<>(Files.readAllLines(Path.of(path)));
//  } catch (IOException e) {
//    System.out.println("Невозможно прочитать файл с отчётом. Возможно, файл отсутствует в нужной директории.");
//   return new ArrayList<>();