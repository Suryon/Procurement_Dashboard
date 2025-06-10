package com.mvp2.mvp2;

import com.mvp2.mvp2.entity.PurchaseOrder;
import com.mvp2.mvp2.repository.PurchaseOrderRepository;
import com.mvp2.mvp2.service.AnalyticsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {
    private static final Logger log = LoggerFactory.getLogger(DashboardController.class);
    @Autowired
    private AnalyticsService analyticsService;

    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;

    @GetMapping
    public Map<String, Object> getDashboard() {
        log.info("At this api is hit");
        return analyticsService.getDashboardData();
    }

    @GetMapping("/dashboard2")
    public Map<String, Object> getDashboard2() {
        return Map.of("status", "Suryaansh ok");
    }


    @PostMapping("/purchase-orders")
    public PurchaseOrder createOrder(@RequestBody PurchaseOrder order) {
        if (order.getOrderDate() == null) {
            order.setOrderDate(LocalDate.now());
        }
        return purchaseOrderRepository.save(order);
    }


}