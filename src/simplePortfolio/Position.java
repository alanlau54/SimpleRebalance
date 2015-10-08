package simplePortfolio;
/**
 * This represents an equity holding in a portfolio.
 * 
 * @author Alan
 *
 */
public class Position extends Execution implements IPosition {

	private Equity equity;
	private double targetAllocation;
	private double actualAllocation;
	
	/**
	 * This constructor will create a default Position. BUY side as default for this sample. 
	 * @param ticker
	 * @param shares
	 * @param price
	 * @param targetAllocation
	 * @param equity
	 */
	public Position(String ticker, int shares, double price, double targetAllocation, Equity equity) {
		super(Side.BUY, ticker, shares, price);
		this.targetAllocation = targetAllocation;
		if (equity == null)
			this.equity = GetMarketEquity(ticker); // Snapshot a new equity
		else
			this.equity = equity;
	}
		
	public Position(String ticker, int shares, double price, double targetAllocation) {
		this(ticker, shares, price, targetAllocation,  null);
	}
	
	public Position(IPosition position) {
		this(position.getTicker(), position.getShares(), position.getAvgPrice(), position.getTargetAllocation(), position.getEquity());
	}
		
	/**
	 * This will get an updated snapshot of the equity
	 * @param ticker
	 * @return
	 */
	protected Equity GetMarketEquity(String ticker)
	{
		return EquityFactory.getInstance().GetEquity(ticker);
	}

	@Override
	public Equity getEquity() {
		return equity; 
	}

	@Override
	public double getBookValue() {
		return shares * price;
	}
	
	/* 
	 * This will get the market value of this position.
	 * Note: Uses a snapshot equity for simplicity here.
	 */
	@Override
	public double getMarketValue() {
		Equity equity = getEquity();
		return shares * equity.price;
	}
	
	@Override
	public double getTargetAllocation() {
		return targetAllocation;
	}

	@Override
	public void setTargetAllocation(double targetAllocation) {
		this.targetAllocation = targetAllocation;
	}

	@Override
	public double getActualAllocation() {
		return this.actualAllocation;
	}

	@Override
	public void setActualAllocation(double actualAllocation) {
		this.actualAllocation = actualAllocation;
	}
}
