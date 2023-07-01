import java.util.Scanner;

public class Interface {
    //обработка главного меню
//его пропишу когда заполню остальные файлы (а после него уже прописываем Main)
    public Interface() {
      Scanner scanner = new Scanner(System.in);
      //сюда скорее всего нужно будет вставить метод FileReader()
      while (true) {
          printMenu();
          int command = scanner.nextInt();

          if (command == 1) {
//Считать все месячные отчёты
          } else if (command == 2) {
              //    Считать годовой отчёт
          } else if (command == 3) {
              //Сверить отчёты
          } else if (command == 4) {
              //Вывести информацию обо всех месячных отчётах
          } else if (command == 5) {
              //Вывести информацию о годовом отчёте
          } else if (command == 0) {
              System.out.println("Завершение программы...");
              return;
          } else{
              System.out.println("Ой, что-то пошло не так. Такой команды нет");
          }
      }
  }
 private static void printMenu(){
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

