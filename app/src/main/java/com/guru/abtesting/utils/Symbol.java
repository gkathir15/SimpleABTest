package com.guru.abtesting.utils;

public class Symbol {
    private String symbolname;
    private String exch;
    private String details;
    private String bid_price;
    private String ask_val;
    private String ask_size;
    private String nifty_val;
    private String change;

    public Symbol() {
    }

    public Symbol(String symbolname, String exch, String details, String bid_price, String ask_val, String ask_size, String nifty_val, String change) {
        this.symbolname = symbolname;
        this.exch = exch;
        this.details = details;
        this.bid_price = bid_price;
        this.ask_val = ask_val;
        this.ask_size = ask_size;
        this.nifty_val = nifty_val;
        this.change = change;

    }


    public String getSymbolname() {
        return symbolname;
    }

    public void setSymbolname(String symbolname) {
        this.symbolname = symbolname;
    }

    public String getExch() {
        return exch;
    }

    public void setExch(String exch) {
        this.exch = exch;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getBid_price() {
        return bid_price;
    }

    public void setBid_price(String bid_price) {
        this.bid_price = bid_price;
    }

    public String getAsk_val() {
        return ask_val;
    }

    public void setAsk_val(String ask_val) {
        this.ask_val = ask_val;
    }

    public String getAsk_size() {
        return ask_size;
    }

    public void setAsk_size(String ask_size) {
        this.ask_size = ask_size;
    }

    public String getNifty_val() {
        return nifty_val;
    }

    public void setNifty_val(String nifty_val) {
        this.nifty_val = nifty_val;
    }

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
    }
}
