package coinmarketcapscraper.listentries;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import coinmarketcapscraper.widgets.BasicWidget;
import coinmarketcapscraper.Coin;
import coinmarketcapscraper.CoinMarketCap;
import coinmarketcapscraper.connection.Scraper;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author danmun
 */
public class Top100CoinsListEntry {
    private int rank;
    private String coinName;
    private String link;
    private String marketCap;
    private String price;
    private String circulatingSupply;
    private String volume_24h;
    private String pctChange_24h; 
    private String miniChartURL;

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

    public String getLink(){
        return this.link;
    }
    
    public void setLink(String link){
        this.link = link;
    }
    
    public String getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(String marketCap) {
        this.marketCap = marketCap;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCirculatingSupply() {
        return circulatingSupply;
    }

    public void setCirculatingSupply(String circulatingSupply) {
        this.circulatingSupply = circulatingSupply;
    }

    public String getVolume_24h() {
        return volume_24h;
    }

    public void setVolume_24h(String volume_24h) {
        this.volume_24h = volume_24h;
    }

    public String getPctChange_24h() {
        return pctChange_24h;
    }

    public void setPctChange_24h(String pctChange_24h) {
        this.pctChange_24h = pctChange_24h;
    }

    public String getMiniChartURL() {
        return miniChartURL;
    }

    public void setMiniChartURL(String miniChartURL) {
        this.miniChartURL = miniChartURL;
    }
    
    public Coin getCoin() throws IOException{
        return Coin.getCoin(this.coinName);
    }
}

//    private WebsiteWidget widge;  


//    private int rank;
//    private String coinName;
//    private String link;
//    private String marketCap;
//    private String price;
//    private String circulatingSupply;
//    private String volume_24h;
//    private String pctChange_24h; 
//    private String miniChartURL;