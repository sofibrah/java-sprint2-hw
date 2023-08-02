import java.util.HashMap;

public class MonthlyReport {

                public static String monthNumber;
                public HashMap<String, Integer> incomeList;
                public HashMap<String, Integer> expensesList;

                public MonthlyReport(String month, HashMap<String, Integer> income, HashMap<String, Integer> expenses) {
                    monthNumber = month;
                    incomeList = income;
                    expensesList = expenses;

                }
}


