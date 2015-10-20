# Rebalance Analytic
This is sample project that implements a portfolio rebalancing analytic
The project contains a portfolio holding equity positions. Each position has a ticker, shares, target allocation and actual allocation. As prices fluctuate, the actual allocations of investments may diverge from the target allocations.

##Technical Design Decisions
* RebalanceAnalytic is the core calculation
* Single theaded for simplicity. No need to add locks and synchronize changing quote prices.
* EquityFactory singleton is used to be easy access and hook into updates by a market feed.
* Positions updated on demand for simplicity.
* Order, Execution, Position object hierarchy can lead to a unified trade object for the entire application.

Given More Time:
* Fully implement cash in changing positions. 
* Logger for order/position state.
* Update Equity object with market feed.
* Add Country to Equity object to support CAN tickers.
* Use actual equity stock boardlots.
* Avg Price calculation for each position with Execution history.
* Load/Save Portfolio.
* Possibly use BigDecimal for prices.

##Requirements
* javaSE 1.8
* JUnit 4

##Installation
* Github Download ZIP, clone in desktop or view src folder.

##Usage
```
// Method call in RebalanceAnalytic.java to retrieve the number of shares required to move from current to target
int GetTargetDeltaShares(double currentPct, double targetPct, double netAssetValue, double equityPrice)

RebalanceAnalytic analytic= new RebalanceAnalytic()

// The following translates to 0% Current, 100 Target, 10000 NAV, 100 Price = Buy 100 shares
analytic.GetTargetDeltaShares(0, 1, 10000, 100) = 100

// The following translates to 100% Current, 0% Target, 10000 NAV, 100 Price = Sell 100 shares
analytic.GetTargetDeltaShares(1, 0, 10000, 100) = -100
```

##Testing
* See unit test in simplePortfolioTest

##Contact
* alanlau54@gmail.com

##Known Issues
* Rounding may leave portfolio less than fully allocated.
* Does not support CAN tickers.
