package com.jimluis.stockservice.resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.jimluis.stockservice.model.Quote;
import com.jimluis.stockservice.model.ResponseObject;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

@RestController
@RequestMapping("/rest/stock")
public class StockResource 
{
	
	@Autowired
	RestTemplate restTemplate;
	

	@GetMapping("/{username}")
	public List<Stock>getStock(@PathVariable("username") String userName)
	{
		ResponseObject responseObject = restTemplate.getForObject("http://localhost:8080/rest/db/"+userName, ResponseObject.class);
		List<Stock> stockList = new ArrayList<Stock>();
//		ResponseEntity<List<String>> responseObject = restTemplate.exchange("http://localhost:8080/rest/db/"+userName, HttpMethod.GET, null,new ParameterizedTypeReference<List<String>>() {
//		});
		
		if(responseObject != null && responseObject.getQuotes() != null && responseObject.getQuotes().size() > 0)
		{
			List<Quote> quotelist = responseObject.getQuotes();
//			List<String> quotelist = responseObject.getBody();

//			quotelist.stream().map(this::)
			

			
			for(Quote quote : quotelist)
			{
				try {
					Stock stockInfo = YahooFinance.get(quote.getQuote());
					stockList.add(stockInfo);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		
		return stockList;
	}
	 
}
