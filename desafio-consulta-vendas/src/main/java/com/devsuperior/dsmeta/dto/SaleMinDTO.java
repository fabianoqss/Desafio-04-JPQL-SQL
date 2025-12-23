package com.devsuperior.dsmeta.dto;

import java.time.LocalDate;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.projections.SaleReportProjection;

public class SaleMinDTO {

	private Long id;
	private Double amount;
	private LocalDate date;
    private String sellername;
	
	public SaleMinDTO(Long id, Double amount, LocalDate date, String sellername) {
		this.id = id;
		this.amount = amount;
		this.date = date;
        this.sellername = sellername;
	}
	
	public SaleMinDTO(Sale entity) {
		id = entity.getId();
		amount = entity.getAmount();
		date = entity.getDate();
        sellername = entity.getSeller().getName();
	}

    public SaleMinDTO(SaleReportProjection projection){
        id = projection.getId();
        amount = projection.getAmount();
        date = projection.getDate();
        sellername = projection.getSellerName();
    }

    public String getSellername() {
        return sellername;
    }

    public Long getId() {
		return id;
	}

	public Double getAmount() {
		return amount;
	}

	public LocalDate getDate() {
		return date;
	}
}
