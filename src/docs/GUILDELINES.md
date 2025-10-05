# GUIDELINES
### Description
Application follows a feature‑wise architecture where a feature represents a logical unit of the domain.

A Feature (Hardware, Computer, Peripheral, Keyboard, Mouse, Screen, Provider, Marque, Cpu, Memory, HardDrive, Purchase) contains:
- FeatureEntity (JPA)
- FeatureRepository (Spring Data)
- FeatureDao (Kotlin data models + mappers)
- FeatureService (business logic)
- FeatureSpecifications (optional; JPA Criteria/Example)

Note: When a feature is a logical child of another (e.g., Keyboard/Mouse/Screen -> Peripheral; Cpu/Memory/HardDrive -> Computer), group them under the same package.

## DAOs (FeatureDao)
Each Feature defines three models:
- FeatureRequest: input for create
- FeatureUpdate: input for update/patch (nullable fields)
- FeatureResponse: output to controllers

Mapping rules (extension functions):
- Repository returns Entity -> Service maps to Response -> Controller returns Response
- Controller receives Request/Update -> Service maps to Entity (create/update) -> Repository persists

Naming:
- <Feature>Request, <Feature>Update, <Feature>Response
- Mapper file: <Feature>Dao.kt with extension fns:
  - <Feature>Request.toEntity(...)
  - <Entity>.to<Feature>Response()
  - applyUpdate(update: <Feature>Update)

Nullability in Update models means “do not change” (patch semantics).

## Services
- Constructor‑injected dependencies: repositories and other services.
- Public API returns Response models and accepts Request/Update models.
- Do not expose JPA entities outside the service boundary.
- Wrap write operations in @Transactional.
- Validate cross‑entity rules (existence, status compatibility).
- Throw NotFound or BadRequest for errors; the global handler translates them to API errors.

## Repositories
- Interface per Feature extending JpaRepository<Entity, UUID>.
- Custom queries when needed (method names or @Query).
- Specifications (optional) live under <feature>.spec and are reused by services.

## Package structure (example)
- com.acme.hms.feature.provider
- com.acme.hms.feature.marque
- com.acme.hms.feature.hardware
- com.acme.hms.feature.computer (cpu, memory, drive subpackages optional)
- com.acme.hms.feature.peripheral (keyboard, mouse, screen subpackages)
- com.acme.hms.feature.purchase
- com.acme.hms.shared (errors, enums, pagination, utilities)

## Minimal DAO + Service contracts (apply similarly to all features)

Provider
- ProviderRequest(name, email?, phoneNumber?, businessNumber?, imageUrl?)
- ProviderUpdate(name?, email?, phoneNumber?, businessNumber?, imageUrl?)
- ProviderResponse(id, name, email?, phoneNumber?, businessNumber?, imageUrl?)
- Mappers:
  - fun ProviderRequest.toEntity(): Provider
  - fun Provider.applyUpdate(u: ProviderUpdate)
  - fun Provider.toProviderResponse(): ProviderResponse
- Service:
  - create(req: ProviderRequest): ProviderResponse
  - update(id: UUID, u: ProviderUpdate): ProviderResponse
  - get(id: UUID): ProviderResponse
  - list(q: String?): List<ProviderResponse>
  - delete(id: UUID)

Marque
- MarqueRequest(label, businessNumber?, imageUrl?)
- MarqueUpdate(label?, businessNumber?, imageUrl?)
- MarqueResponse(id, label, businessNumber?, imageUrl?)
- Same mapper/service patterns as Provider.

Hardware
- HardwareRequest(marqueId, active, status, serialNumber, purchaseDate?, warrantyEndDate?, providerId?)
- HardwareUpdate(marqueId?, active?, status?, serialNumber?, purchaseDate?, warrantyEndDate?, providerId?)
- HardwareResponse(id, marqueId, active, status, serialNumber, purchaseDate?, warrantyEndDate?, providerId?)
- Service:
  - create, update, get, list(status?, marqueId?, providerId?), bySerial(serial), delete

Computer
- ComputerRequest(model, marqueId, serialNumber, chipsetMotherboard, active, type, working, yearBuyIn?, warrantyEndDate?)
- ComputerUpdate(… all nullable …)
- ComputerResponse(id, model, marqueId, serialNumber, chipsetMotherboard, active, type, working, yearBuyIn?, warrantyEndDate?)
- Attachment operations:
  - attachCpu(computerId, cpuId), detachCpu(computerId, cpuId)
  - attachMemory(computerId, memoryId), detachMemory(computerId, memoryId)
  - attachDrive(computerId, driveId), detachDrive(computerId, driveId)

Cpu
- CpuRequest(name, frequency, freqUnit, generation?, cacheSize?, numberCores?, socket?, marqueId?, imageUrl?)
- CpuUpdate(… nullable …)
- CpuResponse(id, name, frequency, freqUnit, generation?, cacheSize?, numberCores?, socket?, marqueId?, imageUrl?)
- Service: standard CRUD + search by marqueId.

Memory
- MemoryRequest(name, frequency, size, type, marqueId?, imageUrl?)
- MemoryUpdate(… nullable …)
- MemoryResponse(id, name, frequency, size, type, marqueId?, imageUrl?)
- Service: standard CRUD.

HardDrive
- HardDriveRequest(name, type, size, sizeUnit, isSsd, marqueId?, imageUrl?)
- HardDriveUpdate(… nullable …)
- HardDriveResponse(id, name, type, size, sizeUnit, isSsd, marqueId?, imageUrl?)
- Service: standard CRUD.

Peripheral (base)
- PeripheralRequest(label, connectivityType, type, marqueId?)
- PeripheralUpdate(label?, connectivityType?, type?, marqueId?)
- PeripheralResponse(id, label, connectivityType, type, marqueId?)
- Service: create, update, get, list(type?), delete

Keyboard
- KeyboardRequest(peripheralId, layout, switchType, backLight)
- KeyboardUpdate(layout?, switchType?, backLight?)
- KeyboardResponse(id, peripheralId, layout, switchType, backLight)
- Service: create/update/get/delete for subtype; ensures peripheral.type == KEYBOARD.

Mouse
- MouseRequest(peripheralId, dpi?, buttonCount, isWireless)
- MouseUpdate(dpi?, buttonCount?, isWireless?)
- MouseResponse(id, peripheralId, dpi?, buttonCount, isWireless)
- Service: create/update/get/delete for subtype; ensures peripheral.type == MOUSE.

Screen
- ScreenRequest(peripheralId, screenSizeInches, resolution, refreshRate?, aspectRatio?, ports)
- ScreenUpdate(screenSizeInches?, resolution?, refreshRate?, aspectRatio?, ports?)
- ScreenResponse(id, peripheralId, screenSizeInches, resolution, refreshRate?, aspectRatio?, ports)
- Service: create/update/get/delete for subtype; ensures peripheral.type == SCREEN.

Purchase
- PurchaseRequest(providerId, hardwareId, buyingDate, price, quantity)
- PurchaseUpdate(providerId?, hardwareId?, buyingDate?, price?, quantity?)
- PurchaseResponse(id, providerId, hardwareId, buyingDate, price, quantity)
- Service: create/update/get/list(by providerId?, hardwareId?), delete

## Example mapper pattern (apply to every feature)
- fun HardwareRequest.toEntity(marque: Marque, provider: Provider?): Hardware
- fun Hardware.applyUpdate(u: HardwareUpdate, marque: Marque?, provider: Provider?)
- fun Hardware.toHardwareResponse(): HardwareResponse

## Service implementation pattern
- Validate IDs by loading referenced entities (use repositories).
- Map Request to Entity; save; map Entity to Response.
- For updates: load entity, applyUpdate(update, refs…), save, return Response.
- For deletes: check existence; handle child constraints as required.
- Use transactions on write methods:
  - @Transactional for create/update/delete
  - readOnly = true for read methods

## Specifications (optional)
- Place under feature.spec; expose functions that build Specification<Entity> for common filters (e.g., Hardware by status, date range, marque/provider).
- Services compose specifications when listing.

## Error handling
- Throw NotFound(entity, id) when entity missing.
- Throw BadRequest(reason) for invalid states.
- Rely on the global exception handler to format JSON errors.

## Testing expectations
- For each feature service:
  - Unit tests for mappers.
  - @DataJpaTest for repository queries.
  - @SpringBootTest/@WebMvcTest for endpoint contracts where needed.

## Performance & consistency
- Keep fetch LAZY by default; design response shapes to avoid N+1 (batch fetch or DTO projections if needed).
- For lists, add pagination (Pageable) when datasets grow.
- All dates use ISO-8601; money uses BigDecimal.

## Checklist when adding a new Feature
1) Create Entity + Repository.
2) Create DAO models (Request, Update, Response).
3) Add mapper extensions in <Feature>Dao.kt.
4) Implement <Feature>Service with transactional boundaries.
5) Wire controller endpoints using only DAO models.
6) Add tests and sample requests. 