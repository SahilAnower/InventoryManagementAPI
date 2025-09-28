# InventoryManagementAPI

## ⚙️ Setup Instructions
- Clone, have JDK 17, Apache Maven installed on system, run on Spring Boot 3.x.x
- Give necessary permissions and start the application from the main class, after allowing annotations
- Can download the postman collection on local, and run the APIs for testing out all the validations and CRUD operations

## Assumptions/Design Choices
- Layered Architecture - Controller (REST) -> Service (Business Logic) -> Repository (DAO) -> Data Storage (In-memory Map)
- Immutability and Defensive Copying
- Interface Segregation and DI with Loose Coupling for future extendability
- Comprehensive centralized error-handling
