package com.easyimmo.bankloan.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @PostMapping(value = "/add")
    public ResponseEntity<BankloanDetails> addBankloan (@RequestBody BankloanBody bankloanBody){
        Bankloan bankloan = converter.convertToBankloan(bankloanBody);
        return new ResponseEntity<>(converter.convertToBankloanDetails(bankloanService.addBankloan(bankloan)), HttpStatus.CREATED);
    }
}
