package com.grupo02.financeapi.controller;

import com.grupo02.financeapi.controller.dto.RevenueDto;
import com.grupo02.financeapi.model.Revenue;
import com.grupo02.financeapi.service.RevenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/revenues")
public class RevenueController {

    @Autowired
    RevenueService service;

    @GetMapping("/all")
    public ResponseEntity<List<Revenue>> listAll() {
        List<Revenue> revenues = service.listAll();

        return ResponseEntity.ok(revenues);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Revenue> findBy(@PathVariable Long id) {
        Revenue revenue = service.findBy(id);

        return ResponseEntity.ok(revenue);
    }

    @PostMapping("/save")
    public ResponseEntity<RevenueDto> save(@RequestBody RevenueDto revenueDto) {
        service.save(revenueDto);

        return ResponseEntity.ok().body(revenueDto);
    }
}
