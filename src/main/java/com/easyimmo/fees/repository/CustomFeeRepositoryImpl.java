package com.easyimmo.fees.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.easyimmo.common.utils.BasicUtils;
import com.easyimmo.fees.dto.FeeCriteria;
import com.easyimmo.fees.model.Fee;
import com.easyimmo.property.model.Property;

public class CustomFeeRepositoryImpl implements CustomFeeRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Fee> findFeeByMultipleCriteria(FeeCriteria feeCriteria) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Fee> criteriaQuery = criteriaBuilder.createQuery(Fee.class);
        Root<Fee> feeRoot = criteriaQuery.from(Fee.class);
        Join<Fee, Property> propertyJoin = feeRoot.join("property");
        BasicUtils.ConditionalList<Predicate> conditionalList = BasicUtils.ConditionalList.of(new ArrayList<>());
        conditionalList.add(feeCriteria.getMinAmount()!=null,()->criteriaBuilder.greaterThanOrEqualTo(feeRoot.get("amount"),feeCriteria.getMinAmount()))
        .add(feeCriteria.getMaxAmount()!=null,()->criteriaBuilder.lessThanOrEqualTo(feeRoot.get("amount"),feeCriteria.getMaxAmount()))
        .add(feeCriteria.getMinDate()!=null,()->criteriaBuilder.greaterThanOrEqualTo(feeRoot.get("date"),feeCriteria.getMinDate()))
        .add(feeCriteria.getMaxDate()!=null,()->criteriaBuilder.lessThanOrEqualTo(feeRoot.get("date"),feeCriteria.getMaxDate()))
        .add(feeCriteria.getSupplier()!=null,()->criteriaBuilder.like((criteriaBuilder.upper(feeRoot.get("supplier"))),toLike(feeCriteria.getSupplier())))
        .add(feeCriteria.getDescription()!=null,()->criteriaBuilder.like((criteriaBuilder.upper(feeRoot.get("description"))),toLike(feeCriteria.getDescription())))
        .add(feeCriteria.getPropertyName()!=null,()->criteriaBuilder.like((criteriaBuilder.upper(propertyJoin.get("name"))),toLike(feeCriteria.getPropertyName())))
        .add(feeCriteria.getPropertyId()!=null,()->criteriaBuilder.equal((propertyJoin.get("id")),feeCriteria.getPropertyId()));
        criteriaQuery.where(conditionalList.toList().toArray(new Predicate[0]));
        criteriaQuery.orderBy(criteriaBuilder.desc(feeRoot.get("date")));
        TypedQuery<Fee> typedQuery = entityManager.createQuery(criteriaQuery);
        if(feeCriteria.getPageSize()!=null && feeCriteria.getPageNumber()!=null){
            typedQuery.setMaxResults(feeCriteria.getPageSize()).setFirstResult((feeCriteria.getPageNumber()-1) * feeCriteria.getPageSize());
        }
        return typedQuery.getResultList();
    }

    private String toLike(String value){
        if(value.contains("*"))
            return value.replace("*","%");
        return "%"+value+"%";
    }
}
