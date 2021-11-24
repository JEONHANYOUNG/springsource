package com.company.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.company.domain.PersonDTO;

public interface PersonMapper {//personmapper가 dao 역할
	//입력
	
	//BindingException: Parameter 'id' not found. Available 
	// parameters are [arg1, arg0, param1, param2]
//	@Insert("insert into person(id,name) Values(#{id},#{name})")
//	
//	@Select("select name from person where id=#{id}")  
//	
//	@Update("update person set name=#{name} where id=#{id}")
//	
	
	//인터페이스 + xml 조합 : 메소드명과 xml 아이디가 일치해야함!!! 매우 중요!!
	public int insertPerson(@Param("id") String id,@Param("name") String name);//param은 id와 name들어오면 무조건 들어와야함
	public String selectPerson(String id); //PersonMapper.xml에서 만든 selectPerson과 동일해야함
	public int updatePerson(@Param("id") String id,@Param("name") String name);
	public int deletePerson(String id);
	public List<PersonDTO> all(); 
}