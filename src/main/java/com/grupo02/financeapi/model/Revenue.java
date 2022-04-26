package com.grupo02.financeapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "TB_REVENUES")
public class Revenue implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private BigDecimal value;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;

    public Revenue() {

    }

    public Revenue(Long id, String description, BigDecimal value, LocalDate date) {
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Revenue revenue = (Revenue) o;
        return Objects.equals(description, revenue.description) && Objects.equals(date, revenue.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, date);
    }
}
