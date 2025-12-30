package com.devsuperior.dsmeta.services;


import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import com.devsuperior.dsmeta.dto.DateRangeDTO;
import com.devsuperior.dsmeta.dto.SellerMinDTO;
import com.devsuperior.dsmeta.projections.SaleReportProjection;
import com.devsuperior.dsmeta.projections.SummaryReportProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;

	public SaleMinDTO findById(Long id) {
		Optional<Sale> result = repository.findById(id);
		Sale entity = result.get();
		return new SaleMinDTO(entity);
	}

    public List<SaleMinDTO> getReport(String name, String minDate, String maxDate){

        DateRangeDTO variableLocal = switchDates(minDate, maxDate);

        List<SaleReportProjection> lista = repository.search1
                (name, variableLocal.getMinDate(), variableLocal.getMaxDate());

        return lista.stream().map(x -> new SaleMinDTO(x)).toList();
    }

    public List<SellerMinDTO> getSummary(String minDate, String maxDate){
        DateRangeDTO localVariable = switchDates(minDate, maxDate);

        List<SummaryReportProjection> lista =  repository.search2(localVariable.getMinDate(), localVariable.getMaxDate());

        return lista.stream().map(x -> new SellerMinDTO(x)).toList();
    }


    public DateRangeDTO switchDates(String minDate, String maxDate){

        LocalDate max = (minDate == null) ? LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault()) : LocalDate.parse(maxDate);

        LocalDate min = (minDate ==  null) ? max.minusYears(1L) : LocalDate.parse(minDate);


        return new DateRangeDTO(min, max);
    }

}
