/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coinmarketcapscraper;

import coinmarketcapscraper.listentries.MarketEntry;

/**
 *
 * @author danmun
 */
class Exchange {
    private String website;
    private String[] social;
    private String[] tags;
    
    private String volume;
    private String volumeBTC; // maybe volume should have its own class?
    
    private MarketEntry[] activeMarkets;
    
    public static Coin scrapeExchange(String exchangeName){
        return null;
    }    
}
