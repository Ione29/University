# First SDT Project

A large e-commerce retailer offers very often promotions. It is becoming difficult to manually add products to promotions or to set different promotion rates. You are tasked with building a customizable promotion engine that can apply promotions depending on product type, sale volumes or any other criteria.  

## Design Patterns Used
- Builder (for building modular instances of the Product Class)
- Strategy (for defining the different behaviours of each promotion type)
- Factory (for creating promotion objects easily)
- Singleton (for managing active promotions)