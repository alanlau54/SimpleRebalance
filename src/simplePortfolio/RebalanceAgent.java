package simplePortfolio;
import java.util.ArrayList;
import java.util.List;

/**
 * This class will represent the agent that determines the orders to be done to achieve rebalance.
 * TBD: Extend to plug in different strategies here that may account for cash, commissions, tradesize.
 * @author Alan
 *
 */
public class RebalanceAgent {
	
	public RebalanceAgent() {
		
	}
	
	public int GetTargetDeltaAllocation(IPosition currentPosition, IPosition targetPosition, double netAssetValue) {	
		double diffPct = (targetPosition.getTargetAllocation() - currentPosition.getActualAllocation());
		double diffValue = netAssetValue * diffPct;
		double equityPrice = targetPosition.getEquity().getPrice();	
		int shares = (equityPrice) !=0 ? (int)Math.floor(diffValue / equityPrice) : 0; 
		return shares;		
	}
	
	public List<IOrder> GetTargetDeltaTrades(Positions currentPositions, Positions targetPositions) {
		List<IOrder> deltaTrades = new ArrayList<IOrder>();
		for (IPosition targetPosition : targetPositions.getPositions().values()) {
			IPosition currentPosition = currentPositions.getPositions().get(targetPosition.getEquity());	
			if (currentPosition == null) {
				Position newPositon = new Position(targetPosition);
				deltaTrades.add(newPositon);
			}
			else {
				int deltaShares = GetTargetDeltaAllocation(currentPosition,targetPosition, targetPositions.getMarketValue());
				if (deltaShares != 0) {
					Position newPositon = new Position(targetPosition.getTicker(), deltaShares, targetPosition.getAvgPrice(), targetPosition.getTargetAllocation(),targetPosition.getEquity());
					deltaTrades.add(newPositon);
				}			
			}
		}	
		return null;
	}

}
