# 태양광 발전 모니터링 시스템

이 프로젝트는 태양광 발전 모니터링 시스템을 위한 **테스트 버전**입니다. 현재 개발 중이므로, 본 버전은 참고용으로만 사용해 주시기 바랍니다. 본 소프트웨어의 사용 및 배포에 따른 책임은 사용자에게 있으며, 실제 환경에서 사용하기 전에 반드시 추가 테스트가 필요합니다.

---

## 프로젝트 개요

본 프로젝트는 태양광 발전 모니터링 시스템을 구축하고 실시간 데이터를 기반으로 발전량 및 배터리 충전 상태를 시각화하는 기능을 제공합니다. 또한, 발전량 및 배터리 충전량의 예측 데이터를 제공합니다.

## 주요 기능

- **실시간 데이터 모니터링**: 오늘의 발전량 및 배터리 충전 상태를 그래프로 시각화
- **예측 데이터**: 내일의 발전량 및 배터리 충전 상태 예측
- **로그 기록**: 시스템 로그 조회 기능
- **Spring Boot와 MySQL 연동**: 백엔드는 Spring Boot, 데이터베이스는 MySQL을 사용

## 설치 방법

### 1. 사전 요구 사항

- JDK 21 이상
- MySQL 데이터베이스
- Gradle 빌드 도구
- IntelliJ IDEA (권장)

### 2. 프로젝트 클론

```bash
git clone https://github.com/your-username/solar-monitoring-system.git
cd solar-monitoring-system
```

### 3. 데이터베이스 설정

MySQL에서 데이터베이스 및 사용자 설정을 완료합니다.

```sql
CREATE DATABASE SolarDB;
CREATE USER 'solar_user'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON SolarDB.* TO 'solar_user'@'localhost';
FLUSH PRIVILEGES;
```

### 4. 설정 파일 편집

`src/main/resources/application.properties` 파일을 열고, 다음과 같이 MySQL 정보가 올바른지 확인하세요.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/SolarDB
spring.datasource.username=solar_user
spring.datasource.password=password
server.port=8081
```

### 5. 애플리케이션 실행

```bash
./gradlew bootRun
```

브라우저에서 `http://localhost:8081`로 접속하여 애플리케이션에 접근할 수 있습니다.

## 파일 구조

- `src/main/java/com/example/solarsystem`: 백엔드 코드
- `src/main/resources/static`: 정적 리소스 (CSS, JavaScript)
- `src/main/resources/templates`: Thymeleaf 템플릿 (HTML)
- `src/main/resources/application.properties`: 애플리케이션 설정 파일

## 사용 방법

- **대시보드**: `http://localhost:8081/dashboard`에서 발전량 및 예측 데이터를 시각적으로 확인
- **로그 페이지**: `http://localhost:8081/logs`에서 로그 기록 확인

## 주의사항

이 프로젝트는 **테스트 버전**으로, 사용 시 주의가 필요합니다. 본 프로젝트는 현재 개발 중이며, 상업적 및 실제 환경에서의 사용을 권장하지 않습니다.

## 라이선스

이 프로젝트는 MIT 라이선스를 따릅니다. 사용 시 라이선스 내용을 참고하세요.

2024.11.03 확인된 문제
대시보드에서 예측량 데이터 표시 오류: 해결중
로그 페이지에서 로그 출력 오류: 해결중
