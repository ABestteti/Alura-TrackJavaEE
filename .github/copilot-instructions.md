# Copilot instructions for this repository

This repository is a collection of independent Java learning projects, not a single application. Treat each top-level project directory as its own build unit: `auron`, `cdi-jsf2-livraria-maven`, `livraria-spring`, `livraria-wildfly`, `lojaweb`, `produtos`, `projeto-jpa-2`, `financas`, `DataStructures`, and others are separate examples with different dependencies and runtime assumptions. There is no root-level Maven or Gradle build that spans the whole repo.

## Build, test, and lint commands

Run commands from the project you are editing, not from the repository root.

### Maven projects

Typical commands for a Maven project:

```bash
cd produtos && mvn test
cd produtos && mvn -q -Dtest=br.com.alura.maven.produtos.ProdutoTeste test
cd auron && mvn test
cd auron && mvn -q -Dtest=br.com.caelum.auron.modelo.SorteadorTest test
cd lojaweb && mvn package
cd cdi-jsf2-livraria-maven && mvn package
```

Maven projects in this repo commonly use `war` packaging for web apps and `jar` packaging for libraries. This is a legacy Java EE-era codebase, so Java 7/8 compiler settings are common and some modules target old app-server APIs.

### Gradle projects

Typical commands for a Gradle project:

```bash
cd DataStructures && ./gradlew test
cd DataStructures && ./gradlew test --tests "*LibraryTest"
cd financas && ./gradlew test
cd financas && ./gradlew test --tests "*LibraryTest"
```

If the wrapper is unavailable, use `gradle test` in the same project directory.

### Lint/static-analysis commands

The project that clearly defines static analysis is `produtos`:

```bash
cd produtos && mvn verify
```

That module binds the Maven PMD plugin to the `verify` phase and also enables JaCoCo coverage reporting. Other folders usually do not define a repo-wide lint step; compile/test/package commands are the normal validation path for those projects.

## High-level architecture

This repo is organized around small, standalone Java exercises and tutorials rather than a single product architecture:

- `src/main/java` is the application/business logic for each project.
- `src/test/java` contains JUnit tests for the project.
- Web projects usually package as WARs and depend on Java EE/Jakarta APIs, JSF, CDI, JPA, or Spring components.
- Common technologies across the repo include Java EE / JavaServer Faces (JSF), CDI, JPA/Hibernate, Servlets/JSP, PrimeFaces, Spring, and WildFly/JBoss deployment.
- Some projects are plain Java libraries or algorithms (`DataStructures`, `JavaUtil`, `bytebank-herdado-conta`, `financas`), while others are full web applications or persistence examples (`cdi-jsf2-livraria-maven`, `livraria-spring`, `livraria-wildfly`, `auron`, `lojaweb`).
- The repo mixes Maven and Gradle builds, and each project usually carries its own dependency management and runtime assumptions.

When making a change, identify the exact project folder first. Do not assume there is a top-level app or shared codebase across folders.

## Key conventions

- Keep changes scoped to the relevant project directory; there is no root aggregator or shared module build.
- Follow the existing package naming style (`br.com...`, `br.caelum...`, etc.) already used by the module you are editing.
- Most tests in this repo use JUnit 4 (`org.junit.Test`, `@Before`, `@Test(expected = ...)`), not JUnit 5.
- Legacy Java EE artifacts are common: `javax.*` APIs, older Hibernate versions, older Spring versions, and Java 7/8 source targets are normal in this repository.
- Web apps frequently rely on project-local config files such as `persistence.xml`, JSF config, or `WEB-INF` resources rather than modern Spring Boot conventions.
- Some projects include manually managed libraries under `src/main/lib` or use old repository URLs for PrimeFaces and related dependencies; prefer the style already used in that project instead of introducing a new framework stack.
- Use the module’s existing build tool and dependency versioning instead of standardizing all subprojects to a single modern setup.

## Working style for future Copilot sessions

- Start by locating the project that owns the task before editing.
- Prefer surgical edits inside the relevant module; avoid cross-project refactors unless a task explicitly spans multiple examples.
- If you need to validate behavior, use the smallest command that exercises the target project (one class or one module, not the whole repository).
- For web and persistence examples, check the module’s POM/Gradle file and existing package structure before adding new dependencies or framework conventions.
