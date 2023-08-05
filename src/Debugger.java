import java.util.List;

public class Debugger {

    public void CheckList() {

        List<String> coherence = Checker.coincidenceSearch(Interface.fileReader.monthsList, Interface.fileReader.monthlyReports, Interface.fileReader.yearlyReport);

        if (coherence.isEmpty()) {
            System.out.println("Отчеты успешно прошли проверку");
        } else {
            System.out.println(Interface.wrongReport);
        }
    }
}
