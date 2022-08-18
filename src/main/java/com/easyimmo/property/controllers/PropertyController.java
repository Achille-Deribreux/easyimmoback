package com.easyimmo.property.controllers;

import java.util.List;

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

import com.easyimmo.common.utils.Converter;
import com.easyimmo.property.dto.PropertyCriteria;
import com.easyimmo.property.dto.PropertyDetails;
import com.easyimmo.property.dto.PropertyDto;
import com.easyimmo.property.dto.PropertySummary;
import com.easyimmo.property.model.Property;
import com.easyimmo.property.service.PropertyService;

@RestController
@RequestMapping("/property")
public class PropertyController {

    private final PropertyService propertyService;

    private final Converter converter;

    public PropertyController(PropertyService propertyService, Converter converter) {
        this.propertyService = propertyService;
        this.converter = converter;
    }

    private final Logger logger = LoggerFactory.getLogger(PropertyController.class);

    /**
     * This method answer to a request at : /property/getById and returns a response entity with the wanted property
     * @param id id of the wanted property
     * @return response entity with the wanted property and status code 200 if everything is ok
     */
    @GetMapping(value="/getById")
    public ResponseEntity<PropertyDetails> getPropertyById(@RequestParam(value="id") Integer id){
        logger.info("get request received at property/getById for id : {}", id);
        return new ResponseEntity<>(converter.convertToDetails(propertyService.getById(id)), HttpStatus.OK);
    }

    /**
     * This method answer to a request at : /property/getAll and returns a response entity with the all the properties
     * @return a list of all the properties and status code 200 if everything is ok
     */
    @GetMapping(value="/getAll")
    public ResponseEntity<List<PropertySummary>> getAllProperties(
            @RequestParam(value = "type",required=false)Property.Type type,
            @RequestParam(value = "rentType",required=false)Property.RentType rentType,
            @RequestParam(value = "name",required=false)String name,
            @RequestParam(value = "minPrice",required=false)Integer minPrice,
            @RequestParam(value = "maxPrice",required=false)Integer maxPrice,
          @RequestParam(value="pageNr",required=false)Integer pageNr,
            @RequestParam(value="pageSize",required=false)Integer pageSize
    ){
        logger.info("get request received at /property/getAll");
        PropertyCriteria propertyCriteria = new PropertyCriteria()
                .rentType(rentType)
                .type(type)
                .name(name)
                .lowPrice(minPrice)
                .highPrice(maxPrice)
                .pageNumber(pageNr)
                .pageSize(pageSize);
        List<Property> result = propertyService.getAll(propertyCriteria);
        if (result.isEmpty()){
            return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(converter.convertPropertyList(result), HttpStatus.OK);
    }

    @PostMapping(value="/add")
    public ResponseEntity<PropertyDto> createProperty(@RequestBody PropertyDto property){
        return new ResponseEntity<>(converter.convert(propertyService.addProperty(converter.convert(property))),HttpStatus.CREATED);
    }


    @PutMapping(value="/update")
    public ResponseEntity<PropertyDto> updateProperty(@RequestParam(value = "id")Integer id,@RequestBody PropertyDto property){
        return new ResponseEntity<>(converter.convert(propertyService.updateProperty(id,converter.convert(property))),HttpStatus.CREATED);
    }

    /**
     * This method answer to a request at : /property/deleteById and delete the wanted property
     * @param id id of the property that you want to delete
     * @return status code 200 and success message if everything is ok
     */
    @DeleteMapping(value = "/deleteById")
    public ResponseEntity<String> deletePropertyById(@RequestParam(value = "id") Integer id){
        logger.info("delete request received at : /property/deleteById for id : {}", id);
        propertyService.deleteById(id);
        return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
    }


}
