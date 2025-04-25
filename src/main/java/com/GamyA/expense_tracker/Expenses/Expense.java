package com.GamyA.expense_tracker.Expenses;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "Expenses")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    private final String Username;

    private final String Category;

    private final float Total;

    private final String Month;

    @Autowired
    public Expense(String Username, String Category, float Total, String Month){
        this.Username = Username;
        this.Category = Category;
        this.Total = Total;
        this.Month =Month;
    }


}
