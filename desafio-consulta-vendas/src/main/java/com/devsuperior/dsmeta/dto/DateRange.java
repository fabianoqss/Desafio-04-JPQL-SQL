package com.devsuperior.dsmeta.dto;

import java.time.LocalDate;

public class DateRange {

    private LocalDate minDate;
    private LocalDate maxDate;

    public DateRange(LocalDate minDate, LocalDate maxDate) {
        this.minDate = minDate;
        this.maxDate = maxDate;
    }


    public LocalDate getMinDate() {
        return minDate;
    }

    public void setMinDate(LocalDate minDate) {
        this.minDate = minDate;
    }

    public LocalDate getMaxDate() {
        return maxDate;
    }

    public void setMaxDate(LocalDate maxDate) {
        this.maxDate = maxDate;
    }
}
