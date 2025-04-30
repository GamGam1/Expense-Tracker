package com.GamyA.expense_tracker.Expenses;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "Expenses")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    private String username;

    private String category;

    private double amount;

    private String month;

    @Autowired
    public Expense(String Username, String Category, double Amount, String month){
        this.username = Username;
        if (Category == null){
            this.category = "No category";
        }else{
            this.category = Category;
        }
        this.amount = Amount;
        this.month =month;
    }

    public long getId() {
        return Id;
    }

    public String getUsername() {
        return username;
    }

    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }

    public String getMonth() {
        return month;
    }

    public void setUsername(String username) {
        username = username;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setAmount(double amount) {
        amount = amount;
    }

    public void setMonth(String month) {
        this.month = month;
    }
}
