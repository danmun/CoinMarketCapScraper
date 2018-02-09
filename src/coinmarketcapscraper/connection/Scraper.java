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
    public static Document scrapeHTML(String URL) throws IOException{
        return Jsoup.connect(URL).maxBodySize(0).timeout(600000).get();
    }
    
    public static String scrapeOther(String URL) throws IOException{
        return Jsoup.connect(URL).ignoreContentType(true).execute().body();
    }
}
