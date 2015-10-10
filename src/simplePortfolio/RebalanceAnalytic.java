package simplePortfolio;

public class RebalanceAnalytic {
	
	public int GetTargetDeltaShares(double currentPct, double targetPct, double netAssetValue, double equityPrice) {
		double deltaValue = GetTargetDeltaValue( currentPct, targetPct,  netAssetValue) ;
		int shares = GetSharesForValue(deltaValue, equityPrice);
		return shares;
	}
	
	/**
	 * Calculates the value needed to move from the currentPct to targetPct 
	 * @param currentPct
	 * @param targetPct
	 * @param netAssetValue
	 * @return
	 */
	public double GetTargetDeltaValue(double currentPct, double targetPct, double netAssetValue) {	
		double diffPct = (targetPct - currentPct);
		double diffValue = netAssetValue * diffPct;
		return diffValue; 
	}
	
	/**
	 * Calculates the shares required to be traded at a given price to achieve a given value 
	 * @param deltaValue
	 * @param equityPrice
	 * @return
	 */
	public int GetSharesForValue(double deltaValue, double equityPrice) {	
		int shares = (equityPrice) !=0 ? (int)Math.floor(deltaValue / equityPrice) : 0; 
		return shares;		
	}
}
