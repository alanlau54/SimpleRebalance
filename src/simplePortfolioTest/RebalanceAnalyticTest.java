package simplePortfolioTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import simplePortfolio.RebalanceAnalytic;

public class RebalanceAnalyticTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void GetSharesForValueTest() {
		RebalanceAnalytic rebalanceAnalytic = new RebalanceAnalytic();
		int shares = rebalanceAnalytic.GetSharesForValue(100000,100 );
		assertEquals("Get Shares for Value", 1000 , shares);
	}
	
	@Test
	public void GetTargetDeltaValueTest() {
		RebalanceAnalytic rebalanceAnalytic = new RebalanceAnalytic();
		// Add Test
		double value = rebalanceAnalytic.GetTargetDeltaValue(0, .50, 10000);
		assertEquals("Get Target Value delta", 5000, value, Double.MIN_VALUE);
		
		// Remove Test
		value = rebalanceAnalytic.GetTargetDeltaValue(1.00, .50, 10000);
		assertEquals("Get Target Value delta", -5000, value, Double.MIN_VALUE);
	}
	
	@Test
	public void GetTargetDeltaSharesTest() {
		RebalanceAnalytic rebalanceAnalytic = new RebalanceAnalytic();
		// Add Test
		int shares = rebalanceAnalytic.GetTargetDeltaShares(0, .50, 100000, 100);
		assertEquals("Get Target Shares to Add", 500, shares);
		
		// Remove Test
		shares = rebalanceAnalytic.GetTargetDeltaShares(1.00, .50, 100000, 100);
		assertEquals("Get Target Shares to remove", -500, shares);
	}

}
