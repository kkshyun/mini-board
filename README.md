# Mini-Board 프로젝트

이 프로젝트는 회원 관리 및 게시글 관리 기능을 구현한 시스템입니다. 회원 가입, 로그인, 회원 정보 관리와 게시글 작성, 수정, 삭제 기능을 제공합니다.

## 1. 목표

- **회원 정보 관리**: 회원 가입, 로그인, 회원 정보 조회, 수정 및 삭제 기능 구현.
- **게시글 관리**: 게시글 작성, 수정, 조회, 삭제 기능 구현.
- **기술 스택**: MySQL, JPA, Spring Boot, Swagger, ERD Cloud 활용.

## 2. 주요 기능

### 회원 관리 기능

- 회원 가입
- 회원 로그인
- 회원 정보 조회
- 회원 정보 수정
- 회원 탈퇴

### 게시글 관리 기능

- 게시글 작성
- 게시글 조회
- 게시글 수정
- 게시글 삭제

## 3. 데이터베이스 설계

### 회원(User) 테이블

<img width="475" alt="Image" src="https://github.com/user-attachments/assets/29a912f3-5616-40a0-b1eb-bc32a8f2528f" />

### 게시글(Post) 테이블

<img width="475" alt="Image" src="https://github.com/user-attachments/assets/5603748b-ef77-4ec5-b1c6-39c04eee9d7f" />

## 4. API 명세

### 회원 관리 API

- **회원가입**: 사용자 정보를 입력하여 회원 가입을 진행합니다.
- **로그인**: 사용자 정보를 입력하여 로그인합니다.
- **회원정보 조회**: 사용자의 정보를 조회합니다.
- **회원정보 수정**: 사용자의 정보를 수정합니다.
- **회원탈퇴**: 사용자 정보를 삭제합니다.

### 게시글 관리 API

- **게시글 작성**: 새로운 게시글을 작성합니다.
- **게시글 조회**: 작성된 게시글을 조회합니다.
- **게시글 수정**: 기존 게시글을 수정합니다.
- **게시글 삭제**: 게시글을 삭제합니다.

## 5. 기술 스택

- **백엔드**: Spring Boot, JPA
- **데이터베이스**: MySQL
- **API 문서화**: Swagger
- **기타**: ERD Cloud (데이터베이스 설계 및 시각화)

