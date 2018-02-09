/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coinmarketcapscraper;

/**
 *
 * @author danmun
 */
class GlobalStats {
    private int numberOfCryptoCurrencies;
    private int numberOfMarkets;
    private String totalMarketCap;
    private String volume_24h;
    private String btcDominance;

    public int getNumberOfCryptoCurrencies() {
        return numberOfCryptoCurrencies;
    }

    public void setNumberOfCryptoCurrencies(int numberOfCryptoCurrencies) {
        this.numberOfCryptoCurrencies = numberOfCryptoCurrencies;
    }

    public int getNumberOfMarkets() {
        return numberOfMarkets;
    }

    public void setNumberOfMarkets(int numberOfMarkets) {
        this.numberOfMarkets = numberOfMarkets;
    }

    public String getTotalMarketCap() {
        return totalMarketCap;
    }

    public void setTotalMarketCap(String totalMarketCap) {
        this.totalMarketCap = totalMarketCap;
    }

    public String getVolume_24h() {
        return volume_24h;
    }

    public void setVolume_24h(String volume_24h) {
        this.volume_24h = volume_24h;
    }

    public String getBtcDominance() {
        return btcDominance;
    }

    public void setBtcDominance(String btcDominance) {
        this.btcDominance = btcDominance;
    }
    
    
    
    public static GlobalStats getGlobalStats(){
        return null;
    }
    
    
}
