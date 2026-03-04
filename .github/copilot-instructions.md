# Copilot instructions for hardwaremanagementsystem

## Big picture
- Stack: Kotlin + Spring Boot 3.5 + Spring Data JPA + PostgreSQL + Spring Security + springdoc OpenAPI (see `build.gradle`).
- Domain is feature-first under `src/main/kotlin/.../hardwaremanagementsystem/`: `marque`, `provider`, `hardware`, `computer`, `peripheral`.
- `HardwareEntity` is the base persisted table (`hardware`) with SINGLE_TABLE inheritance; `ComputerEntity` and `PeripheralEntity` extend it, and keyboard/mouse/screen extend peripheral.
- Component inventory (`cpu`, `memory`, `hard_drive`) is separate from hardware and linked to computers through relationship tables (`computer_cpus`, `computer_memories`, `computer_drives`).

## Request/data flow patterns to preserve
- Controller -> Service -> Repository flow is strict; controllers work with DTOs, services handle mapping and lookup validation.
- DTO + mapper extension functions live in `<Feature>DtoMapper.kt` (example: `provider/ProviderDtoMapper.kt`, `computer/ComputerDtoMapper.kt`).
- Services are transaction-scoped (`@Transactional`), with `readOnly = true` for reads.
- Missing references are handled by `orElseThrow { RuntimeException("...") }` (no centralized `@ControllerAdvice` currently).

## IDs, models, and persistence conventions
- Most business entities inherit `_config/BaseEntity` and use UUID IDs.
- Lookup/datasource tables under `computer/computer_data/**` use `Long` IDs and their own DTOs/repositories.
- Null in update DTOs means “no change”, except several mappers intentionally clear optional relations when `providerId == null`.
- Prefer existing enum types in `_config/GlobalEnums.kt` (`ComputerType`, `HardwareStatus`, etc.) over string literals.

## Filtering subsystem (important)
- Generic attribute-count filtering is implemented in `_core/filter/FilterCountService.kt` using JPA Criteria API.
- `ComputerController` exposes `POST /api/v1/computers/filter/attributes-count` and passes metadata from `DefaultAttributesOfComputer` in `ComputerDtoMapper.kt`.
- Attribute metadata supports simple fields and one-level joins via `attributeCode` (e.g. `marque.label`); deeper nested joins are rejected.

## Startup/seed behavior
- App seeds marque defaults at startup via `_config/DBInitializer.kt`.
- App also seeds computer lookup datasets via `computer/computer_data/ComputerDataDefaultsInitializer.kt`.
- Keep startup seeders idempotent (`count() > 0` guards).

## Security and API docs
- `SecurityConfig` currently permits all routes (`requestMatchers("/**").permitAll()`), enables basic auth, and allows CORS `*`.
- Swagger UI path is `/swagger-ui.html` (configured in `src/main/resources/application.properties`).

## Developer workflow shortcuts
- Run app: `./gradlew bootRun`
- Run tests: `./gradlew test`
- Build artifact: `./gradlew build`
- Local DB: `docker compose up -d db`
- Note: datasource expects `management_solution_db` at localhost:5432; verify compose/env username alignment with `application.properties` before debugging DB errors.

## When adding/changing features
- Follow existing package-local structure: `Entity`, `Repository`, `Service`, `Controller`, `DtoMapper` in the same feature folder.
- Reuse existing URL style `/api/v1/<feature>` and pageable list endpoints (`@PageableDefault(size = 20)`).
- For new computer component links, add both single attach/detach and bulk endpoints in `computer/relationships`.
