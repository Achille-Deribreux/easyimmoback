package com.easyimmo.property.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.easyimmo.common.exception.PropertyNotFoundException;
import com.easyimmo.common.utils.CurrentUser;
import com.easyimmo.common.utils.CustomValidator;
import com.easyimmo.property.dto.PropertyCriteria;
import com.easyimmo.property.model.Property;
import com.easyimmo.property.repository.PropertyRepository;
import com.easyimmo.property.util.UpdatePropertyHelper;
import com.easyimmo.user.service.UserService;

@Service
public class PropertyService implements IPropertyService {

    private final Logger logger = LoggerFactory.getLogger(PropertyService.class);

    private final PropertyRepository propertyRepository;

    private final CustomValidator validator;

    private final UserService userService;

    public PropertyService(PropertyRepository propertyRepository, CustomValidator validator, UserService userService) {
        this.propertyRepository = propertyRepository;
        this.validator = validator;
        this.userService = userService;
    }

    @Override
    public Property getById(Integer id) {
        logger.info("search in repository {}",id);
        Property property = propertyRepository.findById(id).orElseThrow(() -> new PropertyNotFoundException("id" +id));
        userService.checkUser(property.getUserId());
        return property;
    }

    @Override
    public List<Property> getAll(PropertyCriteria propertyCriteria) {
        logger.info("get all from repository");
        propertyCriteria.userId(userService.getUserId(CurrentUser.getCurrentUserName()));
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
        property.userId(userService.getUserId(CurrentUser.getCurrentUserName()));
        validator.validate(property);
        logger.info("add property with name : {}", property.getName());
        return propertyRepository.save(property);
    }

    @Override
    public void deleteById(Integer id) {
        logger.info("delete property for id : {}", id);
        Property property = getById(id);
        userService.checkUser(property.getUserId());
        propertyRepository.delete(property);
    }
}
