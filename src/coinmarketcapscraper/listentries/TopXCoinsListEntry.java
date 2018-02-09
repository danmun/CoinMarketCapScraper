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
public class TopXCoinsListEntry {
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
        Coin coin = new Coin();
        
        org.jsoup.nodes.Document doc = Scraper.scrapeHTML(CoinMarketCap.frontPage + this.link);
        org.jsoup.nodes.Element communityLinksContainer = doc.body().getElementsByClass("list-unstyled").first();
        org.jsoup.select.Elements listItems = communityLinksContainer.children();
        
        ArrayList<String> wsites = new ArrayList<>();
        ArrayList<String> announcements = new ArrayList<>();
        ArrayList<String> explorers = new ArrayList<>();
        ArrayList<String> msgBoards = new ArrayList<>();
        ArrayList<String> chats = new ArrayList<>();
        ArrayList<String> srcCodes = new ArrayList<>();
        ArrayList<String> tags = new ArrayList<>();
        for(org.jsoup.nodes.Element item : listItems){
            org.jsoup.nodes.Element titleElement = item.children().first();
            String title = titleElement.attr("title");
            
            if(title.equalsIgnoreCase("website")){
                wsites.add(item.children().last().attr("href"));
            }else if(title.equalsIgnoreCase("announcement")){
                announcements.add(item.children().last().attr("href"));
            }else if(title.equalsIgnoreCase("explorer")){
                explorers.add(item.children().last().attr("href"));
            }else if(title.equalsIgnoreCase("message board")){
                msgBoards.add(item.children().last().attr("href"));
            }else if(title.equalsIgnoreCase("chat")){
                chats.add(item.children().last().attr("href"));
            }else if(title.equalsIgnoreCase("source code")){
                srcCodes.add(item.children().last().attr("href"));
            }else if(title.equalsIgnoreCase("tags")){
                org.jsoup.select.Elements tagElements = item.children();
                for(int i = 1; i < tagElements.size(); i++){
                    tags.add(tagElements.get(i).text());
                }
            }
        }
        
        coin.setName(this.coinName);
        coin.setWebsites(wsites.toArray(new String[wsites.size()]));
        coin.setAnnouncements(announcements.toArray(new String[announcements.size()]));
        coin.setBlockExplorers(explorers.toArray(new String[explorers.size()]));
        coin.setMessageBoards(msgBoards.toArray(new String[msgBoards.size()]));
        coin.setChats(chats.toArray(new String[chats.size()]));
        coin.setSourceCodes(srcCodes.toArray(new String[srcCodes.size()]));
        coin.setTags(tags.toArray(new String[tags.size()]));
        coin.setRank(this.rank);
        coin.setMarketCap_fiat(this.marketCap);
        coin.setVolume_fiat(this.volume_24h);
        coin.setCirculatingSupply(this.circulatingSupply);
        
        org.jsoup.nodes.Element coinDetailContainer = doc.body().getElementsByClass("col-sm-8 col-sm-push-4").first();
        org.jsoup.select.Elements coinDetailItems = coinDetailContainer.children();
        for(org.jsoup.nodes.Element item : coinDetailItems){
            org.jsoup.select.Elements itemParts = item.children();
            org.jsoup.nodes.Element headerElement = itemParts.first();
            org.jsoup.nodes.Element dataElement = itemParts.last();

            if(headerElement == null) continue;
            String header = headerElement.text();
            if(header.equalsIgnoreCase("market cap")){
                org.jsoup.nodes.Element fiat = dataElement.select("span").first();
                org.jsoup.nodes.Element btc = dataElement.select("span").last();
                // fiat mcap set previously, see just before the loop
                coin.setMarketCap_btc(btc.text());
            }else if(header.equalsIgnoreCase("volume (24h)")){
                org.jsoup.nodes.Element fiat = dataElement.select("span").first();
                org.jsoup.nodes.Element btc = dataElement.select("span").last();
                // fiat volume set previously, see just before the loop
                coin.setVolume_btc(btc.text());
            }else if(header.equalsIgnoreCase("circulating supply")){
                coin.setCirculatingSupply(dataElement.text());
            }else if(header.equalsIgnoreCase("total supply")){
                coin.setTotalSupply(dataElement.text());
            }else if(header.equalsIgnoreCase("max supply")){
                coin.setMaxSupply(dataElement.text());
            }
        }        
        
        org.jsoup.nodes.Element buysellInstantlyContainer = doc.body().getElementsByClass("row bottom-margin-1x").first().children().last();
        boolean canBuySellInstantly = !buysellInstantlyContainer.text().isEmpty();
        coin.setCanBuyInstantly(canBuySellInstantly);
        coin.setBuyInstantlyURL((canBuySellInstantly) ? buysellInstantlyContainer.child(0).attr("href") : "");

        org.jsoup.nodes.Element marketsContainer = doc.body().getElementById("markets");
        org.jsoup.nodes.Element marketsTable = marketsContainer.getElementById("markets-table");
        org.jsoup.select.Elements rows = marketsTable.getElementsByTag("tbody").first().children();
        MarketEntry[] markets = new MarketEntry[rows.size()];
        for(int i = 0; i < markets.length; i++){
            org.jsoup.nodes.Element row = rows.get(i);
            org.jsoup.select.Elements coloumns = row.children();
            MarketEntry me = new MarketEntry();
            me.setExchange(coloumns.get(1).text());
            me.setTradingPair(coloumns.get(2).text());
            me.setVolume(coloumns.get(3).text());
            me.setPrice(coloumns.get(4).text());
            me.setVolumePcnt(coloumns.get(5).text());
            me.setUpdated(coloumns.get(6).text());
            markets[i] = me;
        }
        coin.setMarkets(markets);
        for(String tag : tags){
            if(tag.equalsIgnoreCase("mineable")){
                coin.setIsMinable(true);
                break;
            }
        }
        
        org.jsoup.nodes.Element twitterContainer = doc.body().getElementById("twitter-widget-0");
        org.jsoup.nodes.Element redditContainer = doc.body().getElementById("reddit");
        // for some reason, can't load these
        
        org.jsoup.nodes.Element widgetContainer = doc.body().getElementById("tools");
        org.jsoup.nodes.Element textArea = widgetContainer.child(1).child(1).child(0);
        BasicWidget bw = new BasicWidget();
        bw.setSourceCode(textArea.text());
        coin.setWidget(bw);
        return coin;
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