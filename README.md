# Simple Rebalance Agent
This is sample project that implements a simple portfolio rebalancing module. 
The project contains a portfolio holding equity positions. Each position has a ticker,shares, target allocation and actual allocation. As prices fluctuate, the actual allocations of investments may diverge from the target allocations.

##Technical Design Decisions
* Single theaded for simplicity. Do not have to worry about changing quotes.
* EquityFactory singleton is used to be easy access and hook into updates by a market feed.

More Time:
* Cash is not accounted for changing positions.
* Implementation shortfall not accounted for.
* Equity Stock boardlots
* Avg Price calculation
* Load/Save Portfolio
* Possibly use BigDecimal for prices
* Integration testing where quotes are modified and portfolio changes can be seen

##Requirements
* javaSE 1.7
* JUnit 4

##Installation

##Testing

##Contact

##Known Bugs
