package com.easyimmo.property.repository;

import com.easyimmo.common.utils.BasicUtils;
import com.easyimmo.property.dto.PropertyCriteria;
import com.easyimmo.property.model.Property;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class CustomPropertyRepositoryImpl implements CustomPropertyRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Property> findPropertyByMultipleCriteria(PropertyCriteria propertyCriteria) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Property> criteriaQuery = criteriaBuilder.createQuery(Property.class);

        Root<Property> propertyRoot = criteriaQuery.from(Property.class);
        BasicUtils.ConditionalList<Predicate> conditionalList = BasicUtils.ConditionalList.of(new ArrayList<>());
        conditionalList.add(propertyCriteria.getRentType()!=null,()->criteriaBuilder.equal(propertyRoot.get("rentType"),propertyCriteria.getRentType()))
        .add(propertyCriteria.getType()!=null,()->criteriaBuilder.equal(propertyRoot.get("type"),propertyCriteria.getType()))
        .add(propertyCriteria.getLowPrice()!=null,()->criteriaBuilder.greaterThanOrEqualTo(propertyRoot.get("buyPrice"),propertyCriteria.getLowPrice()))
        .add(propertyCriteria.getHighPrice()!=null,()->criteriaBuilder.lessThanOrEqualTo(propertyRoot.get("buyPrice"),propertyCriteria.getHighPrice()))
        .add(propertyCriteria.getName()!=null,()->criteriaBuilder.like((criteriaBuilder.upper(propertyRoot.get("name"))),toLike(propertyCriteria.getName())));
        criteriaQuery.where(conditionalList.toList().toArray(new Predicate[0]));
        criteriaQuery.orderBy(criteriaBuilder.desc(propertyRoot.get("buyPrice")));
        TypedQuery<Property> query = entityManager.createQuery(criteriaQuery);

        if(propertyCriteria.getPageSize()!=null && propertyCriteria.getPageNumber()!=null)
            query.setMaxResults(propertyCriteria.getPageSize()).setFirstResult(propertyCriteria.getPageNumber() * propertyCriteria.getPageSize());
        return query.getResultList();
    }

    private String toLike(String value){
        if(value.contains("*"))
            return value.replace("*","%");
        return "%"+value+"%";
    }
}
