package com.devsuperior.dsmeta.projections;

import java.time.LocalDate;

public interface SaleReportProjection {

    Long getId();
    Double getAmount();
    LocalDate getDate();
}
