package com.mvp2.mvp2.service;

import com.mvp2.mvp2.repository.PurchaseOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AnalyticsService {
    @Autowired
    private PurchaseOrderRepository repository;

    @Autowired
    private AIService aiService;

    public Map<String, Object> getDashboardData() {
        Map<String, Object> dashboard = new HashMap<>();

        Long totalOrders = repository.count();
        Double totalSpend = repository.getTotalSpend();
        dashboard.put("totalOrders", totalOrders);
        dashboard.put("totalSpend", totalSpend);

        List<Object[]> categoryData = repository.getSpendByCategory();
        Map<String, Double> categorySpend = new HashMap<>();
        for (Object[] row : categoryData) {
            categorySpend.put((String) row[0], (Double) row[1]);
        }
        dashboard.put("categorySpend", categorySpend);

        String aiInsights = aiService.getSpendInsights(
                totalSpend,
                totalOrders
        );

        for (Object[] row : categoryData) {
            String aiInsight2s = aiService.getRecommendation(
                    (String) row[0],
                    (Double) row[1]
            );
            dashboard.put("aiInsights for the category : "+ (String) row[0], "is :"+aiInsight2s);

        }


        dashboard.put("aiInsights", aiInsights);

        return dashboard;
    }
}