package com.GamyA.expense_tracker.Expenses;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

        List<Expense> result = expenseService.findExpenseByUsername(user);

        if (result.isEmpty()){
            throw new IllegalArgumentException("User not found in database");
        }

        return result;
    }
    @GetMapping(value="/api/{user}/filter")
    public List<Expense> getUserExpensesFilterByMonthCategory(@PathVariable String user,
                                                              @RequestParam(required = false) List<String> category, @RequestParam(required = false) List<String> month){

        List<Expense> result = expenseService.findExpenseByUserMonthCategory(user,category,month);

        if (result.isEmpty()){
            throw new IllegalArgumentException("User/Month/Category not found in database");
        }

        return result;
    }

    @GetMapping(value="/api/{user}/stats/category")
    public  List<ExpenseSummaries.ByCategory> getStatsCategory(@PathVariable String user){

        List<ExpenseSummaries.ByCategory> result = expenseService.getStatsCategory(user);

        if (result.isEmpty()){
            throw new IllegalArgumentException("User not found in database");
        }

        return result;
    }

    @GetMapping(value="/api/{user}/stats/month")
    public  List<ExpenseSummaries.ByMonth> getStatsMonth(@PathVariable String user){

        List<ExpenseSummaries.ByMonth> result = expenseService.getStatsMonth(user);

        if (result.isEmpty()){
            throw new IllegalArgumentException("User not found in database");
        }

        return result;
    }

    @GetMapping(value="/api/{user}/stats/both")
    public  List<ExpenseSummaries.ByCategoryAndMonth> getStatsCategoryAndMonth(@PathVariable String user){

        List<ExpenseSummaries.ByCategoryAndMonth> result = expenseService.getStatsCategoryAndMonth(user);

        if (result.isEmpty()){
            throw new IllegalArgumentException("User not found in database");
        }

        return result;
    }

    @PostMapping(value = "/api/save")
    public void saveExpense(@Valid @RequestBody Expense newExpense){
        expenseService.saveExpense(newExpense);
    }

    @PutMapping(value = "/api/update/{id}")
    public void updateExpense(@Valid @RequestBody UpdateExpense newExpense, @PathVariable long id) {
        //check if id is valid

        Expense oldExpense = expenseService.findById(id).orElseThrow(() -> new IllegalArgumentException("Id not found"));

        expenseService.updateExpense(newExpense, oldExpense);
    }

    @DeleteMapping(value = "/api/delete/single/{id}")
    public void deleteExpense(@PathVariable long id){
        expenseService.deleteExpense(id);
    }

    @DeleteMapping(value = "/api/delete/{user}")
    public void deleteExpenseByCategory(@PathVariable String user,@RequestParam List<String> category){
        expenseService.deleteByCategoryAndUser(category,user);
    }




}
