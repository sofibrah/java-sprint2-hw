import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Checker {
    // проверка на разногласия в отчетах (3 пункт меню)

        public static List<String> coincidenceSearch(HashMap<String, String> monthsList, MonthlyReport[] monthlyReport, YearlyReport yearlyReport) {
            List<String> concurrence = new ArrayList<>();

            for (String monthNumber : monthsList.keySet()) {
                int monthIndex = (Integer.parseInt(monthNumber) - 1);
                String monthName = monthsList.get(monthNumber);

                if ((monthlyReport[monthIndex] != null) && (yearlyReport.incomeList.get(monthName) != null)
                        && (yearlyReport.expensesList.get(monthName) != null)) {
                    if (!checkIfMonthsMismatch(monthIndex, monthName, monthlyReport, yearlyReport)) {
                        concurrence.add(monthName);
                    }

                } else if ((monthlyReport[monthIndex] != null) || (yearlyReport.incomeList.get(monthName) != null)
                        || (yearlyReport.expensesList.get(monthName) != null)) {
                    concurrence.add(monthName);
                }
            }
            return concurrence;
        }

        public static boolean checkIfMonthsMismatch(int monthIndex, String monthName, MonthlyReport[] monthlyReport, YearlyReport yearlyReport) {

            HashMap<String, Integer> reviewedMonthIncome = monthlyReport[monthIndex].incomeList;
            HashMap<String, Integer> reviewedMonthExpenses = monthlyReport[monthIndex].expensesList;
            int monthTotalIncome = 0;
            int monthTotalExpenses = 0;
            boolean isIncomeMatching = true;
            boolean isExpensesMatching = true;

            for (double income : reviewedMonthIncome.values()) {
                monthTotalIncome += income;
            }
            for (double expenses : reviewedMonthExpenses.values()) {
                monthTotalExpenses += expenses;
            }

            if (monthTotalIncome != yearlyReport.incomeList.get(monthName)) {
                isIncomeMatching = false;
            }
            if (monthTotalExpenses != yearlyReport.expensesList.get(monthName)) {
                isExpensesMatching = false;
            }

            return isIncomeMatching & isExpensesMatching;
        }
    }
