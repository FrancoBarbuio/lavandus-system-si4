# LAVANDUS S.A. — Sistema Integral de Lavado Industrial y Mantenimiento

<p align="center">
  <img src="https://img.shields.io/github/actions/workflow/status/FrancoBarbuio/lavandus-system-si4/ci-cd.yml?branch=main&style=for-the-badge&logo=github-actions&logoColor=white&label=CI%2FCD%20Pipeline" alt="CI/CD Status" />
  <img src="https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java 17" />
  <img src="https://img.shields.io/badge/Spring_Boot-3.2.3-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white" alt="Spring Boot" />
  <img src="https://img.shields.io/badge/Jira-Atlassian-0052CC?style=for-the-badge&logo=jira&logoColor=white" alt="Jira" />
  <img src="https://img.shields.io/badge/Zephyr_Scale-100%25_Passed-36B37E?style=for-the-badge&logo=smartbear&logoColor=white" alt="Zephyr Scale" />
  <img src="https://img.shields.io/badge/ISSD-Sistemas_de_Información_4-00375c?style=for-the-badge" alt="ISSD SI4" />
</p>

---

## 📌 Información Académica e Institucional

* **Institución:** Instituto Superior Santo Domingo (ISSD)
* **Carrera:** Tecnicatura Superior en Análisis de Sistemas
* **Cátedra:** Sistemas de Información 4
* **Docente Titular:** Lic. Roger Martínez
* **Estudiante:** Franco Ariel Barbuio
* **Ciclo Lectivo:** Noviembre 2026

---

## 📖 Descripción del Proyecto

**LAVANDUS S.A.** es un sistema de información diseñado para gestionar el flujo operativo integral de lavado industrial a gran escala para clientes corporativos (cadenas hoteleras, sanatorios y complejos fabriles). 

El sistema cubre la recepción multicanal de solicitudes de servicio, programación logística de retiros y entregas, trazabilidad en planta por etapas operativas (pesaje, lavado, centrifugado/secado, planchado y embalaje), emisión automática de factura electrónica y control del ciclo de vida y mantenimiento del parque de maquinarias industriales.

---

## 🛠️ Tecnologías y Ecosistema de Trabajo

* **Backend:** Java 17, Spring Boot 3.2.3 (Spring Web, Maven).
* **Frontend:** Single Page Application embebida en Spring Boot (`src/main/resources/static/index.html`), HTML5 semántico, CSS3 corporativo y Vanilla JavaScript.
* **Pruebas:** JUnit 5 (Pruebas unitarias de caja blanca) y Zephyr Scale para Jira (Pruebas de caja negra y BDD Gherkin).
* **Integración y Entrega Continua (CI/CD):** GitHub Actions (`ci-cd.yml`).
* **Gestión de Proyecto:** Scrum Framework gestionado en Jira Software & Confluence (Atlassian).

---

## 🔄 Trazabilidad Ágil (Scrum & GitHub for Jira)

El repositorio se encuentra formalmente vinculado al proyecto **LAV** en Jira. Toda rama, commit y Pull Request mantiene correspondencia biunívoca con las Historias de Usuario aprobadas en el Sprint:

* **Épica Core:** `EP-01: Gestión Transaccional de Solicitudes y Lavado (CORE)`
* **Historia Implementada:** `LAV-6: Registro Web de Solicitud de Lavado Industrial` (5 Story Points - Must Have)
* **Rama de Trabajo:** `feature/LAV-6-registro-solicitud`
* **Workflow CI/CD:** Compilación y ejecución de pruebas automatizadas en cada `push` y `pull_request`.

---

## 🧪 Estrategia de Calidad y Pruebas (Zephyr Scale)

Se ejecutaron y documentaron los siguientes casos de prueba formales vinculados a los criterios de aceptación en formato BDD Gherkin:

| Identificador | Historia Asociada | Descripción de la Prueba | Tipo | Resultado |
| :--- | :--- | :--- | :--- | :---: |
| **`TC-LAV-01`** | `LAV-6` | Validación de solicitud web corporativa (Camino Feliz $\ge$ 50 kg y Camino Fallido por volumen insuficiente) | Caja Negra / Funcional | **PASS** ✅ |
| **`TC-LAV-02`** | `LAV-8` | Control de transición de etapas en planta y cómputo de horas operativas en maquinaria | Transición de Estados | **PASS** ✅ |

---

## 🚀 Instalación y Ejecución Local

### Prerrequisitos
* Java Development Kit (JDK) 17 o superior instalado.
* Git instalado en el sistema.

### Pasos para levantar el proyecto

1. **Clonar el repositorio:**
   ```bash
   git clone https://github.com/FrancoBarbuio/lavandus-system-si4.git
   cd lavandus-system-si4
   ```

2. **Compilar y ejecutar pruebas unitarias:**
   * En Windows:
     ```powershell
     .\mvnw.cmd clean test
     ```
   * En Linux / macOS:
     ```bash
     ./mvnw clean test
     ```

3. **Iniciar el servidor:**
   * En Windows:
     ```powershell
     .\mvnw.cmd spring-boot:run
     ```
   * En Linux / macOS:
     ```bash
     ./mvnw spring-boot:run
     ```

4. **Acceder a la interfaz:**
   Abre tu navegador web e ingresa a:
   ```text
   http://localhost:8080
   ```

---

## 🔑 Credenciales Demo de Acceso

| Rol de Usuario | Correo Electrónico | Contraseña | Perfil y Acceso |
| :--- | :--- | :--- | :--- |
| **Gerente de Operaciones** | `admin@lavandus.com` | `Admin123*` | Control total, avance de etapas y trazabilidad |
| **Cliente Corporativo** | `cliente@hospital.com` | `Cliente123*` | Portal de solicitud y consulta de estado |

---

## 📂 Estructura del Repositorio

```text
lavandus-system-si4/
├── .github/
│   └── workflows/
│       └── ci-cd.yml            # Pipeline automatizado de CI/CD
├── pom.xml                      # Configuración de dependencias Maven
└── src/
    ├── main/
    │   ├── java/com/lavandus/app/
    │   │   ├── LavandusApplication.java      # Entrada principal Spring Boot
    │   │   ├── controller/LavandusController.java # Endpoints REST y Auth
    │   │   ├── model/SolicitudServicio.java   # Modelo de dominio de la transacción
    │   │   └── service/LavandusService.java   # Reglas de negocio y estados
    │   └── resources/
    │       ├── application.properties
    │       └── static/
    │           └── index.html                 # Interfaz gráfica interactiva SPA
    └── test/
        └── java/com/lavandus/app/
            └── LavandusServiceTest.java       # Pruebas unitarias automatizadas (JUnit 5)
```

---

<p align="center">
  Trabajo Práctico Integrador — Sistemas de Información 4 — ISSD Córdoba
</p>
