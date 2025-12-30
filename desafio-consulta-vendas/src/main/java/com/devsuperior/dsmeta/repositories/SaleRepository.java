package com.devsuperior.dsmeta.repositories;

import com.devsuperior.dsmeta.projections.SaleReportProjection;
import com.devsuperior.dsmeta.projections.SummaryReportProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsmeta.entities.Sale;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;


public interface SaleRepository extends JpaRepository<Sale, Long> {



  @Query(nativeQuery = true, value = "SELECT s1.id, s1.date, s1.amount , s2.name AS sellerName "
          + "FROM tb_sales s1 "
          + "INNER JOIN tb_seller s2 ON s1.seller_id = s2.id "
          + "WHERE s1.date BETWEEN :minDate AND :maxDate "
          + " AND LOWER (s2.name) LIKE LOWER (CONCAT('%', :sellerName, '%')) ORDER BY s1.date DESC "

  )
  List<SaleReportProjection> search1(String sellerName, LocalDate minDate, LocalDate maxDate);


    @Query(nativeQuery = true, value = "SELECT s2.name AS sellerName, SUM(s1.amount) AS amount "
            + "FROM tb_sales s1 "
            + "INNER JOIN tb_seller s2 ON s1.seller_id = s2.id "
            + "WHERE s1.date BETWEEN :minDate AND :maxDate "
            + "GROUP BY s2.name "

    )
    List<SummaryReportProjection> search2(LocalDate minDate, LocalDate maxDate);

}
