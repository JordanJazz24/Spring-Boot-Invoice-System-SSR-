# FacturacionWEB

**Autor:** [JordanJazz24](https://github.com/JordanJazz24)  
**Repositorio:** [FacturacionWEB](https://github.com/JordanJazz24/FacturacionWEB)  
**Lenguaje Principal:** Java  
**Framework:** Spring Boot (MVC Web)  
**Motor de Plantillas:** Thymeleaf  
**Base de Datos:** MySQL  
**Estado:** En desarrollo

---

## Descripción

FacturacionWEB es un sistema web para la gestión completa de facturación electrónica, dirigido a proveedores de bienes y servicios y sus clientes. El sistema utiliza una arquitectura robusta de tres capas (Presentación, Lógica y Datos), sigue el patrón MVC de Spring Boot en la capa de presentación y emplea Thymeleaf como motor de plantillas para renderizado exclusivo del lado del servidor (SSR).

---

## Características principales

- **Registro y gestión de proveedores:**  
  Permite que personas físicas o jurídicas se registren como proveedores, gestionen su perfil y datos requeridos por el Ministerio de Hacienda de Costa Rica.
- **Gestión de clientes:**  
  Registro y administración de clientes habituales para cada proveedor.
- **Gestión de productos/servicios:**  
  Registro y administración de productos o servicios ofrecidos por cada proveedor.
- **Facturación electrónica:**  
  Creación y manejo de facturas electrónicas, visualización en PDF y XML.
- **Control de acceso y roles:**  
  Autenticación por sesión, habilitando funcionalidades según el rol del usuario (proveedor o administrador).
- **Gestión administrativa:**  
  Permite al administrador aceptar, listar y desactivar proveedores.
- **Renderizado solo del lado del servidor:**  
  No se utiliza JavaScript; toda la interacción y vistas se generan con Thymeleaf en el backend.
- **Arquitectura en tres capas:**  
  Separación clara entre Presentación (MVC/Thymeleaf), Lógica de Negocio (Servicios) y Datos (Repositorios/JPA).
- **Cumplimiento de requisitos educativos:**  
  No implementa integración real con el Ministerio de Hacienda, ATV o Catálogo CABYS, pero puede ser extendido para producción.

---

## Estructura del proyecto

```
FacturacionWEB/
├── src/
│   ├── main/java/com/example/facturacion/
│   │   ├── data/        # Repositorios JPA (Usuarios, Proveedores, Clientes, Productos, Facturas, Detalles)
│   │   ├── logic/       # Lógica de negocio (Service, entidades)
│   │   └── ...          # Controladores y vistas (MVC)
│   └── resources/
│       └── templates/   # Vistas Thymeleaf
└── README.md
```

---

## Principales entidades y flujo

- **Usuario:**  
  Maneja autenticación y control de acceso.
- **Proveedor:**  
  Relacionado con usuario, gestiona clientes, productos y facturas.
- **Cliente:**  
  Asociado a un proveedor, destinatario de facturas.
- **Producto:**  
  Bien o servicio registrado por el proveedor.
- **Factura y Detalle:**  
  Representan la facturación electrónica y sus componentes.

---

## Instalación y ejecución

1. **Clona el repositorio:**
   ```bash
   git clone https://github.com/JordanJazz24/FacturacionWEB.git
   cd FacturacionWEB
   ```
2. **Configura la base de datos MySQL** en `application.properties`.
3. **Construye el proyecto:**
   ```bash
   ./mvnw clean install
   ```
4. **Ejecuta la aplicación:**
   ```bash
   ./mvnw spring-boot:run
   ```
   Accede a la aplicación en `http://localhost:8080/`.

---

## Consideraciones y exclusiones

- No se conecta al sistema real del Ministerio de Hacienda.
- No implementa registro en ATV ni el uso del Catálogo CABYS.
- Renderizado únicamente del lado del servidor (no se permite JavaScript).
- Arquitectura de tres capas y patrón MVC obligatorio.

---

## Contacto

Para sugerencias o soporte, contacta a [JordanJazz24](https://github.com/JordanJazz24).

---

**Este proyecto demuestra un enfoque robusto en arquitectura MVC, buenas prácticas en Java/Spring Boot y una base sólida para aplicaciones empresariales de facturación electrónica en Costa Rica.**
