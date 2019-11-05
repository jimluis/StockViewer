package com.jimluisf.stock.dbservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jimluisf.stock.dbservice.model.Quote;

@Repository
public interface QuotesRepository extends JpaRepository<Quote, Integer>
{

	List<Quote> findByUserName(String username);

}
