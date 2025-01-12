## 프로젝트 소개

**Smart** (Spring Modular Architecture Research Team)

### 주제

- **Modular Monolithic** 아키텍처를 이해하고 **Spring Modulith**를 적용하여 실제로 설계 및 구현한다.

---

### 팀 소개

<br/>

#### 핀테크팀(페이먼츠 플랫폼)
<table align="center">
    <th align="center">차윤범</th>
    <th align="center">김재영</th>
    <th align="center">문준용</th>
    <th align="center">조상준</th>
    <th align="center">최윤한</th>
    <tr>
        <td align="center">
            <a href="https://github.com/char-yb"><img src="https://github.com/char-yb.png" width="250"/></a>
        </td>
        <td align="center">
            <a href="https://github.com/jaeyeong951"><img src="https://github.com/jaeyeong951.png" width="250"/></a>
        </td>
        <td align="center">
            <a href="https://github.com/devfancy"><img src="https://github.com/devfancy.png" width="250"/></a>
        </td>
        <td align="center">
            <a href="https://github.com/sangjun121"><img src="https://github.com/sangjun121.png" width="250"/></a>
        </td>
        <td align="center">
            <a href="https://github.com/unanchoi"><img src="https://github.com/unanchoi.png" width="250"/></a>
        </td>
    </tr>
</table>

#### 커머스팀

- **커머스팀** 레포지토리가 궁금하다면 [여기](https://github.com/sipe-team/3-2_smart_commerce)를 클릭하세요!

<table align="center">
    <th align="center">김우재</th>
    <th align="center">김희동</th>
    <th align="center">허정화</th>
    <th align="center">서영학</th>
    <th align="center">장준환</th>
    <th align="center">유지예</th>
    <tr>
        <td align="center">
            <a href="https://github.com/kwj1270"><img src="https://github.com/kwj1270.png" width="250"/></a>
        </td>
        <td align="center">
            <a href="https://github.com/ruthetum"><img src="https://github.com/ruthetum.png" width="250"/></a>
        </td>
        <td align="center">
            <a href="https://github.com/hoa0217"><img src="https://github.com/hoa0217.png" width="250"/></a>
        </td>
        <td align="center">
            <a href="https://github.com/inspire12"><img src="https://github.com/inspire12.png" width="250"/></a>
        </td>
        <td align="center">
            <a href="https://github.com/itschrisjang"><img src="https://github.com/itschrisjang.png" width="250"/></a>
        </td>
        <td align="center">
            <a href="https://github.com/yujiyea"><img src="https://github.com/yujiyea.png" width="250"/></a>
        </td>
    </tr>
</table>

---

### 목표

- 모듈러 모놀리스(Modular Monolith) 아키텍처의 기본 원리 이해
- Spring Modulith를 활용한 모듈화된 애플리케이션 설계 및 구현
- 공통 관심사의 분리와 모듈 간 의존성 효과적인 관리
- 기존 모놀리스와 MSA의 차이점 및 장단점 분석
- 모듈 간 리소스 격리와 장애 격리 또는 대체 방안 탐구

---

### 주차별 학습 내용

#### 0주차: 개념 학습 및 요구사항 논의

- 모듈러 모놀리스와 스프링 모듈리스의 기본 개념 학습
- 도메인별 팀 구성 및 요구사항 설계
    - **커머스팀**과 **핀테크팀**으로 구분

#### 1~3주차: Spring Modulith 학습 및 설계

- Monolithic Architecture와 MSA의 Trade-Off 분석
- Modular Monolith Architecture의 기본 구조와 개념 학습
- Spring Modulith의 주요 기능 학습
    - **[Spring Modulith 공식 문서](https://docs.spring.io/spring-modulith/reference/fundamentals.html)**
- 각 팀원의 모듈 설계 진행 및 의존성 검증

#### 4~5주차: 기능 구현

- 유스케이스를 기반으로 모듈별 요구사항에 맞는 기능 구현
    - **계좌, 지갑**: 상준
    - **결제**: 준용
    - **송금**: 재영, 윤한, 윤범

#### 6주차: 발표 및 회고

- 학습 배경, 목적, 결과를 중심으로 발표 자료(PPT) 제작
- 6주간의 스터디에 대한 회고와 개선점 논의

---

### 이후 계획

#### 모니터링 및 장애 내결함성 테스트

- 각 모듈 통합 테스트 및 검증
- 모듈 단위별 부하 테스트 수행 및 성능 분석
- 장애 전파 여부 측정 및 장애 내결함성 검증

#### 장애 격리 및 코드 개선

- 기존 모놀리스와 비교: 코드 복잡성, 테스트 용이성, 성능 분석
- 모듈 설계와 구현에 대한 피드백 및 개선

---

### Convention

#### Branch 이름 규칙

- 기능 단위로 Branch 생성
    - **신규 기능 개발**: `feature/{github-name}-{title}`
    - **기존 기능 개선**: `refactor/{github-name}-{title}`
    - **버그 수정 (develop)**: `fix/{github-name}-{title}`
    - **버그 수정 (main)**: `hotfix/{github-name}-{title}`
    - **문서 추가/수정**: `docs/{github-name}-{title}`

#### Git Branch 전략

| 브랜치 유형 | 설명                                      |
|-------------|-------------------------------------------|
| main        | 운영 브랜치, 완료된 기능을 메인 서버에 merge |
| develop     | 개발 브랜치, 개발된 기능을 테스팅 서버에 merge |
| feature     | 새로운 기능 개발 브랜치 생성                |
| fix         | 버그 수정 브랜치 생성                     |
| hotfix      | 운영 중 긴급 버그 수정 브랜치 생성           |

---

#### Commit 메시지 규칙

- 각 작업 단위로 하나의 Commit 작성
- **메시지 형식**: `{유형}: {작업 내용}`

| 작업 유형  | 작업 내용                     |
|------------|------------------------------|
| feat       | 신규 기능 개발                  |
| refactor   | 기존 기능 개선 및 코드 리팩토링   |
| fix        | 버그 수정                      |
| docs       | 문서 추가, 수정, 삭제 관련 작업    |
| chore      | 환경 설정, 빌드 관련 작업 등       |

---

### Reference

- **[Spring Modulith 공식 문서](https://docs.spring.io/spring-modulith/reference/fundamentals.html)**
- **[Spring Modulith GitHub](https://github.com/spring-projects/spring-modulith)**
- **[Spring Tips: Spring Modulith (영상)](https://www.youtube.com/watch?v=MYEx0kO2-8A&ab_channel=SpringDeveloper)**
- **[Modular Monoliths with Spring Modulith (블로그)](https://medium.com/@selcuk.sert/modular-monoliths-with-spring-modulith-96361f3167c9)**
- **[Modular Monolithic Architecture와 Spring Modulith (블로그)](https://monday9pm.com/modular-architecture%EC%99%80-spring-modulith-43b6709b2937)**

---
