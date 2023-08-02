import java.util.HashMap;

public class ReportsDemo {
    public static void YDemo(HashMap<String, String> monthList, String currentYear, HashMap<String,Integer> imcomeList, HashMap<String, Integer> expensesList){
       double expensesSum = 0;
       double incomeSum = 0;
       System.out.println("Рассматриваемый год: " + currentYear);
       for (String monthName : monthList.values()){
           if (expensesList.get(monthName) != null && imcomeList.get(monthName) != null){
               System.out.println("Прибыль за " + monthName + " составила: " + (imcomeList.get(monthName) - expensesList.get(monthName)));
           }
       }
       for (String monthName : monthList.values()){
           if (expensesList.get(monthName) != null && imcomeList.get(monthName) != null){
               expensesSum += expensesList.get(monthName);
               incomeSum += imcomeList.get(monthName);
           }
       }
       System.out.println("Средний расход за все месяцы в году: " + expensesSum / expensesList.size());
       System.out.println("Cредний доход за все месяцы в году: " + incomeSum / imcomeList.size());
    }
    public static void MDemo(HashMap<String,String>monthList, MonthlyReport[] monthlyReports){
        for (String monthNumber : monthList.keySet()){
            int monthIndex = (Integer.parseInt(monthNumber) - 1);
        if (monthlyReports[monthIndex] != null){
            HashMap<String, Integer>selectedMonthIncome = monthlyReports[monthIndex].incomeList;
            HashMap<String, Integer>selectedMonthExpense = monthlyReports[monthIndex].expensesList;
            int maxIncome = 0;
            int maxExpense = 0;
            String maxIncomeItem = null;
            String maxExpenseItem = null;

            for (String product : selectedMonthIncome.keySet()){
                int income = selectedMonthExpense.get(product); //доход
                if (maxIncome < income){
                    maxIncome = income;
                    maxIncomeItem = product;
                }
            }
            for (String product : selectedMonthExpense.keySet()){
                int income = selectedMonthExpense.get(product);
                if (maxExpense < income){
                    maxExpense = income;
                    maxExpenseItem = product;
                }
            }
            System.out.println("Месяц: " + monthList.get(monthNumber));
            System.out.println("Самый прибыльный товар: " + maxIncomeItem + " " + maxIncome);
            System.out.println("Самая большая трата " + maxExpenseItem + " " + maxExpense);
        }
        }
    }
}
         // Вывести информацию о годовом отчёте

          //вывести инф о месячном отчете





