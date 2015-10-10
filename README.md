# Rebalance Agent
This is sample project that implements a portfolio rebalancing application
The project contains a portfolio holding equity positions. Each position has a ticker, shares, target allocation and actual allocation. As prices fluctuate, the actual allocations of investments may diverge from the target allocations.

##Technical Design Decisions
* RebalanceAnalytic is the core calculation
* Single theaded for simplicity. No need to add locks and synchronize changing quote prices.
* EquityFactory singleton is used to be easy access and hook into updates by a market feed.
* Positions updated on demand for simplicity.
* Order, Execution, Position object hierarchy can lead to a unified trade object for the entire application.

Given More Time:
* Add strategy to RebalanceAgent to support different balancing methods.
* Fully implement cash in changing positions. 
* Logger for order/position state.
* Account for Implementation shortfall.
* Update Equity object with market feed.
* Add Country to Equity object to support CAN tickers.
* Use actual equity stock boardlots.
* Avg Price calculation for each position with Execution history.
* Load/Save Portfolio.
* Add a position manager to send orders.
* Possibly use BigDecimal for prices.
* Integration testing where quotes are modified and portfolio changes can be seen.

##Requirements
* javaSE 1.7
* JUnit 4

##Installation
* Github Download ZIP, clone in desktop or view src folder.

##Usage
* Example to retrieve the number of shares required to move from current to target
  GetTargetDeltaShares(double currentPct, double targetPct, double netAssetValue, double equityPrice)

 RebalanceAnalytic analytic= new RebalanceAnalytic()
 analytic.GetTargetDeltaShares(0, 1, 10000, double 100) = 100
 // This translates to Buy 100 shares 

 analytic.GetTargetDeltaShares(1, 0, 10000, double 100) = -100
 // This translates to Sell 100 shares

##Testing
* See unit test in simplePortfolioTest

##Contact
* alanlau54@gmail.com

##Known Issues
* Rounding may leave portfolio less than fully allocated.
* Does not support CAN tickers.
* Updating new quotes is a bit clunky.
* Viewing rebalance orders could be easier
