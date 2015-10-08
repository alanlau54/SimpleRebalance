/**
 * 
 */
package simplePortfolioTest;

import static org.junit.Assert.*;

import org.junit.Test;

import simplePortfolio.Equity;

/**
 * Test Equity
 * @author Alan
 *
 */
public class EquityTest {

	@Test
	public void testTicker() {
		String ticker = "XIU";
		Equity equity = new Equity(ticker);
		assertEquals("Same Ticker", "XIU", equity.getTicker());
	}
	
	@Test
	public void testLotSize() {
		String ticker = "XIU";
		Equity equity = new Equity(ticker);
		assertEquals("Same Lotsize", 1, equity.getLotsize());
	}
	
	@Test
	public void testPrice() {
		String ticker = "XIU";
		Equity equity = new Equity(ticker);
		assertEquals("Initial Price", 0.0, equity.getPrice(), Double.MIN_VALUE);
		
		equity.setPrice(98.50);
		assertEquals("Set Price", 98.50, equity.getPrice(), Double.MIN_VALUE);
	}
	
}
