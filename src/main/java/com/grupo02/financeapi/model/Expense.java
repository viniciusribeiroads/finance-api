package com.grupo02.financeapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.grupo02.financeapi.controller.dto.ExpenseDto;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "TB_EXPENSES")
public class Expense implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private BigDecimal value;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date date;

    public Expense() {

    }

    public Expense(Long id, String description, BigDecimal value, Date date) {
        this.id = id;
        this.description = description;
        this.value = value;
        this.date = date;
    }

    public static Expense toEntity(ExpenseDto expenseDto) {
        return new Expense(
                expenseDto.getId(),
                expenseDto.getDescription(),
                expenseDto.getValue(),
                expenseDto.getDate()
        );
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expense expense = (Expense) o;
        return Objects.equals(description, expense.description) && Objects.equals(date, expense.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, date);
    }
}
