package com.easyimmo.property.service;

import java.util.List;

import com.easyimmo.property.dto.PropertyCriteria;
import com.easyimmo.property.model.Property;

public interface IPropertyService {

    /**
     * This method search for a property, based on a given id
     * @param id id of the property that you search
     * @return the wanted property
     */
    Property getById(Integer id);

    /**
     * This method search for all the properties
     * @return list of all the properties
     */
    List<Property> getAll(PropertyCriteria propertyCriteria);

    /**
     * This method allows you to update a property
     * @param property updated property
     * @return updated property
     */
    Property updateProperty(Integer id, Property property);

    /**
     * This method allows you to add a property
     * @param property property that you want to add
     * @return the added property
     */
    Property addProperty(Property property);

    /**
     * This method allows you to delete a property, for a given id
     * @param id of the property that you want to delete
     */
    void deleteById(Integer id);
}
