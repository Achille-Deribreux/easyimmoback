package com.easyimmo.property.service;

import com.easyimmo.common.utils.CustomValidator;
import com.easyimmo.property.dto.PropertyCriteria;
import com.easyimmo.common.exception.PropertyNotFoundException;
import com.easyimmo.property.model.Property;
import com.easyimmo.property.repository.PropertyRepository;
import com.easyimmo.property.util.UpdatePropertyHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService implements IPropertyService {

    private final Logger logger = LoggerFactory.getLogger(PropertyService.class);

    private final PropertyRepository propertyRepository;

    private final CustomValidator validator;

    public PropertyService(PropertyRepository propertyRepository, CustomValidator customValidator) {
        this.propertyRepository = propertyRepository;
        this.validator = customValidator;
    }

    @Override
    public Property getById(Integer id) {
        logger.info("search in repository {}",id);
        return propertyRepository.findById(id).orElseThrow(() -> new PropertyNotFoundException("id" +id));
    }

    @Override
    public List<Property> getAll(PropertyCriteria propertyCriteria) {
        logger.info("get all from repository");
        return propertyRepository.findPropertyByMultipleCriteria(propertyCriteria);
    }

    @Override
    public Property updateProperty(Integer id, Property property) {
        logger.info("update property for property id : {}", property);
        UpdatePropertyHelper updatePropertyHelper = UpdatePropertyHelper.of(getById(id));
        Property updatedProperty = updatePropertyHelper.build(property);
        return propertyRepository.save(updatedProperty);
    }

    @Override
    public Property addProperty(Property property) {
        validator.validate(property);
        logger.info("add property with name : {}", property.getName());
        return propertyRepository.save(property);
    }

    @Override
    public void deleteById(Integer id) {
        logger.info("delete property for id : {}", id);
        Property property = getById(id);
        propertyRepository.delete(property);
    }
}
