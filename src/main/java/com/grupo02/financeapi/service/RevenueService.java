package com.grupo02.financeapi.service;

import com.grupo02.financeapi.controller.dto.RevenueDto;
import com.grupo02.financeapi.service.exception.AlreadyRegisteredRevenue;
import com.grupo02.financeapi.model.Revenue;
import com.grupo02.financeapi.repository.RevenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RevenueService {

    @Autowired
    RevenueRepository repository;

    public List<Revenue> listAll() {
        return repository.findAll();
    }

    public Revenue findBy(Long id) {
        return repository.findById(id).get();
    }

    public Revenue save(RevenueDto revenueDto) throws AlreadyRegisteredRevenue {
        Revenue revenue = fromDto(revenueDto);
        List<Revenue> revenues = repository.findAll();

        boolean alreadyRegistered = revenues
                .stream()
                .anyMatch(revenue::equals);

        if(alreadyRegistered) {
            throw new AlreadyRegisteredRevenue("Receita já cadastrada");
        }

        return repository.save(revenue);
    }

    public Revenue fromDto(RevenueDto revenueDto) {
        return new Revenue(null, revenueDto.getDescription(), revenueDto.getValue(), revenueDto.getDate());
    }
}
