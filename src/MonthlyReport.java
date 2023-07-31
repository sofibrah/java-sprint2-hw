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

//инфа которую должен выводить месячный отчетназвание месяца; самый прибыльный товар, название товара и сумму; самую большую трату, название товара и сумму.

