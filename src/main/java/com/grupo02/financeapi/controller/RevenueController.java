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
    public ResponseEntity<List<RevenueDto>> listAll() {
        List<RevenueDto> revenuesDto = service.listAll();

        return ResponseEntity.ok(revenuesDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RevenueDto> findBy(@PathVariable Long id) {
        RevenueDto revenueDto = service.findById(id);

        return ResponseEntity.ok(revenueDto);
    }

    @GetMapping()
    public ResponseEntity<List<RevenueDto>> findByDescription(@RequestParam(name = "description") String description) {
        List<RevenueDto> revenuesDto = service.findByDescription(description);

        return ResponseEntity.ok(revenuesDto);
    }

    @GetMapping("/{year}/{month}")
    public ResponseEntity<List<RevenueDto>> findByYear(@PathVariable int year, @PathVariable int month) {
        List<RevenueDto> revenuesDto = service.findByYearAndMonth(year, month);

        return ResponseEntity.ok(revenuesDto);
    }

    @PostMapping("/save")
    public ResponseEntity<RevenueDto> save(@RequestBody RevenueDto revenueDto) {
        service.save(revenueDto);

        return ResponseEntity.ok().body(revenueDto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<RevenueDto> update(@PathVariable Long id, @RequestBody RevenueDto revenueDto) {
        service.update(id, revenueDto);

        return ResponseEntity.ok().body(revenueDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        return service.delete(id);
    }
}
