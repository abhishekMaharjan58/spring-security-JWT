package com.example.securityJWT.service;

import com.example.securityJWT.model.Unit;
import com.example.securityJWT.pojo.UnitPojo;

public interface UnitService {

    Unit checkIt(Integer id) throws Exception;

    Unit saveUnit(UnitPojo unitPojo) throws Exception;
}
