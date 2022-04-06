package com.grupo02.financeapi.repository;

import com.grupo02.financeapi.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
