package com.ipisces42.controller;

import com.ipisces42.pojo.Stu;
import com.ipisces42.service.StuService;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fuhaixin
 * @date 2022/8/16
 **/
@Hidden
@RestController
@RequestMapping("/stu")
public class StuController {

    private final StuService skuService;

    public StuController(StuService skuService) {
        this.skuService = skuService;
    }

    @GetMapping("/getStu/{id}")
    public Stu getStu(@PathVariable(value = "id") int id) {
        return skuService.getStuInfo(id);
    }

    @GetMapping("/saveStu")
    public String saveStu() {
        skuService.saveStu();
        return "OK";
    }

    @GetMapping("/updateStu/{id}")
    public String updateStu(@PathVariable(value = "id") int id) {
        skuService.updateStu(id);
        return "OK";
    }

    @GetMapping("/deleteStu/{id}")
    public String deleteStu(@PathVariable(value = "id") int id) {
        skuService.deleteStu(id);
        return "OK";
    }
}
