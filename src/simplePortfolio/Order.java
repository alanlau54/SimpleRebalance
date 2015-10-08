package simplePortfolio;

/**
 * This class represents an order to be sent to a broker.
 * @author Alan
 *
 */
public class Order implements IOrder {

	protected Side side;
	protected String ticker;
	protected int shares;
	protected double price;
	
	public Order(Side side, String ticker, int shares, double price)
	{
		this.side = side;
		this.ticker = ticker;
		this.shares = shares;
		this.price=price;
	}
	
	@Override
	public Side getSide() {
		return this.side;
	}

	@Override
	public void setSide(Side side) {
		this.side = side;
	}
	
	@Override
	public String getTicker() {
		return ticker;
	}
	
	@Override
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	@Override
	public int getShares() {
		return shares;
	}
	
	@Override
	public void setShares(int shares) {
		this.shares = shares;
	}
	
	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public void setPrice(double price) {
		this.price = price;
	}
}
