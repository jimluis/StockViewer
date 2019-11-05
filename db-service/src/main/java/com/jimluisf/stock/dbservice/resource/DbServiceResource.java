package com.jimluisf.stock.dbservice.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jimluisf.stock.dbservice.model.Quote;
import com.jimluisf.stock.dbservice.model.Quotes;
import com.jimluisf.stock.dbservice.model.ResponseObject;
import com.jimluisf.stock.dbservice.repository.QuotesRepository;

@RestController
@RequestMapping("/rest/db")
public class DbServiceResource 
{
	@Autowired
	private QuotesRepository quotesRepository;

	@GetMapping("/{username}")
	public ResponseObject getQuotes(@PathVariable String username)
	{
		ResponseObject responseObject = new ResponseObject();
		
		List<Quote> quoteList = quotesRepository.findByUserName(username);
		responseObject.setQuotes(quoteList);
		
		return responseObject;
	}
	
	@PostMapping("/add")
	public List<String> add(@RequestBody Quotes quotes)
	{
		
		if(quotes.getQuoteList() != null && quotes.getQuoteList().size() > 0)
		{
			for(String quote : quotes.getQuoteList())
			{
				quotesRepository.save(new Quote(quotes.getUserName(), quote));
			} 
		}
		
		return null;
	}
	
	@DeleteMapping("/delete/{username}")
	public String deleteRecord(@PathVariable String username)
	{
		String returnMsg ="";
		
		List<Quote> quoteList = quotesRepository.findByUserName(username);
		quotesRepository.delete(quoteList.get(0));
		
		return returnMsg;
	}
	
}
