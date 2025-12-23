package com.devsuperior.dsmeta.controllers;

import com.devsuperior.dsmeta.dto.SellerMinDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.services.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

	@Autowired
	private SaleService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<SaleMinDTO> findById(@PathVariable Long id) {
		SaleMinDTO dto = service.findById(id);
		return ResponseEntity.ok(dto);
	}

	@GetMapping(value = "/report")
	public ResponseEntity<Page<SaleMinDTO>> getReport(@RequestParam(defaultValue = "")  String name
            , @RequestParam(required = false) String minDate,
                                                      @RequestParam(required = false) String maxDate, Pageable pageable) {
        Page<SaleMinDTO> result = service.getReport(name, minDate, maxDate, pageable);
		return ResponseEntity.ok().body(result);
    }



	@GetMapping(value = "/summary")
	public ResponseEntity<Page<SellerMinDTO>> getSummary( @RequestParam(required = false) String maxDate,
                                                          @RequestParam(required = false) String minDate,
                                                          Pageable pageable) {
		Page<SellerMinDTO> result = service.getSummary(minDate, maxDate, pageable);

		return ResponseEntity.ok().body(result);
	}


}
