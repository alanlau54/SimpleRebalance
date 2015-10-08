# Simple Rebalance Agent
This is sample project that implements a simple portfolio rebalancing module. 
The project contains a portfolio holding equity positions. Each position has a ticker,shares, target allocation and actual allocation. As prices fluctuate, the actual allocations of investments may diverge from the target allocations.

##Technical Details
* Single theaded for simplicity.
* Equity quotes are designed to be updated by some type of market feed.
* Cash is not accounted for changing positions.
* Implementation shortfall not accounted for.
* Equity Stock boardlots
* Avg Price calculation
* Load/Save Portfolio

More Time:
* Possibly use BigDecimal for prices
* Integration testing where quotes are modified and portfolio changes can be seen

##Requirements
* javaSE 1.7
* JUnit 4

##Installation

##Testing

##Contact

##Known Bugs
