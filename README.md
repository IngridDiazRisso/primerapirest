# API REST para Gestión de Productos

Esta es una **API RESTful de producción** desarrollada en Java utilizando **Spring Boot**, diseñada específicamente para la gestión, control y persistencia de un catálogo de productos.

El proyecto cuenta con una arquitectura híbrida profesional que le permite ejecutarse de forma local y sincronizarse automáticamente con una base de datos en la nube.

---

## URL del Proyecto en Producción
Puedes probar la API en vivo e interactuar con el catálogo real a través del siguiente enlace:
**[https://primerapirest-production.up.railway.app/productos](https://primerapirest-production.up.railway.app/productos)**

---

## Tecnologías y Herramientas Utilizadas

*   **Backend:** Java 23 & Spring Boot 
*   **Persistencia (ORM):** Spring Data JPA & Hibernate 
*   **Bases de Datos:** PostgreSQL 
*   **Contenedores:** Docker & Docker Desktop (Infraestructura Local) 
*   **Control de Versiones:** Git & GitHub Desktop 
*   **Despliegue en la Nube:** Railway 
*   **Pruebas de Software:** Postman (Simulación de Clientes) 

---

## Arquitectura y Capas del Proyecto

El backend sigue el patrón arquitectónico por capas estándar de la industria (**MVC**):

1.  **Controller (`ProductoController`):** Expone los endpoints de la API, gestiona las peticiones HTTP e implementa `ResponseEntity` para manejar los códigos de estado. 
2.  **Repository (`ProductoRepository`):** Interfaz que extiende de `JpaRepository` para la comunicación directa con la base de datos relacional.
4.  **Model / Entity (`Producto`):** Clase que define la estructura del producto (`id`, `nombre`, `precio`) mapeada de forma automática en las tablas del servidor.

---

## Características Técnicas Destacadas

*   **Puerto Híbrido Inteligente:** Uso de la propiedad `server.port=${PORT:8082}` en el `application.properties`. Esto permite a la aplicación abrirse en la puerta segura `8082` en local y adaptarse de manera dinámica al puerto aleatorio que le asigne Railway en internet.
*   **Seguridad de Credenciales:** Aislamiento de contraseñas de la base de datos mediante un archivo externo `.env` protegido con `.gitignore` para evitar filtraciones de seguridad en el repositorio público.
*   **Despliegue Continuo (CI/CD):** Sincronización nativa con Railway. Cada cambio subido a la rama principal de GitHub recompila la aplicación de forma automática en la nube.

---

## Endpoints de la API

| Método HTTP | Endpoint | Descripción | Estado HTTP |
| :--- | :--- | :--- | :--- |
| **`GET`** | `/productos` | Recupera el listado completo de productos en formato JSON. | `200 OK` |
| **`POST`** | `/productos` | Registra un nuevo producto enviando el cuerpo en formato JSON. | `201 Created` |
| **`PUT`** | `/productos/{id}` | Modifica las propiedades de un producto existente buscando por su ID. | `200 OK` |
| **`DELETE`**| `/productos/{id}` | Elimina de forma física el registro de la base de datos. | `204 No Content` |
