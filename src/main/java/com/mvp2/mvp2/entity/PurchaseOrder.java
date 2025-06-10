package com.mvp2.mvp2.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class PurchaseOrder {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    @Id
    @GeneratedValue
    private Long id;
    private Double amount;
    private String category;
    private LocalDate orderDate;

    public PurchaseOrder() {}
    public PurchaseOrder(Long id, Double amount, String category, LocalDate orderDate) {
        this.id = id;
        this.amount = amount;
        this.category = category;
        this.orderDate = orderDate;
    }
}