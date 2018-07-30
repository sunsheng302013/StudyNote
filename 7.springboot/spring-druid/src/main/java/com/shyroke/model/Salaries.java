package com.shyroke.model;

import java.util.Date;

public class Salaries extends SalariesKey {
    private Integer salary;

    private Date toDate;

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }
}