package com.jh.s4;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class SqlSessionTest extends MyTestCase {

	@Autowired
	private SqlSession sqlSession;
	
	
	@Test
	public void test() {
		assertNotNull(sqlSession);
	}

}
