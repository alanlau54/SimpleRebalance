package simplePortfolio;
import java.util.HashMap;

public class Positions {
	private double bookValue;
	private double marketValue;
	private HashMap<Equity,IPosition> positions = new HashMap<Equity,IPosition>();
	
	public Positions() {
	}
	
	public void UpdatePositions()
	{
		double netAssetValue = CalculateNAV(positions);
		UpdateAllocations (positions, netAssetValue);
	}
	
	public void UpdateAllocations(HashMap<Equity,IPosition> positions, double netAssetValue)
	{
		for (IPosition position : positions.values()){
			UpdateAllocation(position,netAssetValue);
		}
	}
	
	public void UpdateAllocation(IPosition position, double netAssetValue) {
		if (netAssetValue==0)
			return;
		
		double actualAllocation = position.getMarketValue() / netAssetValue;
		position.setActualAllocation(actualAllocation);
	}
	
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

	public void AddPosition(IPosition position) {
		Equity equity = position.getEquity();
		if (!positions.containsKey(equity)) {
			positions.put(equity, position);
			bookValue += position.getBookValue();
			marketValue += position.getMarketValue();
		}
	}
	
}
