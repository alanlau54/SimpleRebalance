package simplePortfolio;
import java.util.HashMap;

/**
 * Represents all the equity holdings for a portfolio. 
 * @author Alan
 *
 */
public class Positions {
	private double bookValue;
	private double marketValue;
	private HashMap<Equity,IPosition> positions = new HashMap<Equity,IPosition>();
	
	public Positions() {
	}
	
	/**
	 * Update all the positions with the current equity prices and their actual allocations
	 */
	public void UpdatePositions()
	{
		double netAssetValue = CalculateNAV(positions);
		UpdateAllocations (positions, netAssetValue);
	}
	
	/**
	 * Update all the positions with their actual allocation
	 * @param positions
	 * @param netAssetValue
	 */
	public void UpdateAllocations(HashMap<Equity,IPosition> positions, double netAssetValue)
	{
		for (IPosition position : positions.values()){
			UpdateAllocation(position,netAssetValue);
		}
	}
	
	/**
	 * Update a position with the calculated actual allocation  
	 * @param position
	 * @param netAssetValue
	 */
	public void UpdateAllocation(IPosition position, double netAssetValue) {
		if (netAssetValue==0)
			return;
		
		double actualAllocation = position.getMarketValue() / netAssetValue;
		position.setActualAllocation(actualAllocation);
	}
	
	/**
	 * Calculate the net asset value of all the positions
	 * @param positions
	 * @return
	 */
	private double CalculateNAV(HashMap<Equity,IPosition> positions) {	
		marketValue=0.0;
		for (IPosition pos : positions.values()){
			marketValue += pos.getMarketValue();
		}
		return marketValue;
	}
		
	public double getBookValue() {
		return bookValue;
	}

	public double getMarketValue() {
		return marketValue;
	}

	public void setMarketValue(double marketValue) {
		this.marketValue = marketValue;
	}

	public HashMap<Equity, IPosition> getPositions() {
		return positions;
	}

	/**
	 * Add a position.
	 * Note BookValue and MarketValue are cached here for performance. 
	 * @param position
	 */
	public void AddPosition(IPosition position) {
		Equity equity = position.getEquity();
		if (!positions.containsKey(equity)) {
			positions.put(equity, position);
			bookValue += position.getBookValue();
			marketValue += position.getMarketValue();
		}
	}
	
}
