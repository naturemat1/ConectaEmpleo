# ConectaEmpleo

## Descripción

ConectaEmpleo es una plataforma web desarrollada con Spring Boot que conecta a empleadores y buscadores de empleo, facilitando la publicación de ofertas laborales, postulaciones, capacitaciones y contratos. Este proyecto busca contribuir al Objetivo de Desarrollo Sostenible (ODS) 1: Fin de la Pobreza, al promover el acceso al empleo y mejorar las oportunidades laborales.

Desarrollado por Mateo Cobo.

## Tecnologías Utilizadas

- **Backend**: Java 17, Spring Boot 3.5.3 (Spring Web, Spring Data JPA)
- **Frontend**: Thymeleaf (templates HTML), CSS
- **Base de Datos**: PostgreSQL
- **Build Tool**: Maven
- **ORM**: Hibernate
- **Testing**: JUnit (Spring Boot Starter Test)

## Funcionalidades Principales

- **Gestión de Usuarios**: Registro, login, perfiles de usuario con roles (empleador/buscador).
- **Publicación de Trabajos**: Creación y listado de ofertas laborales con filtros por categoría y ubicación.
- **Postulaciones**: Aplicación a trabajos, gestión de estados de postulaciones.
- **Capacitaciones**: Publicación y participación en cursos de capacitación para mejorar empleabilidad.
- **Contratos**: Gestión de contratos laborales.
- **Reportes**: Generación de reportes sobre estadísticas del sistema.
- **Calificaciones**: Sistema de calificaciones para trabajos finalizados.
- **Notificaciones**: (Basado en modelos, posiblemente futuras implementaciones).

## Solución

ConectaEmpleo aborda el ODS 1 al proporcionar una herramienta digital que reduce barreras en el acceso al empleo. Facilita la conexión directa entre demandantes y oferentes de trabajo, incluye módulos de capacitación para potenciar habilidades, y genera datos para reportes que pueden informar políticas públicas contra la pobreza.

## Actualizaciones Futuras

- Implementación de notificaciones en tiempo real.
- Búsqueda avanzada con algoritmos de matching.
- Versión móvil de la aplicación.
- Integración con APIs externas para verificación de credenciales.
- Mejoras en la interfaz de usuario con frameworks modernos como React.
- Análisis de datos con machine learning para predicciones de empleabilidad.

## Instalación y Configuración

### Prerrequisitos

- Java 17
- Maven
- PostgreSQL

### Pasos

1. Clona el repositorio:
   ```
   git clone <url-del-repo>
   cd ConectaEmpleo
   ```

2. Configura la base de datos en `src/main/resources/application.properties`:
   - Asegúrate de tener PostgreSQL corriendo en localhost:5432
   - Base de datos: db_conecta_empleo
   - Usuario: postgres
   - Contraseña: admin

3. Ejecuta la aplicación:
   ```
   mvn spring-boot:run
   ```

4. Accede a http://localhost:8080

### Tests

Ejecuta los tests con:
```
mvn test
```

## Contribución

Para contribuir, crea un fork del proyecto, realiza tus cambios en una rama y envía un pull request.