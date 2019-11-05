package com.jimluis.stockservice.model;

import java.util.List;

public class ResponseObject 
{
	private List<Quote> quotes;

//	public ResponseObject() {
//	}

	public List<Quote> getQuotes() {
		return quotes;
	}

	public void setQuotes(List<Quote> quotes) {
		this.quotes = quotes;
	}
	
}
