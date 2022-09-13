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

    /**
     * This method answer to a request at : /bankloan/getById and returns a response entity with the wanted bankloan
     * @param id id of the wanted bankloan
     * @return response entity with the bankloan you want and code 200 if everything is ok
     */
    @GetMapping(value="/getById")
    public ResponseEntity<BankloanDetails>getFeeById(@RequestParam(value="id")Integer id){
        logger.info("get request received at bankloan/getById for id : {}", id);
        return new ResponseEntity<>(converter.convertToBankloanDetails(bankloanService.getById(id)), HttpStatus.OK);
    }

    /**
     * This method answer to a request at : /bankloan/add and returns a response entity with the added bankloan
     * @param bankloanBody bankloan to add
     * @return response entity with the added bankloan and status code 201 if everything is ok
     */
    @PostMapping(value = "/add")
    public ResponseEntity<BankloanDetails> addBankloan (@RequestBody BankloanBody bankloanBody){
        logger.info("post request received at bankloan/add for fee : {}", bankloanBody);
        Bankloan bankloan = converter.convertToBankloan(bankloanBody);
        return new ResponseEntity<>(converter.convertToBankloanDetails(bankloanService.addBankloan(bankloan)), HttpStatus.CREATED);
    }

    /*
     * This method answer to a request at : /bankloan/update and returns a response entity with the updated bankloan
     * @param id id of the bankloan you want to update
     * @param bankloanBody fields you want to update
     * @return response entity with the updated bankloan and status code 201 if everything is ok
     */
    @PutMapping(value = "/update")
    public ResponseEntity<BankloanDetails> editBankloan (
            @RequestParam(value = "id")Integer id,
            @RequestBody BankloanBody bankloanBody){
        logger.info("put request received at bankloan/update for id : {} and fee : {}", id, bankloanBody);
        Bankloan bankloan = converter.convertToBankloan(bankloanBody);
        return new ResponseEntity<>(converter.convertToBankloanDetails(bankloanService.updateBankloan(id,bankloan)), HttpStatus.CREATED);
    }

    /**
     * This method answer to a request at : /bankloan/delete and returns a string
     * @param id id of the bankloan to delete
     * @return string and status code 200 if everything is ok
     */
    @DeleteMapping(value="/deleteById")
    public ResponseEntity<String> deleteBankloanById(@RequestParam(value="id")Integer id){
        logger.info("delete request received at bankloan/deleteById for id : {}", id);
        bankloanService.deleteBankloan(id);
        return new ResponseEntity<>("successfully deleted", HttpStatus.OK);
    }
}
