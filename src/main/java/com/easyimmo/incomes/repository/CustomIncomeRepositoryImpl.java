package com.easyimmo.incomes.repository;

import com.easyimmo.common.utils.BasicUtils;
import com.easyimmo.incomes.dto.IncomeCriteria;
import com.easyimmo.incomes.model.Income;
import com.easyimmo.property.model.Property;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class CustomIncomeRepositoryImpl implements CustomIncomeRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Income> findIncomesByMultipleCriteria(IncomeCriteria incomeCriteria) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Income> criteriaQuery = criteriaBuilder.createQuery(Income.class);
        Root<Income> incomeRoot = criteriaQuery.from(Income.class);
        Join<Income, Property> propertyJoin = incomeRoot.join("property");
        BasicUtils.ConditionalList<Predicate> conditionalList = BasicUtils.ConditionalList.of(new ArrayList<>());
        conditionalList.add(incomeCriteria.getMinAmount()!=null,()->criteriaBuilder.greaterThanOrEqualTo(incomeRoot.get("amount"),incomeCriteria.getMinAmount()))
                .add(incomeCriteria.getMaxAmount()!=null,()->criteriaBuilder.lessThanOrEqualTo(incomeRoot.get("amount"),incomeCriteria.getMaxAmount()))
                .add(incomeCriteria.getMinDate()!=null,()->criteriaBuilder.greaterThanOrEqualTo(incomeRoot.get("date"),incomeCriteria.getMinDate()))
                .add(incomeCriteria.getMaxDate()!=null,()->criteriaBuilder.lessThanOrEqualTo(incomeRoot.get("date"),incomeCriteria.getMaxDate()))
                .add(incomeCriteria.getDescription()!=null,()->criteriaBuilder.like((criteriaBuilder.upper(incomeRoot.get("description"))),toLike(incomeCriteria.getDescription())))
                .add(incomeCriteria.getPropertyName()!=null,()->criteriaBuilder.like((criteriaBuilder.upper(propertyJoin.get("name"))),toLike(incomeCriteria.getPropertyName())))
                .add(incomeCriteria.getType()!=null,()->criteriaBuilder.equal((incomeRoot.get("type")),incomeCriteria.getType()))
                .add(incomeCriteria.getPropertyId()!=null,()->criteriaBuilder.equal((propertyJoin.get("id")),incomeCriteria.getPropertyId()));
        criteriaQuery.where(conditionalList.toList().toArray(new Predicate[0]));

        criteriaQuery.orderBy(criteriaBuilder.desc(incomeRoot.get("date")));
        TypedQuery<Income> query = entityManager.createQuery(criteriaQuery);
        if(incomeCriteria.getPageSize()!=null){
            query.setMaxResults(incomeCriteria.getPageSize());
        }
        return query.getResultList();
    }

    private String toLike(String value){
        if(value.contains("*"))
            return value.replace("*","%");
        return "%"+value+"%";
    }
}
