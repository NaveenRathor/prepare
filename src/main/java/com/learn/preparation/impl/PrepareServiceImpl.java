package com.learn.preparation.impl;

import com.learn.preparation.entity.Prepare;
import com.learn.preparation.repo.PrepareRepo;
import com.learn.preparation.service.PrepareService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Slf4j
@Component
public class PrepareServiceImpl implements PrepareService {

    @Autowired
    PrepareRepo prepareRepo;

    @Override
    public List<Prepare> getAllData() {
        log.debug("Inside getAllData()");
        List<Prepare> preparesList = new LinkedList<>();
        try {
            preparesList = prepareRepo.findAll();
            log.debug("Exit from getAllData preparesList {}", preparesList);
            return preparesList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return preparesList;
    }

    @Override
    public Prepare insertData(Prepare prepare) {
        try{
            log.debug("Inside InsertData()");
            Prepare prepare1 = prepareRepo.save(prepare);
            log.debug("Exit from Insert Data");
            return prepare1;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
