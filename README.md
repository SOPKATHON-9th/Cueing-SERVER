<br>
<br>
<p align="center">
    <img src="https://github.com/SOPKATHON-9th/SERVER/assets/84304802/e3fe1d9f-a1a5-4a4e-a55e-ea904ad46288" width="400" height="400"/>.
</p>
<br>

# '🚨Cueing: 실제 재난 상황 대비 시뮬레이션 서비스'
### 32th SOPKERTHON - 🏆 안드로이드 부문 대상 수상작
#### Team9 - 9조는 솝트를 9해

<br>

### “📩 재난 문자, 확인하시나요?"
여러분은 재난 문자를 제대로 확인 하시나요? 대부분은 아닐 것입니다. 


---

## 🛠️ 협업 룰 세팅 (Code & Git Convension)

### 📃 브랜치 관리 전략 (git-flow)

```
Master(main) : 테스트 서버에서 테스트가 끝나고 운영서버로 배포 할 수 있는 브랜치
develop : 다음 버전을 출시전 테스트를 위한 브랜치
feat : 기능을 개발하는 브랜치
hotfix  : 운영중인 버전에서 발생한 버그를 수정 하는 브랜치
```

- 브랜치 이름
    - 종류/이슈번호-간단한 설명
    - EX) feat/99-worry

<br>

### 📃 커밋 컨벤션(Commit Convention)

```bash
# <타입> : <제목> #<이슈번호> 형식으로 작성하며 제목은 최대 50글자 정도로만 입력
# 제목을 아랫줄에 작성, 제목 끝에 마침표 금지, 무엇을 했는지 명확하게 작성

################
# 본문(추가 설명)을 아랫줄에 작성

################
# 꼬릿말(footer)을 아랫줄에 작성 (관련된 이슈 번호 등 추가)

################
# [    타 입    ]
# feat : 기능 추가
# fix : 버그 수정
# docs : 문서 수정
# test : 테스트 코드 추가
# refactor : 코드 리팩토링
# style : 코드 의미에 영향을 주지 않는 변경사항
# chore : 빌드 부분 혹은 패키지 매니저 수정사항
# cicd : CI/CD 관련 설정
# design : 설계 관련
################
```

<br>

### 📃 이슈 컨벤션(Issue Convention)

```bash
<!-- 이슈이름은 '[컨벤션] 기능이름' 으로 통일해주세요. 라벨로 담장자를  표시해 주세요. ex. [Feat] searchPublicCourse -->

### 😶 무슨 이슈인가요?

---

<!-- 자세한 기능 또는 버그를 설명해 주세요.
ex. 검색기능 : 장소, 제목을 키워드로 최신순으로 정렬해 퍼블릭 코스를 검색하는 기능, ???버그 : !!!, ~~~ , !!! 상황에서 ~~~한 버그가 난다.  -->

### 🤔 어떻게 해결할 예정인가요?

---

- [ ]  <!-- 해당 체크박스 안에 순서대로 어떻게 해결할지 써주세요. 그리고 해당 내용을 해결했으면 체크 표시해주세요. -->
- [ ]  <!-- ex. 검색 키워드를 쿼리로 받기 -->
- [ ]  <!-- public course 테이블에 findMany와 contains 를 사용해 검색기능 구현-->

### 🤯 주의할 점이 있나요?

---

<!-- 기능을 구현 또는 버그를 고칠 때 주의해야할 점을 써주세요 ex. 검색시 여러 칼럼을 동시에 봐야한다  -->
```

---

## 🗺️ ERD 작성 및 프로젝트 구조

### ERD
<img width="1060" alt="image" src="https://github.com/SOPKATHON-9th/SERVER/assets/101168694/436c8f60-ce84-4360-a054-1643a0884a77">




### 프로젝트 구조
<img width="306" alt="image" src="https://github.com/SOPKATHON-9th/SERVER/assets/84304802/44ee02e4-1e88-4d1c-b914-f02e83c01e7a">


---

## ✨ 팀원 역할 분배 + 응원의 메시지를 담은 파트 팀원들의 사진촬영

### 🐶 최승준

- AWS EC2, RDS 사용하여 서버 배포
- 커밋 컨벤션 정의
- 브랜치 컨벤션 정의
- ERD 설계
- API 서버 개발

### 🐰김윤지

- Git repo 생성
- 이슈 컨벤션 정의
- ERD 설계
- API 서버 개발

## 응원사진
![KakaoTalk_Photo_2023-05-20-21-32-31](https://github.com/PgmJun/jump-rope-checker/assets/84304802/f4830cf6-a4bb-47c6-8dfc-7530cf25b73d)
