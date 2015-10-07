package simplePortfolio;

/**
 * This class represents an order to be sent to a broker.
 * @author Alan
 *
 */
public class Order {

	protected String ticker;
	protected int shares;
	protected double price;
	
	public Order(String ticker, int shares, double price)
	{
		this.ticker = ticker;
		this.shares = shares;
		this.price=price;
	}
	
	public String getTicker() {
		return ticker;
	}

	public int getShares() {
		return shares;
	}
	
	public double getPrice() {
		return price;
	}
}
