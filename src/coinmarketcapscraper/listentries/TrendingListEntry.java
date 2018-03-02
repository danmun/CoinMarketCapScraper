/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coinmarketcapscraper.listentries;

/**
 *
 * @author dani_
 */
public class TrendingListEntry {
    private int rank;
    private String coinName;
    private String symbol;
    private String volume_24hr;
    private String price;
    private String pctChange; 

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getCoinName() {
        return coinName;
    }

    public void setCoinName(String coinName) {
        this.coinName = coinName;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getVolume_24hr() {
        return volume_24hr;
    }

    public void setVolume_24hr(String volume_24hr) {
        this.volume_24hr = volume_24hr;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPctChange() {
        return pctChange;
    }

    public void setPctChange(String pctChange) {
        this.pctChange = pctChange;
    }
    
    
}
