package simplePortfolio;
public class Portfolio {
	Positions positions;
	double cash;
	
	public double getCash() {
		return cash;
	}

	public void setCash(double cash) {
		this.cash = cash;
	}

	public Portfolio() {
		InitializePositions();
	}
	
	private void InitializePositions() {
		this.positions = new Positions();
	}
	
	public void LoadPositions() {
		// TBD Load from file
	}
			
	// Applies position to Positions
	public void AddPosition(IPosition position) {
		positions.AddPosition(position);
	}
	
	public double Value() {
		double nav = positions.getMarketValue() + cash;
		return nav;
	}
	
	
	// TBD takes in strategy and return positions
	public void LoadTargets() {
		
	}
}
