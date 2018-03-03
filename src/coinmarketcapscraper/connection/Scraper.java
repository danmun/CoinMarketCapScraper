/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coinmarketcapscraper.connection;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 *
 * @author danmun
 */
public class Scraper {
    
    private static int timeout = 600000;
    
    public static Document scrapeHTML(String URL) throws IOException{
        RateLimiter.check();
        return Jsoup.connect(URL).maxBodySize(0).timeout(timeout).get();
    }
    
    public static String scrapeOther(String URL) throws IOException{
        RateLimiter.check();
        return Jsoup.connect(URL).ignoreContentType(true).execute().body();
    }
    
    public static void setTimeout(int time){
        timeout = time;
    }
    
    public static int getTimeout(){
        return timeout;
    }
}
