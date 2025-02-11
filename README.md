## 프로젝트 소개

**Smart** (Spring Modular Architecture Research Team)

### 주제

- `Modular Monolithic` 아키텍처의 원리를 이해하고 이를 효과적으로 활용하기 위해 `Spring Modulith`를 중심으로 설계 및 구현한다.
- Payment 도메인을 예제로 사용하여 **`Spring Modulith`** 의 주요 기능과 모듈 설계를 심화 학습하고, 이를 기반으로 실제 애플리케이션을 구현한다.

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

### 심화 활동: 선택적으로 참여하기

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

- 주차별 단위로 Branch 생성
    - **1주차**: `week1/{github-name}-{title}`
    - **2주차**: `week2/{github-name}-{title}`
    - **3주차**: `week3/{github-name}-{title}`
    - **4주차**: `week4/{github-name}-{title}`
    - **5주차**: `week4/{github-name}-{title}`
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

## 프로젝트 회고

> 순서: `윤범` > `재영` > `준용` > `상준` > `윤한`

### 윤범

**📚 학습 내용**

- Spring Modulith를 활용한 모듈 간 느슨한 결합 및 이벤트 기반 아키텍처 학습
- 이벤트 스토밍을 통한 도메인 설계 방법 익힘

**🔍 미션을 통해 배운 점**

- Spring Modulith를 활용하면 트랜잭션 이벤트 유실을 방지할 수 있음
- 이벤트 스토밍을 통해 복잡한 도메인을 구조적으로 설계할 수 있음

**👍 좋았던 점**

- 새로운 기술(Spring Modulith)을 학습하며, 팀원들과 인사이트를 공유한 점
- 이벤트 스토밍을 통해 도메인 모델링의 중요성을 다시금 깨달음

**😞 아쉬운 점**

- 요구사항을 100% 충족하지 못한 점에 대한 아쉬움

**🚀 개선할 점**

- 2차 미션 이후에도 지속적인 개발을 통해 프로젝트 완성도를 높이기

### 재영

**📚 학습 내용**

- Modular Monolith와 Spring Modulith의 개념 및 차이점 학습
- 물리적 모듈 분리 vs 논리적 모듈 분리에 대한 이해
- 페이먼츠 도메인의 기본 개념 학습

**🔍 미션을 통해 배운 점**

- Spring Modulith가 제공하는 기능이 생각보다 유용하다는 점
- 프로젝트를 진행하면서, 별도 툴을 사용할 정도로 복잡한 구조인지에 대한 고민 발생
- 이벤트 스토밍의 중요성 재확인

**👍 좋았던 점**

- 대부분의 프로젝트가 어느 정도 Modular Monolith 형태를 갖고 있다는 점을 깨달음
- Spring Modulith를 적용하면 도메인 모듈 간 의존성을 효과적으로 관리할 수 있음

**😞 아쉬운 점**

- Spring Modulith 적용보다 도메인 이해도가 부족했던 점이 프로젝트 진행에 어려움을 줌
- 도메인 정의가 명확해진 후 코딩을 시작했지만, 미션 기간이 촉박했음

### 준용

**📚 학습 내용**

- 모듈러 모놀리스와 스프링 모듈리스 개념 학습
- Spring Modulith의 필요성과 장점 분석
- 핀테크 도메인을 활용한 프로젝트 개발 및 Kotlin 학습

**🔍 미션을 통해 배운 점**

- MSA 도입 전, Spring Modulith를 활용하면 초기 서비스 개발에 도움이 될 수 있음
- 도메인 지식 없이 Spring Modulith를 적용하는 것은 비효율적이라는 점 깨달음
- 도메인 설계 후 Spring Modulith를 적용하는 것이 더 효과적임

**👍 좋았던 점**

- Spring Modulith의 등장 배경과 활용 이유를 명확히 이해
- 핀테크 도메인에 대한 기초 지식 습득
- 팀원들과 함께한 스터디를 통해 많은 배움

**😞 아쉬운 점**

- 본격적으로 Spring Modulith를 활용하려는 시점에서 스터디가 종료됨
- 도메인 학습 부족으로 인해 초반 시행착오가 많았음
- 스터디 마지막 주차때 나왔던 SAGA 패턴에 적용을 하고 싶다는 생각이 들었음

**🚀 개선할 점**

- Spring Modulith의 장점뿐만 아니라 단점도 분석하여 균형 잡힌 시각을 갖추기
- 프로젝트 마무리를 위해 추가 개발 진행
- 시간과 기회가 된다면 SAGA 패턴 학습 및 적용해보기

### 상준

**📚 학습 내용**

- 모놀리식 아키텍처와 MSA의 대안으로 모듈러 모놀리스 학습
- DDD와 바운디드 컨텍스트 개념 학습
- Spring Modulith의 기능 분석 및 코틀린 프로젝트 적용

**🔍 미션을 통해 배운 점**

- 도메인 간 의존성을 줄이기 위한 아키텍처적 확장 가능성을 탐색
- Spring Modulith를 활용하여 의존성을 줄이고 모듈 독립성을 유지하는 방법 학습

**👍 좋았던 점**

- Spring Modulith를 직접 적용해보며 모듈러 모놀리스 아키텍처를 경험
- 코틀린 기반 프로젝트 진행을 통해 자바와의 차이점 학습
- 페어 프로그래밍, 트러블슈팅, PR 리뷰 등을 통해 팀원들과 협업

**😞 아쉬운 점**

- 프로젝트를 완성하지 못한 점 및 모듈 단위 테스트 적용 부족

**🚀 개선할 점**

- 이벤트 기반으로 모듈 간 의존성 대체
- 커머스 팀과의 애플리케이션 통신 및 부하 테스트 진행

### 윤한

**📚 학습 내용**

- 우아한 모노리스 강의 요약 및 Spring Modulith 공식 문서 정독
- 이벤트 스토밍 및 SAGA 패턴 학습

**🔍 미션을 통해 배운 점**

- Micro Service와 Monolithic 아키텍처의 차이 및 장단점
- Spring Modulith가 모듈러 모놀리스를 어떻게 지원하는지 학습

**👍 좋았던 점**

- 기존에는 구현 중심으로 개발했으나, 이번 미션을 통해 아키텍처 및 기술 선택, 도메인 설계에 대한 고민을 깊이 할 수 있었음

**😞 아쉬운 점**

- Spring Modulith의 효과적인 활용을 위해 도메인 주도 설계(DDD)와 도메인 이해도가 더 필요하다고 느낌

**🚀 개선할 점**

- 실제 커머스 서비스와 연동하여 요구사항을 충족하는 기능 개발

---

## 📌 총평
스터디를 통해 모듈러 모놀리스와 Spring Modulith에 대한 깊이 있는 학습이 이루어졌으며, 도메인 설계 및 이벤트 스토밍의 중요성을 체감한 시간이었습니다.
대부분의 스터디원이 도메인 이해도가 부족했던 점을 아쉬움으로 꼽았으며, Spring Modulith의 장점을 충분히 활용하려면 도메인 설계가 선행되어야 한다는 교훈을 얻었습니다.

추가적인 개선 방향으로는 실제 프로젝트 연계(with 커머스팀) 개발, SAGA 패턴 학습 및 적용, 모듈 단위 테스트 및 부하 테스트 진행이 제시되었습니다.
