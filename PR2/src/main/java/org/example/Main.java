package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "https://informer.com.ua/dut/java/pr2.csv";
        TransactionCSVReader csvReader = new TransactionCSVReader();
        List<Transaction> transactions = csvReader.readTransactions(filePath);

        TransactionAnalyzer analyzer = new TransactionAnalyzer(transactions);
        TransactionReportGenerator reportGenerator = new TransactionReportGenerator();
        double totalBalance = analyzer.calculateTotalBalance();
        reportGenerator.printBalanceReport(totalBalance);

        System.out.println("Загальний баланс: " + totalBalance);

        String monthYear = "01-2024";
        int transactionsCount = analyzer.countTransactionsByMonth(monthYear);
        reportGenerator.printTransactionsCountByMonth(monthYear, transactionsCount);
        System.out.println("Кількість транзакцій за " + monthYear + ": " + transactionsCount);

        List<Transaction> topExpenses = analyzer.findTopExpenses();
        reportGenerator.printTopExpensesReport(topExpenses);

        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }
}
