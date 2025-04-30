package com.GamyA.expense_tracker.Expenses;

public class ExpenseSummaries {

    public static class ByCategory {
        private String category;
        private Double totalAmount;
        private Double avgAmount;

        public ByCategory(String category, Double totalAmount, Double avgAmount) {
            this.category = category;
            this.totalAmount = totalAmount;
            this.avgAmount = avgAmount;
        }

        public Double getAvgAmount() {
            return avgAmount;
        }

        public void setAvgAmount(Double avgAmount) {
            this.avgAmount = avgAmount;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public Double getTotalAmount() {
            return totalAmount;
        }

        public void setTotalAmount(Double totalAmount) {
            this.totalAmount = totalAmount;
        }
    }

    public static class ByMonth {
        private String Month;
        private Double totalAmount;
        private Double avgAmount;

        public ByMonth(String date, Double totalAmount, Double avgAmount) {
            this.Month = date;
            this.totalAmount = totalAmount;
            this.avgAmount = avgAmount;
        }

        public String getMonth() {
            return Month;
        }

        public void setMonth(String month) {
            this.Month = month;
        }

        public Double getTotalAmount() {
            return totalAmount;
        }

        public void setTotalAmount(Double totalAmount) {
            this.totalAmount = totalAmount;
        }

        public Double getAvgAmount() {
            return avgAmount;
        }

        public void setAvgAmount(Double avgAmount) {
            this.avgAmount = avgAmount;
        }
    }

    public static class ByCategoryAndMonth {
        private String category;
        private String Month;
        private Double totalAmount;
        private Double avgAmount;

        public ByCategoryAndMonth(String category, String month, Double totalAmount, Double avgAmount) {
            this.category = category;
            this.Month = month;
            this.totalAmount = totalAmount;
            this.avgAmount = avgAmount;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getMonth() {
            return Month;
        }

        public void setMonth(String month) {
            this.Month = month;
        }

        public Double getTotalAmount() {
            return totalAmount;
        }

        public void setTotalAmount(Double totalAmount) {
            this.totalAmount = totalAmount;
        }

        public Double getAvgAmount() {
            return avgAmount;
        }

        public void setAvgAmount(Double avgAmount) {
            this.avgAmount = avgAmount;
        }
    }
}
