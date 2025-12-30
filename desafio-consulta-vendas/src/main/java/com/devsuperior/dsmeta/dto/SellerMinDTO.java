package com.devsuperior.dsmeta.dto;

import com.devsuperior.dsmeta.entities.Seller;
import com.devsuperior.dsmeta.projections.SummaryReportProjection;

public class SellerMinDTO {

    private String sellerName;
    private Double amount;

    public SellerMinDTO() {
    }

    public SellerMinDTO(String sellerName, Double amount) {
        this.sellerName = sellerName;
        this.amount = amount;
    }

    public SellerMinDTO(SummaryReportProjection summaryReportProjection){
        sellerName = summaryReportProjection.getSellerName();
        amount = summaryReportProjection.getAmount();
    }

    public String getSellerName() {
        return sellerName;
    }

    public Double getAmount() {
        return amount;
    }
}
