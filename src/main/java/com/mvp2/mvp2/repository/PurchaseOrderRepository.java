package com.mvp2.mvp2.repository;

import com.mvp2.mvp2.entity.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long> {
    @Query("SELECT SUM(p.amount) FROM PurchaseOrder p")
    Double getTotalSpend();

    @Query("SELECT p.category, SUM(p.amount) FROM PurchaseOrder p GROUP BY p.category")
    List<Object[]> getSpendByCategory();
}
