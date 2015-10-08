package simplePortfolioTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import simplePortfolio.Equity;
import simplePortfolio.IPosition;
import simplePortfolio.Position;

public class PositionTest {

	private Position position;
	
	public class TestPosition extends Position
	{
		public TestPosition(String ticker, int shares, double price, double targetAllocation, Equity equity) {
			super(ticker, shares, price, targetAllocation, equity);
			// TODO Auto-generated constructor stub
		}

		public TestPosition(String ticker, int shares, double price, double targetAllocation) {
			super(ticker, shares, price, targetAllocation);
			// TODO Auto-generated constructor stub
		}

		/**
		 * Override to keep this testing in scope without the use of mocks.
		 * @param ticker
		 * @return
		 */
		@Override
		protected Equity GetMarketEquity(String ticker) {
			return new Equity("XIU");
		}
	}
	
	@Before
	public void setUp() throws Exception {
		this.position = new Position("XIU", 100, 98.50, 100);
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test copy constructor
	 */
	@Test
	public void testPositionStringIntDoubleDoubleEquity() 
	{
		TestPosition testPosition = new TestPosition("XIU", 0, 0, 0, null);
		assertNotEquals("Constructor is not null", null, testPosition);
	}

	@Test
	public void testPositionStringIntDoubleDouble() {
		TestPosition testPosition = new TestPosition("XIU", 0, 0, 0);
		assertNotEquals("Constructor is not null", null, testPosition);
	}

	@Test
	public void testPositionIPosition() {
		IPosition testPosition = this.position;
		Position testPosition2 = new Position(testPosition);
		assertNotEquals("Constructor is not null", null, testPosition2);
	}

	@Test
	public void testGetMarketEquity() {
		assertEquals("Equity matches", "XIU" , this.position.getEquity().getTicker()); 
	}

	@Test
	public void testGetEquity() {
		assertEquals("Equity matches", "XIU" , this.position.getEquity().getTicker());
	}

}
