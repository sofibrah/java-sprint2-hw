import java.util.HashMap;

public class YearlyReport {
         String currentYear;
        public HashMap<String, Integer> incomeList;
        public HashMap<String, Integer> expensesList;

        public YearlyReport(String year, HashMap<String, Integer> income, HashMap<String,Integer> expenses){
            currentYear = year;
            incomeList = income;
            expensesList = expenses;

        }
}










/*
рассматриваемый год;
прибыль по каждому месяцу;
средний расход за все имеющиеся операции в году;
средний доход за все имеющиеся операции в году.

 */

