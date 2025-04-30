package com.GamyA.expense_tracker.Expenses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    private static ExpenseRepository expenseRepository;

    @Autowired
    public ExpenseService(ExpenseRepository expenseRepository) {
        ExpenseService.expenseRepository = expenseRepository;
    }



    public List<Expense> findExpenseByUsername(String username){
        return expenseRepository.findByUsername(username);
    }

    public void saveExpense(Expense newExpense){expenseRepository.save(newExpense);
    }


}
