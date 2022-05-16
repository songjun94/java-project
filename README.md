# 05. java project - 회원관리 시스템

## 00. 팀원 소개
- 박재운
- 김현진
- 최원일
- 송준

## 01. 기술 스택
- jsp
- tomcat 
- bootstrap
- Java (eclipse)
- Mysql, Mysql(connector)

## 02. 프로젝트 주제
- JAVA 수업시간에 배운 CRUD(Create(생성), Read(읽기), Update(갱신), Delete(삭제))를 활용한 회원관리 시스템을 만들어 보자

## 03. 기능 명세
- Mysql 데이터 베이스와 이클립스와의 연결
- 로그인/로그아웃 기능 
- 회원가입 기능 
- ID정보 불러오는 기능
- 회원 정보 수정 기능

## 05. 화면 UI
첫 화면
![로그인이 필요합니다](https://user-images.githubusercontent.com/99165620/168627575-4ce74dca-6fbf-4451-bae0-877a521d30f1.png)
회원가입
![회원가입](https://user-images.githubusercontent.com/99165620/168627582-6b85f453-50b6-44f7-a5c6-d9a822e673cb.png)


## 06. 트러블 슈팅
- 환경변수 문제
jdk 버전 최신버전은 오류가 많다-> 17 에서 11버전으로 써서 해결

- 회원정보 수정시 id값이 고정이 되지 않고 null로 나오는 문제
현재 로그인 중인 id, sessionId의 값을 넘겨 받아 id에 String타입으로 저장 후 해결

- 회원정보 수정 완료 후 SELECT * FROM user; 시 비밀번호가 null로 뜨는 문제
import java.sql.Statement (editAction.jsp 파일)
private Statement stmt; 없는 코드 추가 (UserDAO.class 파일)
pstmt = conn.prepareStatement();     ====> 	stmt = conn.createStatement();(UserDAO.class 파일)

- 회원 탈퇴 기능
