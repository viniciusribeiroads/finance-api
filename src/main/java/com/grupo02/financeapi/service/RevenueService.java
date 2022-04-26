package com.grupo02.financeapi.service;

import com.grupo02.financeapi.controller.dto.RevenueDto;
import com.grupo02.financeapi.model.Revenue;
import com.grupo02.financeapi.repository.RevenueRepository;
import com.grupo02.financeapi.service.exception.AlreadyRegisteredRevenueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class RevenueService {

    @Autowired
    RevenueRepository repository;

    public List<RevenueDto> listAll() {
        List<Revenue> revenues = repository.findAll();

        return revenues
                .stream()
                .map(RevenueDto::new)
                .collect(Collectors.toList());
    }

    public RevenueDto findById(Long id) {
        Revenue revenue = repository.findById(id).get();

        return new RevenueDto(revenue);
    }

    public List<RevenueDto> findByDescription(String description) {
        List<Revenue> revenues = repository.findByDescription(description);

        return revenues.stream().map(RevenueDto::new).collect(Collectors.toList());
    }

    public Revenue save(RevenueDto revenueDto) {
        Revenue revenue = fromDto(revenueDto);
        List<Revenue> revenues = repository.findAll();

        boolean alreadyRegistered = revenues
                .stream()
                .anyMatch(revenue::equals);

        if(alreadyRegistered) {
            throw new AlreadyRegisteredRevenueException("Receita já cadastrada");
        }

        return repository.save(revenue);
    }

    public void update(Long id, RevenueDto revenueDto) {
        Revenue newRevenue = fromDto(revenueDto);
        Revenue revenue = repository.findById(id).get();

        if(revenue != null) {
            updateRevenue(revenue, revenueDto);
            repository.save(revenue);
        }
    }

    private void updateRevenue(Revenue revenue, RevenueDto revenueDto) {
        revenue.setDescription(revenueDto.getDescription());
        revenue.setValue(revenueDto.getValue());
        revenue.setDate(revenueDto.getDate());
    }

    public Revenue fromDto(RevenueDto revenueDto) {
        return new Revenue(null, revenueDto.getDescription(), revenueDto.getValue(), revenueDto.getDate());
    }

    public ResponseEntity delete(Long id) {
        return repository.findById(id)
                .map(revenue -> {
                        repository.delete(revenue);
                        return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    public List<RevenueDto> findByYearAndMonth(int year, int month) {
        List<Revenue> revenues = repository.findByYearAndMonth(year, month);

        return revenues.stream().map(RevenueDto::new).collect(Collectors.toList());
    }
}
