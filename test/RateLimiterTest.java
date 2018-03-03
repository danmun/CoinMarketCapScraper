/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import coinmarketcapscraper.connection.RateLimiter;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author dani_
 */
public class RateLimiterTest {
    
    public RateLimiterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testElapsedTimeLessThanRate(){
        RateLimiter.reset();
        assertThat(RateLimiter.isDelayNeeded(), is(false));
        assertThat(RateLimiter.isDelayNeeded(), is(true));
        try {
            Thread.sleep(987);
        } catch (InterruptedException ex) {
            Logger.getLogger(RateLimiterTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertThat(RateLimiter.isDelayNeeded(), is(true));
        assertThat(RateLimiter.isDelayNeeded(), is(true));
        
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(RateLimiterTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        assertThat(RateLimiter.isDelayNeeded(), is(true));
        RateLimiter.reset();
    }
    
    @Test
    public void testElapsedTimeMoreThanRate(){
        RateLimiter.reset();
        assertThat(RateLimiter.isDelayNeeded(), is(false));
        assertThat(RateLimiter.isDelayNeeded(), is(true));
        try {
            Thread.sleep(1001);
        } catch (InterruptedException ex) {
            Logger.getLogger(RateLimiterTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertThat(RateLimiter.isDelayNeeded(), is(false));
        assertThat(RateLimiter.isDelayNeeded(), is(true));
        
        try {
            Thread.sleep(1999);
        } catch (InterruptedException ex) {
            Logger.getLogger(RateLimiterTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        assertThat(RateLimiter.isDelayNeeded(), is(false));
        RateLimiter.reset();
    }    

    @Test
    public void testExhaustiveCallsBeforeCooldown(){
        RateLimiter.reset();
        assertThat(RateLimiter.isDelayNeeded(), is(false));
        assertThat(RateLimiter.isDelayNeeded(), is(true));
        assertThat(RateLimiter.isDelayNeeded(), is(true));
        assertThat(RateLimiter.isDelayNeeded(), is(true));
        assertThat(RateLimiter.isDelayNeeded(), is(true));
        assertThat(RateLimiter.isDelayNeeded(), is(true));
        assertThat(RateLimiter.isDelayNeeded(), is(true));
        assertThat(RateLimiter.isDelayNeeded(), is(true));
        assertThat(RateLimiter.isDelayNeeded(), is(true));
        
        try {
            Thread.sleep(1005);
        } catch (InterruptedException ex) {
            Logger.getLogger(RateLimiterTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        assertThat(RateLimiter.isDelayNeeded(), is(false));
        RateLimiter.reset();
        
    }        
    
    @Test
    public void testRateBoundaries(){
        RateLimiter.reset();
        assertThat(RateLimiter.isDelayNeeded(), is(false));
        assertThat(RateLimiter.isDelayNeeded(), is(true));
        
        try {
            Thread.sleep(RateLimiter.getRate() - 2);
        } catch (InterruptedException ex) {
            Logger.getLogger(RateLimiterTest.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        assertThat(RateLimiter.isDelayNeeded(), is(true));
        
        try {
            Thread.sleep(RateLimiter.getRate() - 1);
        } catch (InterruptedException ex) {
            Logger.getLogger(RateLimiterTest.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        assertThat(RateLimiter.isDelayNeeded(), is(true));    
      
        try {
            Thread.sleep(RateLimiter.getRate());
        } catch (InterruptedException ex) {
            Logger.getLogger(RateLimiterTest.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        assertThat(RateLimiter.isDelayNeeded(), is(true));        
        
        try {
            Thread.sleep(RateLimiter.getRate() + 1);
        } catch (InterruptedException ex) {
            Logger.getLogger(RateLimiterTest.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        assertThat(RateLimiter.isDelayNeeded(), is(false));     

        try {
            Thread.sleep(RateLimiter.getRate() + 2);
        } catch (InterruptedException ex) {
            Logger.getLogger(RateLimiterTest.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        assertThat(RateLimiter.isDelayNeeded(), is(false));  
        
        RateLimiter.reset();
    }
}
