/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coinmarketcapscraper;

import static coinmarketcapscraper.CoinMarketCap.frontPage;
import coinmarketcapscraper.connection.Scraper;
import coinmarketcapscraper.widgets.BasicWidget;
import coinmarketcapscraper.listentries.MarketEntry;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author danmun
 */
public class Coin {
    private static final String coinPage = "currencies/";
    
    private String name;
    private String[] websites;
    private String[] announcements;
    private String[] blockExplorers;
    private String[] messageBoards;
    private String[] chats;
    private String[] sourceCodes;
    private int rank;
    private String[] tags;
    
    private String marketCap_fiat, marketCap_btc;
    private String volume_fiat, volume_btc;
    private String circulatingSupply;
    private String totalSupply;
    private String maxSupply;
    private boolean isMinable;
    private boolean canBuyInstantly;
    private String buyInstantlyURL;
    
    private MarketEntry[] markets;
    private HistoricalData history; // requires extra connection/page load, only load once getHistory is called
    
    private String[] social; //link to twitter and reddit, impossible to get/loads only post-page load
    private BasicWidget widget;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BasicWidget getWidget() {
        return widget;
    }

    public void setWidget(BasicWidget widget) {
        this.widget = widget;
    }

    
    public String[] getWebsites() {
        return websites;
    }

    public void setWebsites(String[] websites) {
        this.websites = websites;
    }

    public String[] getAnnouncements() {
        return announcements;
    }

    public void setAnnouncements(String[] announcements) {
        this.announcements = announcements;
    }

    public String[] getBlockExplorers() {
        return blockExplorers;
    }

    public void setBlockExplorers(String[] blockExplorers) {
        this.blockExplorers = blockExplorers;
    }

    public String[] getMessageBoards() {
        return messageBoards;
    }

    public void setMessageBoards(String[] messageBoards) {
        this.messageBoards = messageBoards;
    }

    public String[] getChats() {
        return chats;
    }

    public void setChats(String[] chats) {
        this.chats = chats;
    }

    public String[] getSourceCodes() {
        return sourceCodes;
    }

    public void setSourceCodes(String[] sourceCode) {
        this.sourceCodes = sourceCode;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public String getMarketCap_fiat() {
        return marketCap_fiat;
    }

    public void setMarketCap_fiat(String marketCap_fiat) {
        this.marketCap_fiat = marketCap_fiat;
    }
    
    public String getMarketCap_btc() {
        return marketCap_btc;
    }

    public void setMarketCap_btc(String marketCap) {
        this.marketCap_btc = marketCap;
    }    

    public String getVolume_fiat() {
        return volume_fiat;
    }

    public void setVolume_fiat(String volume_fiat) {
        this.volume_fiat = volume_fiat;
    }

    public String getVolume_btc() {
        return volume_btc;
    }

    public void setVolume_btc(String volume_btc) {
        this.volume_btc = volume_btc;
    }    
    
    public String getCirculatingSupply() {
        return circulatingSupply;
    }

    public void setCirculatingSupply(String circulatingSupply) {
        this.circulatingSupply = circulatingSupply;
    }

    public String getTotalSupply() {
        return totalSupply;
    }

    public void setTotalSupply(String totalSupply) {
        this.totalSupply = totalSupply;
    }

    public String getMaxSupply() {
        return maxSupply;
    }

    public void setMaxSupply(String maxSupply) {
        this.maxSupply = maxSupply;
    }

    public boolean isIsMinable() {
        return isMinable;
    }

    public void setIsMinable(boolean isMinable) {
        this.isMinable = isMinable;
    }

    public boolean isCanBuyInstantly() {
        return canBuyInstantly;
    }

    public void setCanBuyInstantly(boolean canBuyInstantly) {
        this.canBuyInstantly = canBuyInstantly;
    }

    public MarketEntry[] getMarkets() {
        return markets;
    }

    public void setMarkets(MarketEntry[] markets) {
        this.markets = markets;
    }

    public String[] getSocial() {
        return social;
    }

    public void setSocial(String[] social) {
        this.social = social;
    }

    public String getBuyInstantlyURL() {
        return buyInstantlyURL;
    }

    public void setBuyInstantlyURL(String buyInstantlyURL) {
        this.buyInstantlyURL = buyInstantlyURL;
    }
    
    
    public static Coin getCoin(String coinName) throws IOException{
        Coin coin = new Coin();
        org.jsoup.nodes.Document doc = Scraper.scrapeHTML(CoinMarketCap.frontPage + coinPage + coinName);
        org.jsoup.nodes.Element communityLinksContainer = doc.body().getElementsByClass("list-unstyled").first();
        org.jsoup.select.Elements listItems = communityLinksContainer.children();
        
        ArrayList<String> wsites = new ArrayList<>();
        ArrayList<String> announcements = new ArrayList<>();
        ArrayList<String> explorers = new ArrayList<>();
        ArrayList<String> msgBoards = new ArrayList<>();
        ArrayList<String> chats = new ArrayList<>();
        ArrayList<String> srcCodes = new ArrayList<>();
        ArrayList<String> tags = new ArrayList<>();
        int rank = -1;
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
            }else if(title.equalsIgnoreCase("rank")){
                String rankStr = item.children().last().text().trim();
                rank = Integer.parseInt(rankStr.split(" ")[1]);
            }else if(title.equalsIgnoreCase("tags")){
                org.jsoup.select.Elements tagElements = item.children();
                for(int i = 1; i < tagElements.size(); i++){
                    tags.add(tagElements.get(i).text());
                }
            }
        }
        
        coin.setName(coinName);
        coin.setWebsites(wsites.toArray(new String[wsites.size()]));
        coin.setAnnouncements(announcements.toArray(new String[announcements.size()]));
        coin.setBlockExplorers(explorers.toArray(new String[explorers.size()]));
        coin.setMessageBoards(msgBoards.toArray(new String[msgBoards.size()]));
        coin.setChats(chats.toArray(new String[chats.size()]));
        coin.setSourceCodes(srcCodes.toArray(new String[srcCodes.size()]));
        coin.setTags(tags.toArray(new String[tags.size()]));
        coin.setRank(rank);
        
        org.jsoup.nodes.Element coinDetailContainer = doc.body().getElementsByClass("col-sm-8 col-sm-push-4").first();
        org.jsoup.select.Elements coinDetailItems = coinDetailContainer.children();
        for(org.jsoup.nodes.Element item : coinDetailItems){
            org.jsoup.select.Elements itemParts = item.children();
            org.jsoup.nodes.Element headerElement = itemParts.first();
            org.jsoup.nodes.Element dataElement = itemParts.last();

            if(headerElement == null) continue;
            String header = headerElement.text();
            if(header.equalsIgnoreCase("market cap")){
                org.jsoup.nodes.Element fiatMcap = dataElement.select("span").first();
                org.jsoup.nodes.Element btcMcap = dataElement.select("span").last();
                coin.setMarketCap_fiat(fiatMcap.text());
                coin.setMarketCap_btc(btcMcap.text());
            }else if(header.equalsIgnoreCase("volume (24h)")){
                org.jsoup.nodes.Element fiatVol = dataElement.select("span").first();
                org.jsoup.nodes.Element btcVol = dataElement.select("span").last();
                // fiat volume set previously, see just before the loop
                coin.setVolume_fiat(fiatVol.text());
                coin.setVolume_btc(btcVol.text());
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
        
        // for some reason, can't load these (probably served by JavaScript after the page has loaded into Jsoup)
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
