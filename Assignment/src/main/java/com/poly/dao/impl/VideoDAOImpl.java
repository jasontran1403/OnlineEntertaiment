package com.poly.dao.impl;

import java.util.List;

import com.poly.dao.AbstractDAO;
import com.poly.dao.VideoDAO;
import com.poly.entity.Video;

public class VideoDAOImpl extends AbstractDAO<Video> implements VideoDAO{

	@Override
	public Video findById(Integer id) {
		// TODO Auto-generated method stub
		return super.findById(Video.class, id);
	}

	@Override
	public Video findByHref(String href) {
		// TODO Auto-generated method stub
		String sql = "SELECT o FROM Video o WHERE o.href = ?0";
		return super.findOne(Video.class, sql, href);
	}

	@Override
	public List<Video> findAll() {
		// TODO Auto-generated method stub
		return super.findAll(Video.class, true);
	}

	@Override
	public List<Video> findAll(int pageNum, int sizeNum) {
		// TODO Auto-generated method stub
		return super.findAll(Video.class, true, pageNum, sizeNum);
	}
	

}
