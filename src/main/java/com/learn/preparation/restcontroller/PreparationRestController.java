package com.learn.preparation.restcontroller;

import com.learn.preparation.entity.Prepare;
import com.learn.preparation.service.PrepareService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class PreparationRestController {
    @Autowired
    PrepareService prepareService;

    public List<Prepare> getAllDataApi(){
        log.debug("Inside PreparationController");
        List<Prepare> prepareList = prepareService.getAllData();
        log.debug("Exit from PreparationController");
        return prepareList;
    }

    public Prepare saveData(@RequestBody Prepare prepare){
        log.debug("Inside saveData()");
        Prepare prepare1 = prepareService.insertData(prepare);
        log.debug("Exit from saveData response {}", prepare1);
        return prepare1;
    }
}
