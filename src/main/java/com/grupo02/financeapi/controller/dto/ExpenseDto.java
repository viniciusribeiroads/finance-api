package com.grupo02.financeapi.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.grupo02.financeapi.model.Expense;

import java.math.BigDecimal;
import java.util.Date;

public class ExpenseDto {

    private Long id;
    private String description;
    private BigDecimal value;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date date;

    public ExpenseDto() {
    }

    public ExpenseDto(Long id, String description, BigDecimal value, Date date) {
        this.id = id;
        this.description = description;
        this.value = value;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public static ExpenseDto toDto(Expense expense) {
        return new ExpenseDto(
                expense.getId(),
                expense.getDescription(),
                expense.getValue(),
                expense.getDate()
        );
    }
}
