package simplePortfolio;
/**
 * Represents a equity manager to distribute equities.
 * @author Alan
 *
 */
public class EquityFactory {
	
	private static EquityFactory instance = null;
	
    protected EquityFactory() {
    	// Exists only to defeat instantiation.
    }
	      	   
	/**
	 * Returns the single instance of the EquityManger
	 * @return EquityManager
	 */
	public static EquityFactory getInstance() {
		
	     if(instance == null) {
	         instance = new EquityFactory();
	      }
	      return instance;
	}
	   
	/**
	 * Returns an equity snapshot of a given ticker
	 * @param ticker
	 * @return Equity
	 */
	public Equity GetEquity(String ticker) {
		   return new Equity(ticker);
	}
	
}
