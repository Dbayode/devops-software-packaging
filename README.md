# Software Packaging in Popular Frameworks

This project demonstrates software packaging, dependency management, semantic versioning, and environment decoupling across Node.js, Python (Django), and Java (Spring Boot).

## 1. Semantic Versioning Strategy (SemVer)
All three services implement **SemVer 2.0.0** (`MAJOR.MINOR.PATCH`):
- Current Base Release: `1.0.0`
- **PATCH**: Incremented for backwards-compatible bug fixes.
- **MINOR**: Incremented for backwards-compatible features (e.g., adding a new metrics endpoint).
- **MAJOR**: Incremented when breaking API changes are introduced.

## 2. Packaging Commands and Artifacts

| Ecosystem | Manifest | Lock Mechanism | Distributable Artifact | Build / Package Command |
| :--- | :--- | :--- | :--- | :--- |
| **Node.js** | `package.json` | `package-lock.json` | `dist/node-app-v1.0.0.tar.gz` | `npm run package` |
| **Python** | `pyproject.toml` | `requirements.lock` | `dist/*.whl` & `dist/*.tar.gz` | `python -m build` |
| **Java** | `pom.xml` | Maven Dependency Tree | `target/springboot-service-1.0.0.jar` | `mvn clean package` |

## 3. Environment Separation
Configuration is decoupled from application code following Twelve-Factor App principles:
- **Node.js**: Driven via `PORT` and `NODE_ENV` environment variables.
- **Django**: Driven via `PORT`, `DEBUG`, and `APP_ENV` environment variables using `python-dotenv`.
- **Spring Boot**: Externalized using property place-holders in `application.properties` mapped to JVM args (`-Dserver.port`, `-Dapp.env`).

## 4. Security Audit Summary
- **Node.js**: Scanned with `npm audit`. 0 vulnerabilities detected.
- **Python**: Scanned with `pip-audit -r requirements.lock`. 0 vulnerabilities detected.
- **Java**: Audited using `mvn dependency:tree` to review direct and transitive dependencies.

## 5. Verification Proofs
Screenshots demonstrating active execution across Development and Staging ports are located in `/screenshots`.
