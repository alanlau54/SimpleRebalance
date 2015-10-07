package simplePortfolio;
public class Position extends Execution implements IPosition {

	private Equity equity;
	private double targetAllocation;
	private double actualAllocation;
	
	public Position(String ticker, int shares, double price, double targetAllocation, Equity equity) {
		super(ticker, shares, price);
		this.targetAllocation = targetAllocation;
		if (equity == null)
			this.equity = GetMarketEquity(ticker); 
		else
			this.equity = equity;
	}
		
	public Position(String ticker, int shares, double price, double targetAllocation) {
		this(ticker, shares, price, targetAllocation,  null);
	}
	
	public Position(IPosition position) {
		this(position.getTicker(), position.getShares(), position.getAvgPrice(), position.getTargetAllocation(), position.getEquity());
	}
		
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
