package com.grupo02.financeapi.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.grupo02.financeapi.model.Revenue;

import java.math.BigDecimal;
import java.util.Date;

public class RevenueDto {

    private String description;
    private BigDecimal value;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date date;

    public RevenueDto() {

    }

    public RevenueDto(Revenue revenue) {
        this.description = revenue.getDescription();
        this.value = revenue.getValue();
        this.date = revenue.getDate();
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Date getDate() {
        return date;
    }
}
