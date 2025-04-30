package com.GamyA.expense_tracker.Expenses;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.YearMonth;
import java.util.List;

@Configuration
public class ExpenseConfig {

    @Bean
    CommandLineRunner commandLineRunner (ExpenseRepository repository) {
        return args -> {
            String april = "April-2025";
            String march = "March-2025";
            Expense food1 = new Expense("gamy", "food", 20.00, april);
            Expense food2 = new Expense("gamy", "food", 10.00, april);
            Expense food3 = new Expense("gamy", "food", 15.50, april);
            Expense food4 = new Expense("gamy", "food", 25.00, april);
            Expense food5 = new Expense("gamy", "food", 20.00, march);
            Expense food6 = new Expense("gamy", "food", 10.00, march);
            Expense fun1 = new Expense("gamy", "fun", 25.00, march);
            Expense fun2 = new Expense("gamy", "fun", 35.00, march);
            Expense fun3 = new Expense("gamy", "fun", 55.00, april);
            Expense fun4 = new Expense("gamy", "fun", 25.00, march);
            Expense fun5 = new Expense("gamy", "fun", 125.00, march);
            Expense fun6 = new Expense("gamy", "fun", 55.00, march);
            repository.saveAll(List.of(food1, food2, food3, food4,food5, food6, fun1, fun2, fun3, fun4, fun5, fun6));
        };
    }
}
