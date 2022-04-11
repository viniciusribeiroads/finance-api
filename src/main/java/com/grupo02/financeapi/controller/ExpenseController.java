package com.grupo02.financeapi.controller;

import com.grupo02.financeapi.controller.dto.ExpenseDto;
import com.grupo02.financeapi.model.Expense;
import com.grupo02.financeapi.service.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
@AllArgsConstructor
public class ExpenseController {

    private ExpenseService expenseService;

    @GetMapping("/all")
    public List<ExpenseDto> getAll(){
        return expenseService.getAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ExpenseDto> findBy(@PathVariable Long id){
        return expenseService.findBy(id);
    }

    @PostMapping
    @RequestMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public ExpenseDto save(@RequestBody ExpenseDto expenseDto){
        return expenseService.save(expenseDto);
    }

    @DeleteMapping(path = "/remove/{id}")
    public ResponseEntity deleteBy(@PathVariable Long id){
        return expenseService.deleteBy(id);
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<Expense> update(@PathVariable Long id, ExpenseDto expenseDto){
        return expenseService.update(id, expenseDto);
    }





}
