package com.hanbit.spring.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanbit.spring.core.annotation.SampleAnnotion;
import com.hanbit.spring.core.dao.BoardDAO;
import com.hanbit.spring.core.vo.ArticleVO;

@Service
public class BoardService {

	@Autowired
	private BoardDAO boardDAO;
	
	@SampleAnnotion("ADMIN")
	public List<ArticleVO> getList() {
		return boardDAO.selectList();
	}
	
	public List<ArticleVO> search(String keyword) {
		return boardDAO.searchList(keyword);
	}

	public void addArticle(ArticleVO articleVO) {
		boardDAO.insertArticle(articleVO);		
	}
	
}
