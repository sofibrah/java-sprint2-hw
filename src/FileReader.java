import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;

import static java.lang.Integer.parseInt;


public class FileReader {

    private final String currentYear;
    public HashMap<String, String> monthsList = new HashMap<>();

     public MonthlyReport[] monthlyReports;
     public YearlyReport yearlyReport;

     boolean MRis = false;
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
     public void  MonthReading() {
         int processedReports = 0;

         for (String monthNumber : monthsList.keySet()) {
             Path filePath = Path.of("./resources/" + "m." + currentYear + monthNumber + ".csv");

             if (Files.exists(filePath)) {

                 try {
                     String csvData = Files.readString(filePath);
                     String[] lines = csvData.split("\n");
                     HashMap<String, Integer> incomeList = new HashMap<>();
                     HashMap<String, Integer> expensesList = new HashMap<>();

                     for (String word : Arrays.copyOfRange(lines,1,lines.length)) {

                         String[] linesContent = word.split(",");

                         String itemName = linesContent[0];
                         Integer quantity = Integer.valueOf(linesContent[2]);
                         Integer unit_price = Integer.valueOf(linesContent[3]);

                         int itemSum = quantity * unit_price;




                         if (linesContent[1].equalsIgnoreCase("false")) {
                             incomeList.put(itemName, itemSum);
                         } else {
                             expensesList.put(itemName, itemSum);
                         }

                         monthlyReports[parseInt(monthNumber) - 1] = new MonthlyReport(monthsList.get(monthNumber), incomeList, expensesList);
                         processedReports++;
                     }
                 } catch (IOException e) {
                     System.out.println("Не найден файл отчета " + "m." + yearlyReport.currentYear + MonthlyReport.monthNumber + ".csv !");
                 }
                 if (processedReports > 0) {
                     MRis = true;
                     System.out.println("Обработано месячных отчетов: " + processedReports);
                 } else
                     System.out.println(Interface.wrongReport);
             }
         }
     }
       public void YearReading() {
            HashMap<String, Integer> incomeList = new HashMap<>();
            HashMap<String, Integer> expensesList = new HashMap<>();
            Path filePath = Path.of("./resources/" + "y." + currentYear + ".csv");

            String csvData;
            try {
                csvData = Files.readString(filePath);
                String[] lines = csvData.split("\n");

                for (int i = 1; i < lines.length; i++) {
                    String[] linesContent = lines[i].split(",");
                    String monthNumber = linesContent[0];
                    int monthsSum = parseInt(linesContent[1]);

                    if (linesContent[2].equalsIgnoreCase("false")) {
                        incomeList.put(monthsList.get(monthNumber),  monthsSum);
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









