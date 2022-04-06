package com.grupo02.financeapi.service;

import com.grupo02.financeapi.controller.dto.ExpenseDto;
import com.grupo02.financeapi.model.Expense;
import com.grupo02.financeapi.repository.ExpenseRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ExpenseService {

    private ExpenseRepository expenseRepository;


    public List<ExpenseDto> getAll() {
        List<ExpenseDto> listExpenseDto = new ArrayList<>();
        expenseRepository.findAll()
                .stream()
                .forEach( expense ->
                        listExpenseDto.add(ExpenseDto.toDto(expense)));
        return listExpenseDto;
    }


    public ResponseEntity<ExpenseDto> findBy(Long id) {
        return expenseRepository.findById(id)
                .map(expense -> ResponseEntity.ok(ExpenseDto.toDto(expense)))
                .orElse(ResponseEntity.notFound().build());
    }


    @Transient
    public ExpenseDto save(ExpenseDto expenseDto) {
        return ExpenseDto.toDto(expenseRepository.save(Expense.toEntity(expenseDto)));
    }
}
