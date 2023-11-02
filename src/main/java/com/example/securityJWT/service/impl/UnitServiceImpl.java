package com.example.securityJWT.service.impl;

import com.example.securityJWT.model.Unit;
import com.example.securityJWT.pojo.UnitPojo;
import com.example.securityJWT.repository.UnitRepo;
import com.example.securityJWT.service.UnitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UnitServiceImpl implements UnitService {
    private final UnitRepo unitRepo;

    @Override
    public Unit checkIt(Integer id) throws Exception {
        Optional<Unit> optionalUnit = unitRepo.findByUnitId(id);
        if (optionalUnit.isPresent())
            return optionalUnit.get();
        throw new Exception("Id Not Found");
    }

    @Override
    public Unit saveUnit(UnitPojo unitPojo) throws Exception {
        Unit unit;
        if (unitPojo.getId() != null)
            unit = checkIt(unitPojo.getId());
        else
            unit = new Unit();
        unit.setName(unitPojo.getUnitName());
        Unit result = unitRepo.save(unit);
        unitPojo.setId(result.getId());
        return result;
    }
}
