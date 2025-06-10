package com.mvp2.mvp2;

import com.mvp2.mvp2.entity.PurchaseOrder;
import com.mvp2.mvp2.repository.PurchaseOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

//@Component
public class DummyLoader implements CommandLineRunner {
    @Autowired
    private PurchaseOrderRepository repo;

    public void run(String... args) {
        repo.save(new PurchaseOrder(null, 1500.0, "Raw Materials", LocalDate.now().minusDays(5)));
        repo.save(new PurchaseOrder(null, 3200.0, "Logistics", LocalDate.now().minusDays(2)));
        repo.save(new PurchaseOrder(null, 1800.0, "Packaging", LocalDate.now().minusDays(1)));
    }
}
