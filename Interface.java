import java.util.Scanner;


public class Interface {
    //обработка главного меню

    // ReportsDemo reportsDemo;
    Interface() {
        Scanner scanner = new Scanner(System.in);
        String command;
        do {
            printMenu();
            command = scanner.nextLine();


         //   String command = scanner.nextLine();

            switch (command) {
                case "1":
                    Main.fileReader.MonthReading();
                    break;
                case "2":
                    Main.fileReader.YearReading();
                    break;
                case "3":
                    if (Main.debugger.DataChecking()) {
                        Main.debugger.CheckList();
                    }
                    break;
                case "4":
                    if (Main.fileReader.MRis) {
                        ReportsDemo.MDemo(Main.fileReader.monthsList, Main.fileReader.monthlyReports);
                    } else {
                        System.out.println(Main.wrongReport);
                    }
                    break;
                case "5":
                    if (Main.fileReader.YRis) {
                        ReportsDemo.YDemo(Main.fileReader.monthsList, Main.fileReader.yearlyReport.currentYear, Main.fileReader.yearlyReport.incomeList, Main.fileReader.yearlyReport.expensesList);
                    } else {
                        System.out.println(Main.wrongReport);
                    }
                    break;
                case "0":
                    break;
                default:
                    System.out.println(Main.wrongComand);
            }
        }while (!command.isEmpty());
    }

    private static void printMenu() {
        //прописываю меню, которое выведется на экран пользователя
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
}









