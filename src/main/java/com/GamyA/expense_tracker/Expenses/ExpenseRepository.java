package com.GamyA.expense_tracker.Expenses;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExpenseRepository
        extends JpaRepository<Expense, Long> {

    List<Expense> findByUsername(String Username);

    @Query("SELECT e FROM Expenses e WHERE e.username = ?1 " +
            "AND (?2 IS NULL OR category = ?2) AND (?3 IS NULL OR month = ?3)")
    List<Expense> findByUsernameCategoryMonth(String Username, String Category, String Month);

    @Query("SELECT new com.GamyA.expense_tracker.Expenses.ExpenseSummaries$CategoryAndMonth(e.category, e.month, SUM(e.amount), AVG(e.total))" +
            " FROM Expense e  WHERE e.username = ?1 GROUP BY  e.category, e.month")
    List<ExpenseSummaries.ByCategoryAndMonth> AggSummaryMonthCategory(String Username);

    @Query("SELECT new com.GamyA.expense_tracker.Expenses.ExpenseSummaries$Category(e.category, SUM(e.total), AVG(e.amount)) " +
            "FROM Expense e WHERE e.username = ?1 GROUP BY  e.category")
    List<ExpenseSummaries.ByCategory> AggSummaryCategory(String Username);

    @Query("SELECT new com.GamyA.expense_tracker.Expenses.ExpenseSummaries$Month(e.month, SUM(e.total), AVG(e.amount)) " +
            "FROM Expense e WHERE e.username = ?1 GROUP BY e.month")
    List<ExpenseSummaries.ByMonth> AggSummaryMonth(String Username);

    void deleteByCategory(String Category);


}
