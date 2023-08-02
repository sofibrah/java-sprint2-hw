import java.util.HashMap;

public class MonthlyReport {
    public String monthName;
    public HashMap<String, Integer> incomeList;
    public HashMap<String, Integer> expensesList;

    public MonthlyReport(String month, HashMap<String, Integer> income, HashMap<String, Integer> expenses) {
            monthName = month;
            incomeList = income;
            expensesList = expenses;
        }

    }



//сюда положим данные
//  месяц
//доходы
// траты




/*
инфа которую должен выводить месячный отчет
        название месяца;
        самый прибыльный товар, название товара и сумму;
        самую большую трату, название товара и сумму.
*/