package simplePortfolio;
import java.util.ArrayList;
import java.util.List;

import simplePortfolio.IOrder.Side;

/**
 * This class will represent the agent that determines the orders to be done to achieve rebalance.
 * TBD: Extend to plug in different strategies here that may account for cash, commissions, tradesize.
 * @author Alan
 *
 */
public class RebalanceAgent {
	
	protected RebalanceAnalytic analytic = new RebalanceAnalytic();
	
	public RebalanceAgent() {
	}
	
	/**
	 * This method will calculate the number of shares required to move from the current allocation percent to the
	 * target allocation percent for a given equity at the mkt price.
	 * @param currentPosition
	 * @param targetPosition
	 * @param netAssetValue
	 * @return
	 */
	public int GetTargetDeltaAllocation(IPosition currentPosition, IPosition targetPosition, double netAssetValue) {		
		int shares = analytic.GetTargetDeltaShares(currentPosition.getActualAllocation(), targetPosition.getTargetAllocation(), netAssetValue, targetPosition.getEquity().price); 
		return shares;		
	}
	
	/**
	 * This method will generate a list of orders to achieve the target positions.
	 * @param currentPositions
	 * @param targetPositions
	 * @param cash
	 * @return
	 */
	public List<IOrder> GetTargetDeltaTrades(Positions currentPositions, Positions targetPositions, double cash) {
		List<IOrder> deltaTrades = new ArrayList<IOrder>();
		
		// Add new positions
		for (IPosition targetPosition : targetPositions.getPositions().values()) {
			IPosition currentPosition = currentPositions.getPositions().get(targetPosition.getEquity());	
			if (currentPosition == null) {
				// Add new position
				IOrder order = new Position(targetPosition);
				deltaTrades.add(order);
			}
			else {
				// Modify current position
				int deltaShares = GetTargetDeltaAllocation(currentPosition,targetPosition, targetPositions.getMarketValue()+cash);
				IOrder order;
				// TBD: move to position manager
				if (deltaShares > 0) {				
					order = new Order( Side.BUY, targetPosition.getTicker(), deltaShares, targetPosition.getAvgPrice());
					deltaTrades.add(order);
				}
				else if (deltaShares < 0) {
					order = new Order( Side.SELL, targetPosition.getTicker(), Math.abs(deltaShares), targetPosition.getAvgPrice());
					deltaTrades.add(order);
				}
			}			
		}
		
		// Remove obsolete positions
		for (IPosition currentPosition : currentPositions.getPositions().values()) {
			IPosition targetPosition = targetPositions.getPositions().get(currentPosition.getEquity());	
			if (targetPosition == null) {
				IOrder order = new Position(currentPosition);
				order.setSide(Side.SELL);
				deltaTrades.add(order);
			}
		}
		return deltaTrades;
	}
}
