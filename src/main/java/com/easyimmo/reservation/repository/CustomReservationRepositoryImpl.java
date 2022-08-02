package com.easyimmo.reservation.repository;

import com.easyimmo.common.utils.BasicUtils;
import com.easyimmo.property.model.Property;
import com.easyimmo.reservation.dto.ReservationCriteria;
import com.easyimmo.reservation.model.Reservation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class CustomReservationRepositoryImpl implements CustomReservationRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Reservation> findReservationByMultipleCriteria(ReservationCriteria reservationCriteria) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Reservation> criteriaQuery = criteriaBuilder.createQuery(Reservation.class);
        Root<Reservation> reservationRoot = criteriaQuery.from(Reservation.class);
        Join<Reservation, Property> propertyJoin = reservationRoot.join("property", JoinType.LEFT);
        BasicUtils.ConditionalList<Predicate> conditionalList = BasicUtils.ConditionalList.of(new ArrayList<>());
        conditionalList.add(reservationCriteria.getProperty()!=null,()->criteriaBuilder.equal(propertyJoin.get("id"),reservationCriteria.getProperty().getId()));
        conditionalList.add(reservationCriteria.getReservationDate()!=null,()->criteriaBuilder.equal(reservationRoot.get("reservationDate"),reservationCriteria.getReservationDate()));
        conditionalList.add(reservationCriteria.getFromDate()!=null,()->criteriaBuilder.equal(reservationRoot.get("fromDate"),reservationCriteria.getFromDate()));
        conditionalList.add(reservationCriteria.getToDate()!=null,()->criteriaBuilder.equal(reservationRoot.get("toDate"),reservationCriteria.getToDate()));
        criteriaQuery.where(conditionalList.toList().toArray(new Predicate[0]));
        criteriaQuery.orderBy(criteriaBuilder.asc(reservationRoot.get("fromDate")));
        TypedQuery<Reservation> typedQuery = entityManager.createQuery(criteriaQuery);
        if(reservationCriteria.getPageSize()!=null && reservationCriteria.getPageNumber()!=null)
            typedQuery.setMaxResults(reservationCriteria.getPageSize()).setFirstResult((reservationCriteria.getPageNumber()-1) * reservationCriteria.getPageSize());
        return typedQuery.getResultList();
    }
}
