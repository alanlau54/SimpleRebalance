package simplePortfolio;

public interface IOrder {
	public enum Side { BUY, SELL };
	
	public Side getSide();
	public void setSide(Side side);
	
	public String getTicker();
	public void setTicker(String ticker);
	
	public int getShares();
	public void setShares(int shares);
	
	public double getPrice();
	public void setPrice(double price);
}

