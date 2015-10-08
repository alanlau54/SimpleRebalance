package simplePortfolio;

/**
 * This class represents an execution report from a previously sent order
 * Note: The average price is assumed to be of a single fill for simplicity.
 * @author Alan
 *
 */
public class Execution extends Order implements IExecution {
	
	double avgPrice;
	
	public Execution(Side side, String ticker, int shares, double price) {
		super(side, ticker, shares, price);
		this.avgPrice = price;
	}

	public double getAvgPrice() {
		return avgPrice;
	}
	
}
