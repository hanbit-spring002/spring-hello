package com.hanbit.spring.core.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HelloDAO {

	@Autowired
	private SqlSession sqlSession;
	
}
