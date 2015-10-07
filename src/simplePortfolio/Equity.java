package simplePortfolio;

/**
 * Represents an Equity in the market
 * The Equity will be a snapshot of the market
 * @author Alan
 * 
 */
public class Equity {
	String ticker;
	double price;	
	int lotsize;
	
	/**
	 * Creates a new Equity with the given ticker
	 * Symbol resolution and lotsize data will be generally done here
	 * NOTE:Ticker is not unique without country  
	 * @param ticker
	 */
	public Equity(String ticker) {
		this.ticker = ticker;
		this.lotsize = 1; 	// TBD: Supplied by security master;
	}
	
	/**
	 * Lotsize will be typically provided by a security mast
	 * er in market data
	 * @return lotsize of equity
	 */
	public int getLotsize() {
		return lotsize;		
	}
	
	/**
	 * Gets the ticker of this equity
	 * This may be resolved by symbol resolution
	 * @return ticker of this equity
	 */
	public String getTicker() {
		return ticker;
	}
	
	/**
	 * Sets the ticker for this equity
	 * This may go through symbol resolution
	 * @param ticker for this equity
	 */
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	
	/**
	 * Gets the current last market price for this equity
	 * This is a general estimation of the equity's price. Current Bid/Ask would be more accurate
	 * @return price of this equity
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * Sets the current last market price for this equity
	 * @param price for this equity
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Equity [ticker=" + ticker + ", price=" + price + ", lotsize=" + lotsize + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + lotsize;
		result = prime * result + ((ticker == null) ? 0 : ticker.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equity other = (Equity) obj;
		if (lotsize != other.lotsize)
			return false;
		if (ticker == null) {
			if (other.ticker != null)
				return false;
		} else if (!ticker.equals(other.ticker))
			return false;
		return true;
	}

}
