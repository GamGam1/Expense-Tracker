package com.GamyA.expense_tracker.Expenses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ExpenseService {

    private static ExpenseRepository expenseRepository;

    @Autowired
    public ExpenseService(ExpenseRepository expenseRepository) {
        ExpenseService.expenseRepository = expenseRepository;
    }

    /* Methods */

    public List<Expense> findExpenseByUsername(String username){
        return expenseRepository.findByUsername(username);
    }

    public List<Expense> findExpenseByUserMonthCategory(String username, String category, String month){
        return expenseRepository.findByUsernameCategoryMonth(username, category, month);
    }

    public List<ExpenseSummaries> getStats(String username, String filters){
        if (filters.equals("Month")) {
            return expenseRepository.AggSummaryMonth(username);
        } else if (filters.equals("Category")) {
            return expenseRepository.AggSummaryCategory(username);
        } else if (filters.contains("Month") && filters.contains("Category")) {
            return expenseRepository.AggSummaryMonthCategory(username);
        }else{
            throw new IllegalArgumentException("filters must be either Category, Month or MonthAndCategory");
        }

    }

    public void saveExpense(Expense newExpense){
        expenseRepository.save(newExpense);
    }

    public


}
