/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coinmarketcapscraper;

import coinmarketcapscraper.listentries.MarketEntry;
import java.io.IOException;

/**
 *
 * @author danmun
 */
public class CMCScraperAPI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        CoinMarketCap cmc = CoinMarketCap.browse();
        Coin coin = cmc.getTop100CoinList()[5].getCoin();
        p(cmc.getTop100CoinList().length);
        p("-----#" + coin.getRank() + "--------" + coin.getName() + "----------------");
        for(String site : coin.getWebsites()){ p(site); }
        for(String ann : coin.getAnnouncements()) { p(ann); }
        for(String exp : coin.getBlockExplorers()) { p(exp); }
        for(String msgb : coin.getMessageBoards()) { p(msgb); }
        for(String chat : coin.getChats()) { p(chat); }
        for(String src : coin.getSourceCodes()) { p(src); }
        for(String tag : coin.getTags()) { p(tag); }
        p("Is this coin minable? " + ((coin.isIsMinable()) ? "yes" : "no"));
        p("Can I buy this coin quickly? " + ((coin.isCanBuyInstantly()) ? "yes, at " + coin.getBuyInstantlyURL() : "no"));
        p("---Markets:----");
        for(MarketEntry me : coin.getMarkets()){ p(me.getExchange() + " | " + me.getTradingPair() + " | " + me.getPrice() + " | " + me.getVolume() + " | " + me.getVolumePcnt() + " | " + me.getUpdated()); }
       
        System.out.println("Cryptos: " + cmc.getGlobalStats().getNumberOfCryptoCurrencies() + " | Markets: "  + cmc.getGlobalStats().getNumberOfMarkets());
//        
//        for(Top100CoinsListEntry entry : cmc.getCoinList()){
//            System.out.println(entry.getCoinName() + " " + entry.getPrice());
//        }
    }
    
    public static void p(Object s){System.out.println(s);}
    
}
