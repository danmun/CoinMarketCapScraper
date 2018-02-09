/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coinmarketcapscraper;

import coinmarketcapscraper.widgets.BasicWidget;
import coinmarketcapscraper.listentries.MarketEntry;

/**
 *
 * @author danmun
 */
public class Coin {
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
    
    
   
    
    public static Coin getCoin(String coinName){
        return null;
    }
}
