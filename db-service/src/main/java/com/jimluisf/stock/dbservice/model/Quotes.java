package com.jimluisf.stock.dbservice.model;

import java.util.List;

public class Quotes 
{
	private String userName;
    private List<String> quoteList;

    public Quotes() {
    }

    public Quotes(String userName, List<String> quoteList) {
        this.userName = userName;
        this.quoteList = quoteList;
    }

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<String> getQuoteList() {
		return quoteList;
	}

	public void setQuoteList(List<String> quotes) {
		this.quoteList = quotes;
	}
    
    
}
