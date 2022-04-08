package com.grupo02.financeapi.service;

import com.grupo02.financeapi.controller.dto.ExpenseDto;
import com.grupo02.financeapi.model.Expense;
import com.grupo02.financeapi.model.Revenue;
import com.grupo02.financeapi.repository.ExpenseRepository;
import com.grupo02.financeapi.service.exception.AlreadyRegisteredExpenseException;
import com.grupo02.financeapi.service.exception.AlreadyRegisteredRevenueException;
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
    public ExpenseDto save(ExpenseDto expenseDto) throws AlreadyRegisteredExpenseException {
        Expense expense = Expense.toEntity(expenseDto);
        List<Expense> Expenses = expenseRepository.findAll();
        boolean alreadyRegistered = Expenses
                .stream()
                .anyMatch(expense::equals);

        if(alreadyRegistered) {
            throw new AlreadyRegisteredRevenueException("Despesa já cadastrada!");
        }

        return ExpenseDto.toDto(expenseRepository.save(Expense.toEntity(expenseDto)));
    }

    public ResponseEntity deleteBy(Long id) {
        return expenseRepository.findById(id)
                .map(expense -> {
                    expenseRepository.delete(expense);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }


}
