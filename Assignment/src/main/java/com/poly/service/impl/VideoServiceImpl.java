package com.poly.service.impl;

import java.util.List;

import com.poly.dao.VideoDAO;
import com.poly.dao.impl.VideoDAOImpl;
import com.poly.entity.Video;
import com.poly.service.VideoService;

public class VideoServiceImpl implements VideoService{

	private VideoDAO dao;
	public VideoServiceImpl() {
		dao = new VideoDAOImpl();
	}
	@Override
	public Video findById(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public Video findByHref(String href) {
		// TODO Auto-generated method stub
		return dao.findByHref(href);
	}

	@Override
	public List<Video> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public List<Video> findAll(int pageNum, int sizeNum) {
		// TODO Auto-generated method stub
		return dao.findAll(pageNum, sizeNum);
	}

	@Override
	public Video create(Video u) {
		// TODO Auto-generated method stub
		u.setIsActive(Boolean.TRUE);
		u.setViews(0);
		u.setShares(0);
		return dao.create(u);
	}

	@Override
	public Video update(Video u) {
		// TODO Auto-generated method stub
		return dao.update(u);
	}

	@Override
	public Video delete(String href) {
		// TODO Auto-generated method stub
		Video entity = findByHref(href);
		entity.setIsActive(Boolean.FALSE);
		return dao.update(entity);
	}

}
