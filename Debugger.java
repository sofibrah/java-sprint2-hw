import java.util.List;

public class Debugger {

    public void CheckList() {

        List<String> coherence = Checker.coincidenceSearch(Main.fileReader.monthsList, Main.fileReader.monthlyReports, Main.fileReader.yearlyReport);

        if (coherence.isEmpty()) {
            System.out.println("Отчеты успешно прошли проверку");
        } else {
            System.out.println(Main.wrongReport);
        }
    }
}
