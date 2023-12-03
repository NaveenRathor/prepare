package com.learn.preparation.service;

import com.learn.preparation.entity.Prepare;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PrepareService {

    public List<Prepare> getAllData();
    public Prepare insertData(Prepare prepare);
}
