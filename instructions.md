# ITEA 10 - Blue Grade: YAGNI Principle in Hexagonal Architecture

### Introduction

This week, we're exploring the YAGNI (You Ain't Gonna Need It) principle within the context of hexagonal architecture using our Spring Boot-based bank account service. YAGNI is a critical aspect of Agile and Clean Code practices, emphasizing the importance of not adding functionality until it's deemed necessary.

### Understanding YAGNI

YAGNI is about avoiding over-engineering and focusing on what is necessary at the moment. It encourages simplicity and minimalism in code design, ensuring that we only spend time on things that bring immediate value.

### Hexagonal Architecture and YAGNI

In hexagonal architecture, the separation of core logic from external components through ports and adapters enables us to apply YAGNI in choosing our data storage solutions. We can start with simple solutions like JSON files or in-memory databases and evolve to more complex databases only if needed.

### Rules

- Focus on implementing the YAGNI principle in the context of our existing bank account service.
- Remember to keep your implementations simple and only add what is necessary.
- Aim for a clear demonstration of how hexagonal architecture supports YAGNI.

## Task 1 - Discussing YAGNI in the Context of Hexagonal Architecture

Before diving into the coding challenge, let's discuss how hexagonal architecture enables the application of the YAGNI principle effectively.

### a) **Simplicity in Design**<br/>

**Question:** How does hexagonal architecture help maintain simplicity in the design of our bank account service? Discuss the benefits of starting with simpler data storage solutions.

### b) **Evolving the System**<br/>

**Question:** Explore how the system can evolve from using simple data storage to more complex ones under the YAGNI principle. Discuss the ease of making such changes in a hexagonal architecture setup.

## Task 2 - Coding Challenge: Evolving Data Storage

The current bank account service uses an in-memory database for simplicity. The challenge is to refactor the code to allow easy swapping of the data storage solution, adhering to the YAGNI principle.

### Provided Code Base

- The existing bank account service code with in-memory database implementation.
- Tests covering the basic functionalities of the service.

### Your Task

- Refactor the service to allow easy replacement of the data storage mechanism.
- Ensure the core application logic remains unchanged while swapping storage solutions.
- Write tests to demonstrate that the refactoring doesn't affect the existing functionalities.

### Focus Points

- Keep the refactoring minimal and straightforward.
- Demonstrate how your changes align with the YAGNI principle.
- Discuss the potential future extensions that can be made, keeping YAGNI in mind.

## Extra Credit

- Propose a scenario where transitioning to a more complex database would be necessary.
- Discuss how the hexagonal architecture would facilitate this transition.
