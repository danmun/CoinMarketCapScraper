/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coinmarketcapscraper.listentries;

/**
 *
 * @author danmun
 */
public class MarketEntry {
    private String exchange;
    private String tradingPair;
    private String volume;
    private String price;
    private String volumePcnt;
    private String updated;

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getTradingPair() {
        return tradingPair;
    }

    public void setTradingPair(String tradingPair) {
        this.tradingPair = tradingPair;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getVolumePcnt() {
        return volumePcnt;
    }

    public void setVolumePcnt(String volumePcnt) {
        this.volumePcnt = volumePcnt;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }
    
    
}
