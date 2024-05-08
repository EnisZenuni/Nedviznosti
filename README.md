Build based on the Ports and Adapters (Hexagoanal architecture)
- Adhering DDD practices.
- Keeping the domain module clear and indepedent from any external dependencies/services.
- Domain module contains the domain business logic
- Infrastructure module contains the external dependencies such as Persistance and Authentication
- Service module contains DTO, Controllers and Mappers to handle the incomming requests.
- Communication between layers is done via abstraction ( Interfaces, Mappers and DTO's)
- Each module contains the dependencies needed for their implementation and each of them inherit the domain module
