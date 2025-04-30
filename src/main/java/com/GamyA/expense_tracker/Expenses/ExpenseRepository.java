package com.GamyA.expense_tracker.Expenses;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExpenseRepository
        extends JpaRepository<Expense, Long> {

    List<Expense> findByUsername(String Username);

    @Query("SELECT new com.GamyA.expense_tracker.Expenses.ExpenseSummaries$CategoryAndMonth(e.category, e.month, SUM(e.amount), AVG(e.total))" +
            " FROM Expense e  WHERE e.username = ?1 GROUP BY  e.category, e.month")
    List<Expense> AggSummaryMonthCategory(String Username);

    @Query("SELECT new com.GamyA.expense_tracker.Expenses.ExpenseSummaries$Category(e.category, SUM(e.total), AVG(e.amount)) " +
            "FROM Expense e WHERE e.username = ?1 GROUP BY  e.category")
    List<Expense> AggSummaryCategory(String Username);

    @Query("SELECT new com.GamyA.expense_tracker.Expenses.ExpenseSummaries$Month(e.month, SUM(e.total), AVG(e.amount)) " +
            "FROM Expense e WHERE e.username = ?1 GROUP BY e.month")
    List<Expense> AggSummaryMonth(String Username);

    void deleteByCategory(String Category);


}
