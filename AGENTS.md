## Cursor Cloud specific instructions

### Project overview

Java 8 Maven multi-module project with two modules:
- **demo_code**: Standalone Java files (LeetCode, algorithms, threading demos)
- **demo_spring**: Spring Boot 2.7.12 web application on port 8019

### Prerequisites

- JDK 8 (`openjdk-8-jdk`), set as default via `update-alternatives`
- Maven 3.x (`apt install maven`)
- `JAVA_HOME` must be `/usr/lib/jvm/java-8-openjdk-amd64`

### Build & Run

- Build: `mvn clean install -DskipTests` (from repo root)
- Run Spring Boot app: `cd demo_spring && mvn spring-boot:run` (starts on port 8019)
- Run tests: `mvn test` (no test classes exist currently)

### Working endpoints

- `GET /log/test/{name}/{age}` — returns formatted string, no auth needed
- `GET /aop/logging` — requires cookie `user_token=123456789` (AOP auth check)
- `GET /animal/get?type=cat` or `?type=dog` — strategy pattern demo (returns 500 due to pre-existing AOP aspect intercepting all controllers)

### Gotchas

- The `HttpAopAdviseDefine` aspect intercepts `@AuthChecker`-annotated endpoints and throws NPE when no cookies are present. Pass `--cookie "user_token=123456789"` for `/aop/logging`.
- Elasticsearch config in `application.yml` points to unreachable internal IPs (`10.58.11.x`). The app still starts, but ES-related features will not work.
- The `demo_code` module has a `spring-boot-maven-plugin` in its POM but is not a Spring Boot app; this is harmless.
