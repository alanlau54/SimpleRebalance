package simplePortfolio;

public interface IPosition extends IExecution {
	public double getBookValue();
	public double getMarketValue();
	public Equity getEquity();
	public double getTargetAllocation();
	public void setTargetAllocation(double targetAllocation);
	public double getActualAllocation();
	public void setActualAllocation(double actualAllocation);
}
