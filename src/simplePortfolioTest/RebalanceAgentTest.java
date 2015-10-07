package simplePortfolioTest;

import static org.junit.Assert.assertThat;

import java.util.List;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import simplePortfolio.IOrder;
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
	public void testGetTargetDeltaAllocation() {
		RebalanceAgent agent = new RebalanceAgent();
		Positions currentPositions = Helpers.CreateDefaultPositions();
		Positions targetPositions = Helpers.CreateDefaultPositions();
		
		List<IOrder> orders = agent.GetTargetDeltaTrades(currentPositions, targetPositions);
		assertNotEquals("orders is not null", null, orders);
		
		
	}

	@Test
	public void testGetTargetDeltaTrades() {
		fail("Not yet implemented");
	}

}
