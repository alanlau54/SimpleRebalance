package simplePortfolioTest;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import simplePortfolio.Equity;
import simplePortfolio.IPosition;
import simplePortfolio.Position;
import simplePortfolio.Positions;

public class PositionsTest {
	
	/**
	 * Helper to create Position
	 * @param ticker
	 * @param shares
	 * @param avgPrice
	 * @param targetAllocation
	 * @param mktPrice
	 * @return
	 */
	Position CreatePosition(String ticker, int shares, double avgPrice, double targetAllocation, double mktPrice) {
		Equity equity = new Equity(ticker);
		equity.setPrice(mktPrice);
		return new Position(ticker, shares, avgPrice, targetAllocation, equity);
	}

	Positions CreateDefaultPositions() {
		Position googPos = CreatePosition ("GOOG", 52, 98,.60, 98);
		Position aaplPos = CreatePosition ("AAPL", 136, 22,.30, 22);
		Position tslaPos = CreatePosition ("TSLA", 239, 8,.10, 8);
		Positions positions = new Positions();
		positions.AddPosition(googPos);
		positions.AddPosition(aaplPos);
		positions.AddPosition(tslaPos);
		return positions;
	}	
	
	@Before
	public void setUp() throws Exception {
		// SetUp sample portfolio positions
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPositions() {
		Positions positions = new Positions();
		assertNotEquals("Constructor is not null", null, positions);
	}

	@Test
	public void testUpdatePositions() {
		Positions positions = CreateDefaultPositions();
		positions.UpdatePositions();
		assertEquals("MarketValue matches", 10000, positions.getMarketValue(), Double.MIN_VALUE);
		assertEquals("BookValue matches", 10000, positions.getBookValue(), Double.MIN_VALUE);
		
		HashMap<Equity, IPosition> positionsMap = positions.getPositions();
		IPosition position = positionsMap.get(new Equity("GOOG"));
		assertEquals("Ticker matches","GOOG", position.getTicker());
		assertEquals("Actual Allocation matches",0.5096, position.getActualAllocation(),Double.MIN_VALUE);
		assertEquals("Actual Allocation matches",0.2992, positionsMap.get(new Equity("AAPL")).getActualAllocation(),Double.MIN_VALUE);
		assertEquals("Actual Allocation matches",0.1912, positionsMap.get(new Equity("TSLA")).getActualAllocation(),Double.MIN_VALUE);
	}

	@Test
	public void testGetPositions() {
		Positions positions = new Positions();
		HashMap<Equity, IPosition> positionsMap = positions.getPositions();
		
		assertNotEquals("Constructor is not null", null, positionsMap);
		assertEquals("PositionsMap is empty", true, positionsMap.isEmpty()); 
		
	}

	/**
	 * Test Apply Position
	 */
	@Test
	public void testApplyPosition() {
		Positions positions = new Positions();
		Position googPos = CreatePosition ("GOOG", 52, 100,.60, 98);
		positions.AddPosition(googPos);
		assertEquals("Not Empty", false, positions.getPositions().isEmpty());
		
		assertEquals("BookValue matches", 5200, positions.getBookValue(), Double.MIN_VALUE);
		assertEquals("MarketValue matches", 5096, positions.getMarketValue(), Double.MIN_VALUE);
		
		Position aaplPos = CreatePosition ("AAPL", 136, 100,.30, 22);
		positions.AddPosition(aaplPos);
		
		Position tslaPos = CreatePosition ("TSLA", 239, 100,.10, 8);
		positions.AddPosition(tslaPos);
		assertEquals("MarketValue matches", 10000, positions.getMarketValue(), Double.MIN_VALUE);
		
	}

}
