package com.easyimmo.bankloan.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easyimmo.bankloan.service.BankloanService;

@RestController
@RequestMapping("/bankloan")
public class BankloanController {

    private final Logger logger = LoggerFactory.getLogger(BankloanController.class);

    private final BankloanService bankloanService;

    public BankloanController(BankloanService bankloanService) {
        this.bankloanService = bankloanService;
    }
}
