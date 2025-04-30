package com.GamyA.expense_tracker.Expenses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExpenseTrackerController {

    private static ExpenseService expenseService;

    @Autowired
    public ExpenseTrackerController(ExpenseService expenseService) {
        ExpenseTrackerController.expenseService = expenseService;
    }

    @GetMapping(value = "/")
    public String getPage(){
        return "plz work";
    }

    @GetMapping(value="/api/{user}")
    public List<Expense> getUserExpenses(@PathVariable String user){
        return expenseService.findExpenseByUsername(user);
    }




}
