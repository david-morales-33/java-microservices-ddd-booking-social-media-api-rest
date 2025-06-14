# 🧱 Java Microservices DDD - Booking Social Media API REST

[![Java](https://img.shields.io/badge/Java-17-blue.svg)](https://www.oracle.com/java/)
[![Maven](https://img.shields.io/badge/Maven-3.9-blue.svg)](https://maven.apache.org/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

>Esta es una API REST para una red social que permite a los clientes reservar citas con tatuadores o peluqueros. Desarrollada con java (Spring Boot), arquitectura de microservicios y Domain-Driven Design (DDD).
---
## 🧭 Tabla de Contenidos

- [🧱 Java Microservices DDD - Projects Manager API REST](#-java-microservices-ddd---projects-manager-api-rest)
  - [🧭 Tabla de Contenidos](#-tabla-de-contenidos)
  - [🚀 Características principales](#-características-principales)
  - [📁 Estructura del proyecto](#-estructura-del-proyecto)
  - [⚙️ Tecnologías utilizadas](#️-tecnologías-utilizadas)
  - [📦 Instalación](#-instalación)
  - [🔧 Configuración](#-configuración)
  - [▶️ Uso](#️-uso)
  - [🧪 Pruebas](#-pruebas)
  - [📄 Licencia](#-licencia)
  - [🤝 Contribuciones](#-contribuciones)
  - [👨‍💻 Autor](#-autor)

---

## 🚀 Características principales

🌟 **¿Qué es la arquitectura hexagonal?**
También llamada "Ports and Adapters", la arquitectura hexagonal busca aislar el núcleo de negocio (la lógica pura de tu aplicación) del resto del sistema, como bases de datos, servicios externos o interfaces de usuario.

Hexágono (el núcleo): contiene la lógica del dominio, es decir, el "qué hace" tu sistema.

Puertos (Ports): son interfaces que definen cómo puede interactuar el núcleo con el exterior.

Adaptadores (Adapters): son implementaciones concretas de esos puertos (por ejemplo, un repositorio con TypeORM, un controlador de Express, etc).

🧠 **¿Y cómo encaja DDD aquí?**
Domain-Driven Design (DDD) es una forma de diseñar software que pone énfasis en el modelo del dominio, es decir, en representar correctamente las reglas del negocio con clases, entidades, agregados, etc.
En una arquitectura hexagonal orientada a DDD:

El dominio (con sus entidades, agregados, value objects, etc.) está al centro del hexágono.

El caso de uso (application layer) orquesta las acciones del dominio.

Todo lo externo (UI, base de datos, APIs externas) se conecta al núcleo a través de puertos y adaptadores.

🔄  **Relación entre DDD y microservicios**
DDD te ayuda a diseñar buenos microservicios, porque:

Cada Bounded Context puede convertirse en un microservicio independiente.

El DDD te fuerza a entender los límites del dominio, lo cual es clave al dividir sistemas.

Al tener contratos claros (puertos) y comunicaciones definidas, podés exponer esos puertos como APIs o eventos en una arquitectura distribuida.

👉 Los microservicios no son DDD, pero DDD es una excelente guía para diseñarlos.

🎯 Para este proyecto tenemos las siguientes características:

- 🧩 Separación por módulos y contextos delimitados (Bounded Contexts)
- 📐 Arquitectura hexagonal y orientación a DDD
- 🛠️ Clean Architecture para cada microservicio
- 🌐 API REST lista para producción
- 🔐 Seguridad integrada (preparado para JWT / OAuth2)
- 🧪 Testing modular por contexto
- 🐳 Integración con Docker y Docker Compose

