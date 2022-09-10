package com.easyimmo.bankloan.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.easyimmo.bankloan.dto.BankloanBody;
import com.easyimmo.bankloan.dto.BankloanDetails;
import com.easyimmo.bankloan.model.Bankloan;
import com.easyimmo.bankloan.service.BankloanService;
import com.easyimmo.common.utils.Converter;

@RestController
@RequestMapping("/bankloan")
public class BankloanController {

    private final Logger logger = LoggerFactory.getLogger(BankloanController.class);

    private final BankloanService bankloanService;

    private final Converter converter;

    public BankloanController(BankloanService bankloanService, Converter converter) {
        this.bankloanService = bankloanService;
        this.converter = converter;
    }

    @GetMapping(value="/getById")
    public ResponseEntity<BankloanDetails>getFeeById(@RequestParam(value="id")Integer id){
        return new ResponseEntity<>(converter.convertToBankloanDetails(bankloanService.getById(id)), HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<BankloanDetails> addBankloan (@RequestBody BankloanBody bankloanBody){
        Bankloan bankloan = converter.convertToBankloan(bankloanBody);
        return new ResponseEntity<>(converter.convertToBankloanDetails(bankloanService.addBankloan(bankloan)), HttpStatus.CREATED);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<BankloanDetails> editBankloan (
            @RequestParam(value = "id")Integer id,
            @RequestBody BankloanBody bankloanBody){
        Bankloan bankloan = converter.convertToBankloan(bankloanBody);
        return new ResponseEntity<>(converter.convertToBankloanDetails(bankloanService.updateBankloan(id,bankloan)), HttpStatus.CREATED);
    }

    @DeleteMapping(value="/deleteById")
    public ResponseEntity<String> deleteBankloanById(@RequestParam(value="id")Integer id){
        bankloanService.deleteBankloan(id);
        return new ResponseEntity<>("successfully deleted", HttpStatus.OK);
    }
}
