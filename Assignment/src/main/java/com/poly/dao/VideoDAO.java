package com.poly.dao;

import java.util.List;

import com.poly.entity.Video;

public interface VideoDAO {
	Video findById(Integer id);
	Video findByHref(String href);
	List<Video> findAll();
	List<Video> findAll(int pageNum, int sizeNum);
	Video create(Video u);
	Video update(Video u);
	Video delete(Video u);
}
