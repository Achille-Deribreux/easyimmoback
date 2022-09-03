package com.easyimmo.bankloan.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.easyimmo.property.model.Property;

@Entity
@Table(name="bankloan")
public class Bankloan {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="totalAmount")
    @NotNull
    private Integer totalAmount;

    @Column(name="dueAmount")
    @NotNull
    private Integer dueAmount;

    @Column(name="refundedAmount")
    @NotNull
    private Integer refundedAmount;

    @ManyToOne
    @JoinColumn(name="property_id", referencedColumnName = "id")
    @NotNull
    private Property property;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getDueAmount() {
        return dueAmount;
    }

    public void setDueAmount(Integer dueAmount) {
        this.dueAmount = dueAmount;
    }

    public Integer getRefundedAmount() {
        return refundedAmount;
    }

    public void setRefundedAmount(Integer refundedAmount) {
        this.refundedAmount = refundedAmount;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bankloan bankloan = (Bankloan) o;
        return Objects.equals(id, bankloan.id) && Objects.equals(totalAmount, bankloan.totalAmount) && Objects.equals(dueAmount, bankloan.dueAmount) && Objects.equals(refundedAmount, bankloan.refundedAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, totalAmount, dueAmount, refundedAmount);
    }
}
