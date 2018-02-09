/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coinmarketcapscraper;

import coinmarketcapscraper.listentries.TopXCoinsListEntry;
import coinmarketcapscraper.connection.Scraper;
import java.io.IOException;

/**
 *
 * @author danmun
 */
public class CoinMarketCap {
    public static final transient String frontPage = "https://coinmarketcap.com/";
    private static final transient String globalStatsFile = "https://files.coinmarketcap.com/generated/stats/global.json";
    
    private GlobalStats globalStats;

    private TopXCoinsListEntry[] coinList;
    
    private String twitter;
    private String facebook;

    public GlobalStats getGlobalStats() {
        return globalStats;
    }

    public void setGlobalStats(GlobalStats globalStats) {
        this.globalStats = globalStats;
    }

    public TopXCoinsListEntry[] getCoinList() {
        return coinList;
    }

    public void setCoinList(TopXCoinsListEntry[] coinList) {
        this.coinList = coinList;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }
    
    public static CoinMarketCap browse() throws IOException{
        return browse(1);
    }
    
    public static CoinMarketCap browse(int page) throws IOException{
        if(page == 0) page = 1;
        org.jsoup.nodes.Document doc = Scraper.scrapeHTML(frontPage + page);
        String globalStatsJson = Scraper.scrapeOther(globalStatsFile);
        globalStatsJson = globalStatsJson.substring(1,globalStatsJson.length()-1);
        String[] parts = globalStatsJson.split(", ");
        
        GlobalStats gs = new GlobalStats();
        gs.setNumberOfCryptoCurrencies(Integer.parseInt(parts[1].substring(parts[1].indexOf(": ") + 2)));
        gs.setNumberOfMarkets(Integer.parseInt(parts[3].substring(parts[3].indexOf(": ") + 2)));
        gs.setTotalMarketCap(parts[0].substring(parts[4].indexOf(": ") + 2));
        gs.setVolume_24h(parts[2].substring(parts[2].indexOf(": ") + 2));
        gs.setBtcDominance(parts[0].substring(parts[0].indexOf(": ") + 2));
        
        org.jsoup.nodes.Element table = doc.body().getElementById("currencies").children().last();
        org.jsoup.select.Elements rows = table.getElementsByTag("tr");
        CoinMarketCap cmc = new CoinMarketCap();
        cmc.coinList = new TopXCoinsListEntry[rows.size()];
        for(int i = 0; i < cmc.coinList.length; i++){
            org.jsoup.nodes.Element row = rows.get(i);
            org.jsoup.select.Elements coloumns = row.children();
            
            TopXCoinsListEntry entry = new TopXCoinsListEntry();
            
            entry.setRank(Integer.parseInt(coloumns.first().text()));
            entry.setCoinName(coloumns.get(1).children().last().text());
            entry.setLink(coloumns.get(1).children().last().attr("href"));
            entry.setMarketCap(coloumns.get(2).text());
            entry.setPrice(coloumns.get(3).text());
            entry.setVolume_24h(coloumns.get(4).text());
            entry.setCirculatingSupply(coloumns.get(5).children().first().text());
            entry.setPctChange_24h(coloumns.get(6).text());
            entry.setMiniChartURL(coloumns.get(7).children().first().children().first().attr("src"));
            
            cmc.coinList[i] = entry;
        }
        
        String twtr = "https://twitter.com/CoinMarketCap";
        String fb = "https://www.facebook.com/CoinMarketCap";
        
        cmc.globalStats = gs;
        
        cmc.twitter = twtr;
        cmc.facebook = fb;
        
        return cmc;
    }
}
