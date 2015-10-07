package simplePortfolioTest;

import simplePortfolio.Equity;
import simplePortfolio.Position;
import simplePortfolio.Positions;

public class Helpers {

	/**
	 * Helper to create Position
	 * @param ticker
	 * @param shares
	 * @param avgPrice
	 * @param targetAllocation
	 * @param mktPrice
	 * @return
	 */
	public static Position CreatePosition(String ticker, int shares, double avgPrice, double targetAllocation, double mktPrice) {
		Equity equity = new Equity(ticker);
		equity.setPrice(mktPrice);
		return new Position(ticker, shares, avgPrice, targetAllocation, equity);
	}

	public static Positions CreateDefaultPositions() {
		Position googPos = CreatePosition ("GOOG", 52, 98,.60, 98);
		Position aaplPos = CreatePosition ("AAPL", 136, 22,.30, 22);
		Position tslaPos = CreatePosition ("TSLA", 239, 8,.10, 8);
		Positions positions = new Positions();
		positions.AddPosition(googPos);
		positions.AddPosition(aaplPos);
		positions.AddPosition(tslaPos);
		return positions;
	}	

}
