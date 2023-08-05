import java.util.Scanner;


public class Interface {
    public static FileReader fileReader = new FileReader();
    public static Debugger debugger = new  Debugger();

    public void printInterface()  {
        Scanner scanner = new Scanner(System.in);
        String command;
        do {
            printMenu();
            command = scanner.nextLine();

            switch (command) {
                case "1":
                    Interface.fileReader.MonthReading();
                    break;
                case "2":
                    Interface.fileReader.YearReading();
                    break;
                case "3":
                    Interface.debugger.CheckList();
                    break;
                case "4":
                    if (Interface.fileReader.MRis) {
                        ReportsDemo.MDemo(Interface.fileReader.monthsList, Interface.fileReader.monthlyReports);
                    } else {
                        System.out.println(Interface.wrongReport);
                    }
                    break;
                case "5":
                    if (Interface.fileReader.YRis) {
                        ReportsDemo.YDemo(Interface.fileReader.monthsList, Interface.fileReader.yearlyReport.currentYear, Interface.fileReader.yearlyReport.incomeList, Interface.fileReader.yearlyReport.expensesList);
                    } else {
                        System.out.println(Interface.wrongReport);
                    }
                    break;
                case "0":
                    return;
                default:
                    System.out.println(Interface.wrongCommand);
            }
        } while (!command.isEmpty());

    }

    private static void printMenu() {

        System.out.println("Здравствуйте!");
        System.out.println();
        System.out.println("Выберите команду:");
        System.out.println();
        System.out.println("1 - Считать все месячные отчёты");
        System.out.println("2 - Считать годовой отчёт");
        System.out.println("3 - Сверить отчёты ");
        System.out.println("4 - Вывести информацию обо всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
        System.out.println("0 - Выход!");
    }
    public static String wrongCommand = "Ошибка ввода. Неверная команда!";
    public static String wrongReport = "Ошибка ввода. Неполные данные по отчетам!";
}









