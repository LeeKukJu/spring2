package kr.or.ddit.controller.database;

public class DatabaseConnectController {
	/*
	 * 	11장 데이터베이스 연동
	 * 
	 * 	1. Oracle 11g 설치(클라이언트, 서버)
	 * 	2. Oracle SQLDeveloper 설치
	 * 	3. DataSource 설정
	 * 	- 애플리케이션이 데이터베이스에 접근하기 위한 추상화된 연결을제공하는 역할을 한다.
	 * 
	 * 		스프링에서 설정할 수 있는 데이터 소스
	 * 		- JDBC 드라이버를 통해 선언된 데이터 소스
	 * 		- JNDI에 등록된 데이터 소스
	 * 		- 커넥션을 풀링하는 데이터 소스
	 * 		- DBCP2에 등록된 데이터 소스
	 * 
	 * 		*** JNDI란?
	 * 		- JNDI(Java Naming and Directory Interface)\
	 * 		디렉토리 서비스에서 제공하는 데이터 및 객체를 발견(discover)하고 참고(lookup)허가 위한 자바 API이다.
	 * 
	 * 		1) 데이터베이스 JDBC 라이브러리 설정
	 * 		- pom.xml에서 의존성 추가
	 * 
	 * 		2) 데이터소스 설정
	 * 		- root-context.xml 설정
	 * 
	 * 	4. CRUD 게시판
	 * 	- 데이터베이스 데이터에 접근하여 처리하는 방식
	 * 		> 스프링 JDBC
	 * 		> JPA
	 * 		> 마이바ㅣㅌ스
	 * 
	 * 		1) 오라클 데이터베이스 계정 생성
	 * 		2) 생성 SQL (쿼리는 추후에 작성)
	 * 		3) 작성할 화면(기본 화면)
	 * 			> 등록화면
	 * 			> 등록 처리 후 화면
	 * 			> 목록 화면
	 * 			> 상세보기 화면
	 * 			> 수정 화면
	 * 			> 수정 처리 후 화면
	 * 			> 삭제 처리 후 화면
	 * 
	 * 	5. 스프링 JDBC
	 * 	- SQL로만 데이터베이스를 쉽게 처리할 수 있도록 도와주는 JDBCTemplate 클래스를 제공한다.
	 * 
	 * 		1. JDBCTemplate 클래스가 제공하는 주요 메서드
	 * 		
	 * 		queryForObject()
	 * 		- 하나의 결과 레코드 중에서 하나의 컬럼 값을 가져온다.
	 * 		queryForMap()
	 * 		- 하나의 결과 레코드 정보를 Map 형태로 매핑할 수 있다.
	 * 		queryForList()
	 * 		- 여러 개의 결과 레코드를 처리할 수 있다.
	 * 		query
	 * 		- ResultSetExtractor, RowCallbackHandler와 함께 조회할 때 사용한다.
	 * 		update
	 * 		- 데이터를 변경하는 SQL을 실행할 때 사용한다.
	 * 		delete
	 * 		- 데이터를 삭제하는 SQL을 실행할 때 사용한다.
	 * 		insert
	 * 		- 데이터를 등록하는 SQL을 실행할 때 사용한다.
	 * 
	 * 		2. 스프링 JDBC 설정
	 * 		
	 * 		spring-jdbc 의존관계 설정
	 * 		> 3-1 의존 관계 설정에서 이미 spring-jdbc 설정 처리 완료
	 * 		데이터소스 설정
	 * 		> 3-2 데이터소스 설정 처리 완료
	 * 		JdbcTemplate 클래스를 빈으로 정의
	 * 
	 * 		<bean id="jdbcTemplate" class="org.springfaramework.jdbc.core.jdbcTemplate">
	 * 			<property name="dataSource" ref="dataSource"/>
	 * 		</bean>
	 * 
	 * 		3. 게시판 구현
	 * 		- 기본적인 JDBC를 기반으로 한 일반적인 구현방법
	 * 
	 * 	6. JPA
	 * 	- JPA(Java Persistence API)는 자바 표준 ORM입니다.
	 * 
	 * 		Entity
	 * 		- 데이터베이스에서 지속적으로 저장된 데이터를 자바 객체에 매핑한 것이다.
	 * 		- 메모리 상에 자바 객체의 인스턴스 형태로 존배하며 EntityManager에 의해 데이터베이스의 데이터와 동기화한다.
	 * 		
	 * 		EntityManager
	 * 		- 필요에 따라 Entity와 데이터베이스의 데이터를 동기화한다.
	 * 		- EntityManager에서 제공하는 Entity 조작 API를 이용해 Entity에 대해 CRUD 작업을 할 수 있다.
	 * 
	 * 		Entity 상태
	 * 		- New 상태
	 * 		- 관리 상태
	 * 		- 분히 상태
	 * 		- 삭제된 상태
	 * 
	 * 		JPA는 JPA 구현체인 hibernate를 이용해서 사용합니다.
	 * 		SQL문을 이용하여 데이터베이스를 연동하여 데이터를 가공하는게 아니라
	 * 		Method를 통해 데이터베이스를 조작할 수 있다는 장점이 있어 객체모델을 이용하여 비지니스 로직을 구성하는데에만 집중을 할 수 있습니다.
	 * 		하지만, 프로젝트의 규모와 복잡도가 클 때는 설계가 잘 못 되는 경우 해당 프로젝트의 품질이 떨어집니다.
	 * 		그만큼 설계라인의 정확성이 필요하고, 여러 방면에서 정확한 검증이 제대로 끝나지 않으면 적용하기가 까다롭습니다.
	 * 
	 * 		*** ORM이란?
	 * 			- 객체에 데이터를 읽고 쓰는 방법으로 관계형 데이터베이스에 데이터를 읽고 쓰는 기술입니다.
	 * 
	 * 		********** 기업 면접에서 ORM은 뭐 쓰셨어요? 라는 질문을 밥는 경우
	 * 			- 저는 ibatis를 사용했습니다. / 저는 mybatis를 사용했습니다. 와 같은 답변을 하면 된다.
	 * 
	 * 	7. 마이바티스
	 * 	- SQL과 자바 객체를 매핑하는 아이디어로 개발된 데이터베이스 접근용 프레임워크이다.
	 * 
	 * 	1) 의존 관계 정의
	 * 		- pom.xml에 mybatis 설정을 위한 의존 관계를 등록하도록 합니다.
	 * 		> mybatis
	 * 		> mybatis-spring
	 * 		> spring-jdbc
	 * 		> commons-dbcp2
	 * 		> log4jdbc-log4j2-jdbc4
	 * 		> ojdbc6 or ojdbc8
	 * 
	 * 	2) 스프링과 마이바티스 연결 성정
	 * 		- root-context.xml 설정
	 * 		> dataSource
	 * 		> sqlSessionFactory
	 * 		> sqlSessionTemplate
	 * 
	 * 	3) 마이바티스 설정
	 *  	- webapp/WEB-INF/mybatisAlias/mybatisAlias.xml 설정
	 *  
	 *  4) 마이바티스 구현
	 *  	- mapper 패키지 안에 Mapper 파일 구성(.xml)
	 *  	> mapper 패키지 안에 BoardMapper.xml과 같은 xml구성
	 */
}
