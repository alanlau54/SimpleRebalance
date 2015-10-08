package simplePortfolioTest;

import java.util.List;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import simplePortfolio.Equity;
import simplePortfolio.IOrder;
import simplePortfolio.IOrder.Side;
import simplePortfolio.IPosition;
import simplePortfolio.Position;
import simplePortfolio.Positions;
import simplePortfolio.RebalanceAgent;

public class RebalanceAgentTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRebalanceAgent() {
		RebalanceAgent agent = new RebalanceAgent();
		assertNotEquals("Constructor is not null", null, agent);
	}
	
	@Test
	public void testGetTargetDeltaAllocationSimple() {
		RebalanceAgent agent = new RebalanceAgent();
		
		Positions currentPositions = new Positions();
		Position currentPosition = Helpers.CreatePosition ("X", 1, 100, 1, 1);
		currentPositions.AddPosition(currentPosition);
		currentPositions.UpdatePositions();
		
		Positions targetPositions = new Positions();
		Position targetPosition = Helpers.CreatePosition ("Y", 1, 100, 1, 1);
		targetPositions.AddPosition(targetPosition);
		targetPositions.UpdatePositions();
		
		List<IOrder> orders = agent.GetTargetDeltaTrades(currentPositions, targetPositions, 0);
		assertNotEquals("orders is not null", null, orders);
		assertEquals("orders size is 0", 2, orders.size());
		
		IOrder buyOrder = orders.get(0);	// For simplicity, must be in this sequence for now
		assertEquals("1st Order is Buy", Side.BUY, buyOrder.getSide());
		assertEquals("Buy Order is Y", "Y", buyOrder.getTicker());
		assertEquals("Buy Order 100", 1, buyOrder.getShares());
		
		IOrder sellOrder = orders.get(1);	// For simplicity, must be in this sequence for now
		assertEquals("2nd Order is Sell", Side.SELL, sellOrder.getSide());
		assertEquals("Sell Order is X", "X", sellOrder.getTicker());
		assertEquals("Sell Order 100", 1, sellOrder.getShares());
	}
	
	@Test
	public void testGetTargetDeltaAllocation() {
		RebalanceAgent agent = new RebalanceAgent();
		Positions currentPositions = Helpers.CreateDefaultPositions();
		Positions targetPositions = Helpers.CreateDefaultPositions();
		
		List<IOrder> orders = agent.GetTargetDeltaTrades(currentPositions, targetPositions, 0);
		assertNotEquals("orders is not null", null, orders);
		assertNotEquals("orders size is 0", 0, orders.size());
				
		assertEquals("MarketValue matches", 10000, targetPositions.getMarketValue(), Double.MIN_VALUE);
		assertEquals("BookValue matches", 10000, targetPositions.getBookValue(), Double.MIN_VALUE);
		
		// Update GOOG Equity price
		Equity newEquity = new Equity("GOOG");		
		IPosition googPos = targetPositions.getPositions().get(newEquity);
		assertNotEquals("googPos is not null", null, googPos);
		googPos.getEquity().setPrice(1);
		
		// MarketValue is updated
		targetPositions.UpdatePositions();
		assertEquals("MarketValue matches", 4956, targetPositions.getMarketValue(), Double.MIN_VALUE);
		assertEquals("BookValue matches", 10000, targetPositions.getBookValue(), Double.MIN_VALUE);
		
		orders = agent.GetTargetDeltaTrades(currentPositions, targetPositions, 5044);
		assertNotEquals("orders is not null", null, orders);
		assertEquals("orders size is 0", 2, orders.size());
	}

	@Test
	public void testGetTargetDeltaTrades() {
		Position currentPosition = Helpers.CreatePosition ("GOOG", 52, 98,.60, 98);
		Position targetPosition = Helpers.CreatePosition ("GOOG", 52, 98,.60, 1);
		
		RebalanceAgent agent = new RebalanceAgent();
		int shares = agent.GetTargetDeltaAllocation(currentPosition, targetPosition, 10000);
		assertEquals("Shares required", 6000, shares);	
	}
	
	@Test
	public void testGetTargetDeltaTradesSimpleBuy() {
		Position currentPosition = Helpers.CreatePosition ("X", 1, 100, 1, 1, 0);
		Position targetPosition = Helpers.CreatePosition ("X", 1, 100,1, 1);
		
		RebalanceAgent agent = new RebalanceAgent();
		int shares = agent.GetTargetDeltaAllocation(currentPosition, targetPosition, 100);
		assertEquals("Shares required", 100, shares);
	}
	
	@Test
	public void testGetTargetDeltaTradesSimpleSell() {
		Position currentPosition = Helpers.CreatePosition ("X", 1, 100, 1, 1, 1);
		Position targetPosition = Helpers.CreatePosition ("X", 1, 100,0, 1);
		
		RebalanceAgent agent = new RebalanceAgent();
		int shares = agent.GetTargetDeltaAllocation(currentPosition, targetPosition, 100);
		assertEquals("Shares required", -100, shares);	
	}
}
