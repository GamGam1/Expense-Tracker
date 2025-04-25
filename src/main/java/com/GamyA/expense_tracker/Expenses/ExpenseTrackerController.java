package com.GamyA.expense_tracker.Expenses;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExpenseTrackerController {

    @GetMapping(value = "/")
    public String getPage(){
        return "plz work";
    }
}
