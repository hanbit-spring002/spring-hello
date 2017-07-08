package com.hanbit.spring.core.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hanbit.spring.core.vo.ArticleVO;

@Repository
public class BoardDAO {

	@Autowired
	private SqlSession sqlSession;
	
	public List<ArticleVO> selectList() {
		return sqlSession.selectList("board.selectList");
	}
	
	public List<ArticleVO> searchList(String keyword) {
		return sqlSession.selectList("board.searchList", keyword);
	}

	public int insertArticle(ArticleVO articleVO) {
		return sqlSession.insert("board.insertArticle", articleVO);		
	}
	
}
