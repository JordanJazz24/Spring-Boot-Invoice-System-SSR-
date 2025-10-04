

# Spring-Boot-Invoice-System-SSR

**Author:** [JordanJazz24](https://github.com/JordanJazz24)
**Repository:** [FacturacionWEB](https://github.com/JordanJazz24/FacturacionWEB)
**Main Language:** Java
**Framework:** Spring Boot (Web MVC)
**Template Engine:** Thymeleaf
**Database:** MySQL
**Status:** In development

---

## Description

Spring-Boot-Invoice-System-SSR is a web-based system for comprehensive electronic invoicing management, aimed at suppliers of goods and services and their clients. The system is built using a robust three-layer architecture (Presentation, Logic, and Data), follows the Spring Boot MVC pattern in the presentation layer, and uses Thymeleaf as the template engine for strictly server-side rendering (SSR).

---

## Key Features

* **Supplier registration and management:**
  Allows individuals or companies to register as suppliers, manage their profile, and provide data required by Costa Rica’s Ministry of Finance.
* **Client management:**
  Register and manage frequent clients for each supplier.
* **Product/service management:**
  Register and manage the products or services offered by each supplier.
* **Electronic invoicing:**
  Create and manage electronic invoices, with viewing options in PDF and XML formats.
* **Access control and roles:**
  Session-based authentication, enabling features based on user roles (supplier or admin).
* **Administrative management:**
  Allows the administrator to approve, list, and deactivate suppliers.
* **Server-side rendering only:**
  No JavaScript is used; all interactions and views are generated using Thymeleaf on the backend.
* **Three-layer architecture:**
  Clear separation between Presentation (MVC/Thymeleaf), Business Logic (Services), and Data (Repositories/JPA).
* **Educational compliance:**
  It does not implement real integration with the Ministry of Finance, ATV, or CABYS catalog, but it is extendable for production use.

---

## Project Structure

```
FacturacionWEB/
├── src/
│   ├── main/java/com/example/facturacion/
│   │   ├── data/        # JPA Repositories (Users, Suppliers, Clients, Products, Invoices, Details)
│   │   ├── logic/       # Business logic (Services, entities)
│   │   └── ...          # Controllers and views (MVC)
│   └── resources/
│       └── templates/   # Thymeleaf views
└── README.md
```

---

## Main Entities and Flow

* **User:**
  Handles authentication and access control.
* **Supplier:**
  Linked to a user, manages clients, products, and invoices.
* **Client:**
  Associated with a supplier, receives invoices.
* **Product:**
  Goods or services registered by the supplier.
* **Invoice and Detail:**
  Represent electronic invoicing and its components.

---

## Installation and Execution

1. **Clone the repository:**

   ```bash
   git clone https://github.com/JordanJazz24/FacturacionWEB.git
   cd FacturacionWEB
   ```
2. **Configure the MySQL database** in `application.properties`.
3. **Build the project:**

   ```bash
   ./mvnw clean install
   ```
4. **Run the application:**

   ```bash
   ./mvnw spring-boot:run
   ```

   Access the app at `http://localhost:8080/`.

---

## Considerations and Exclusions

* It does not connect to the actual Ministry of Finance system.
* It does not implement ATV registration or use the CABYS catalog.
* Server-side rendering only (JavaScript is not allowed).
* Three-layer architecture and MVC pattern are mandatory.

---

## Contact

For suggestions or support, contact [JordanJazz24](https://github.com/JordanJazz24).


