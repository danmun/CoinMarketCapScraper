/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coinmarketcapscraper;

import coinmarketcapscraper.listentries.HistoricalDataEntry;
import java.time.Period;

/**
 *
 * @author danmun
 */
public class HistoricalData {
    private Period dateRange;
    private HistoricalDataEntry[] entries;
}
