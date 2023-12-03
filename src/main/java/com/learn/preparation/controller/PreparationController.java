package com.learn.preparation.controller;

import com.learn.preparation.entity.Prepare;
import com.learn.preparation.restcontroller.PreparationRestController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/vi")
public class PreparationController {
    @Autowired
    PreparationRestController preparationRestController;

    @GetMapping("/data")
    public String getAllData(Model model){
        try{
            log.debug("Inside getAllData");
            List<Prepare> prepareList = preparationRestController.getAllDataApi();
            model.addAttribute("prepareList", prepareList);
            log.debug("Exit from getAllData");
            return "prepare";
        }catch (Exception e){
            e.printStackTrace();
            return "Exception Throws...";
        }
    }
//    https://www.youtube.com/watch?v=HUB_KQcEHnA&ab_channel=DailyCodeBuffer
//    https://www.dariawan.com/tutorials/spring/spring-boot-mustache-crud-example/
    @GetMapping("/add")
    public String addPrepareView(Model model){
        Prepare prepare = new Prepare();
        model.addAttribute("add", true);
        model.addAttribute("prepare", prepare);
        return "addprepare";
    }

    @PostMapping("/add")
    public String addData(Model model, @ModelAttribute("prepare") Prepare prepare){
        log.debug("Inside addData()");
        try{
            Prepare prepare1 = preparationRestController.saveData(prepare);
            log.debug("Exit from saveData response {}", prepare1);
            return "redirect:/vi/add";
        }catch (Exception e){
            e.printStackTrace();
            return "Exception Throws ...";
        }

    }
}
