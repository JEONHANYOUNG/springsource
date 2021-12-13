package com.company.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

//<!-- 해당 annotation이 사용된 패키지를 SCAN하는 구문이 필요하다 -->
//<context:component-scan base-package="com.company.service" />
@ComponentScan("com.company.service")

//<!-- mybatis 사용하는 Mapper interface, Mapper xml 활성화 -->
//<mybatis-spring:scan
// base-package="com.company.mapper" />
@MapperScan("com.company.mapper")
@Configuration
public class RootConfig {
 
	/* 1. <!-- 해당 annotation이 사용된 패키지를 SCAN하는 구문이 필요하다 -->
	   <context:component-scan
	      base-package="com.company.service" /> => @ComponentScan("com.company.service")*/
	
	/* 2. <!-- mybatis 사용하는 Mapper interface, Mapper xml 활성화 -->
	   <mybatis-spring:scan
	      base-package="com.company.mapper" /> => @MapperScan("com.company.mapper") */
	
	 /* 3. <bean id="sqlSessionFactory"
		      class="org.mybatis.spring.SqlSessionFactoryBean">
		      <property name="dataSource" ref="ds"></property>
		   </bean> */
	
	@Bean //객체 생성  
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());
		return sqlSessionFactoryBean.getObject();	
	}
	
	
	/* 4. <!-- DBCP(DataBaseConnectionPulling):데이터베이스 커넥션 풀링 >> HikariCP -->
	   <bean id="hikariConfig" class="com.zaxxer.hikari.HikariConfig"><!--외부 객체 불러오는 방식 -->
	      <property name="driverClassName"
	         value="oracle.jdbc.OracleDriver" />
	      <property name="jdbcUrl"
	         value="jdbc:oracle:thin:@localhost:1521:xe" />
	      <property name="username" value="c##java" />
	      <property name="password" value="12345" />
	   </bean> => Hikari */

	@Bean()
	public DataSource dataSource() {
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName("oracle.jdbc.OracleDriver");
		hikariConfig.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		hikariConfig.setUsername("c##java");
		hikariConfig.setPassword("12345");
		
		HikariDataSource dataSource = new HikariDataSource(hikariConfig);
		return dataSource;
	}
}
