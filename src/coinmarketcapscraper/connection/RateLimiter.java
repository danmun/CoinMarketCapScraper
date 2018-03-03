/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coinmarketcapscraper.connection;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dani_
 */
public class RateLimiter {
    private static long lastCall = 0;
    private static int rate = 1000; // ms
    
    public static boolean isDelayNeeded(){
        long newCall = System.currentTimeMillis();
        boolean isNeeded = (newCall - lastCall) <= rate;
        lastCall = newCall;
        return isNeeded;
    }
    
    public static void delay() throws InterruptedException{
        Thread.sleep(rate);
    }
    
    public static void check(){
        System.out.println("ratelimiter called" + new Date());
        if(isDelayNeeded()){
            System.out.println("limit is needed");
            try {
                delay();
            }catch(InterruptedException ex) {
                Logger.getLogger(Scraper.class.getName()).log(Level.SEVERE, null, ex);
            }        
        }else{
            System.out.println("limit is not needed");
        }
    }

    public static int getRate() {
        return rate;
    }

    public static void setRate(int rate) {
        RateLimiter.rate = rate;
    }
    
}
