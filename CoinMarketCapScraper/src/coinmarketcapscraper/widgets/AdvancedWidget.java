/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coinmarketcapscraper.widgets;

/**
 *
 * @author danmun
 */
public class AdvancedWidget extends BasicWidget {
//    default for ETH:
//    <script type="text/javascript" src="https://files.coinmarketcap.com/static/widget/currency.js"></script>
//    <div class="coinmarketcap-currency-widget" data-currency="ethereum" data-base="USD"  data-secondary="BTC"></div>
    
//    widget with everything enabled:
//    <script type="text/javascript" src="https://files.coinmarketcap.com/static/widget/currency.js"></script>
//    <div class="coinmarketcap-currency-widget" data-currency="ethereum" data-base="USD" data-secondary="BTC" data-ticker="true" data-rank="true" data-marketcap="true" data-volume="true" data-stats="USD" data-statsticker="true"></div>
    
    private String cryptoCurrency;
    private String fiat;
    private String secondaryDisplayCurrency;
    private boolean showsTickerSymbol;
    private boolean showsRank;
    private boolean showsMcap;
    private boolean showsVolume;
    private boolean showMcapVolumeTickerSymbol;

    @Override
    public String getSourceCode() {
        return super.getSourceCode();
    }

    @Override
    public void setSourceCode(String sourceCode) {
        super.setSourceCode(sourceCode);
    }

    public String getCryptoCurrency() {
        return cryptoCurrency;
    }

    public void setCryptoCurrency(String cryptoCurrency) {
        this.cryptoCurrency = cryptoCurrency;
    }

    public String getFiat() {
        return fiat;
    }

    public void setFiat(String fiat) {
        this.fiat = fiat;
    }

    public String getSecondaryDisplayCurrency() {
        return secondaryDisplayCurrency;
    }

    public void setSecondaryDisplayCurrency(String secondaryDisplayCurrency) {
        this.secondaryDisplayCurrency = secondaryDisplayCurrency;
    }

    public boolean isShowsTickerSymbol() {
        return showsTickerSymbol;
    }

    public void setShowsTickerSymbol(boolean showsTickerSymbol) {
        this.showsTickerSymbol = showsTickerSymbol;
    }

    public boolean isShowsRank() {
        return showsRank;
    }

    public void setShowsRank(boolean showsRank) {
        this.showsRank = showsRank;
    }

    public boolean isShowsMcap() {
        return showsMcap;
    }

    public void setShowsMcap(boolean showsMcap) {
        this.showsMcap = showsMcap;
    }

    public boolean isShowsVolume() {
        return showsVolume;
    }

    public void setShowsVolume(boolean showsVolume) {
        this.showsVolume = showsVolume;
    }

    public boolean isShowMcapVolumeTickerSymbol() {
        return showMcapVolumeTickerSymbol;
    }

    public void setShowMcapVolumeTickerSymbol(boolean showMcapVolumeTickerSymbol) {
        this.showMcapVolumeTickerSymbol = showMcapVolumeTickerSymbol;
    }
    
    
        
}
