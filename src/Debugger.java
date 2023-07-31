import java.util.List;

public class Debugger {
    //класс для проверки на наличие и соответствие отчетов (3 пункт меню инфа за каждый месяц в отдельности)

   /*
    public boolean DataChecking() {
        boolean YRis = false;
        if (Main.fileReader.MRis && Main.fileReader.YRis) {
            return true;
        } else if (!Main.fileReader.MRis || !Main.fileReader.YRis) {
            System.out.println(Main.wrongReport + "произошла ошибка в методе DataChecking");
            return false;
        }
        return false;
        //может этот кусок вообще не нужен? но пока пусть будет
    }

    */
    public void CheckList(){
        //создать метод который проверит соответствие инфы в отчетах
        List<String> coherence = Checker.coincidenceSearch(Main.fileReader.monthsList, Main.fileReader.monthlyReports, Main.fileReader.yearlyReport);

        if (coherence.isEmpty()){
            System.out.println("Отчеты успешно прошли проверку");
        } else{
            System.out.println(Main.wrongReport);
        }
    }
}
