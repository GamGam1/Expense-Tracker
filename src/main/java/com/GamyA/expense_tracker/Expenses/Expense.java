package com.GamyA.expense_tracker.Expenses;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.YearMonth;


@Entity
@Table(name = "Expenses")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @NotBlank(message = "You must enter a username")
    private String username;

    private String category;

    @NotNull(message = "amount is required")
    @Min(value = 0, message = "amount must be positive")
    private Double amount;

    @NotNull(message = "month must not be blank")
    @Pattern(regexp = "^(January|February|March|April|May|June|July|August|September|October|November|December)-\\d{4}$",
            message = "Month must be in the format 'Month-YYYY', e.g., 'April-2025'")
    private String month;

    public Expense() {
    }

    @Autowired
    public Expense(String username, String category, Double amount, String month){
        this.username = username;
        if (category == null){
            this.category = "No category";
        }else{
            this.category = category;
        }
        this.amount = amount;
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

    public Double getAmount() {
        return amount;
    }

    public String getMonth() {
        return month;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setMonth(String month) {
        this.month = month;
    }
}
