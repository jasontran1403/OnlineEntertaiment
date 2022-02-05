package com.poly.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.poly.util.JPAUtil;

public class AbstractDAO<T> {
	public static final EntityManager em = JPAUtil.getEntityManager();
	
	@Override
	protected void finalize() throws Throwable {
		em.close();
		super.finalize();
	}
	
	public T findById(Class<T> clss, Integer id) {
		return em.find(clss, id);
	}
	
	public List<T> findAll(Class<T> clss, boolean existIsActive) {
		String enName = clss.getSimpleName();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT o FROM ").append(enName).append(" o");
		if (existIsActive) {
			sql.append(" WHERE o.isActive = 1");
		}
		TypedQuery<T> query = em.createQuery(sql.toString(), clss);
		return query.getResultList();
	}
	
	public List<T> findAll(Class<T> clss, boolean existIsActive, int pageNum, int sizeNum) {
		String enName = clss.getSimpleName();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT o FROM ").append(enName).append(" o");
		if (existIsActive) {
			sql.append(" WHERE o.isActive = 1");
		}
		TypedQuery<T> query = em.createQuery(sql.toString(), clss);
		query.setFirstResult(pageNum);
		query.setMaxResults(sizeNum);
		return query.getResultList();
	}
	
	public T findOne(Class<T> clss, String sql, Object ... params) {
		TypedQuery<T> query = em.createQuery(sql, clss);
		for (int i=0; i<params.length; i++) {
			query.setParameter(i, params[i]);
		}
		List<T> result = query.getResultList();
		if (result.isEmpty()) {
			return null;
		}
		return result.get(0);
	}
	
	public List<T> findMany(Class<T> clss, String sql, Object ... params) {
		TypedQuery<T> query = em.createQuery(sql, clss);
		for (int i=0; i<params.length; i++) {
			query.setParameter(i, params[i]);
		}
		return query.getResultList();
	}

	public T create (T entity) {
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
			return entity;
		}catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}
	
	public T update (T entity) {
		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
			return entity;
		}catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}
	
	public T delete (T entity) {
		try {
			em.getTransaction().begin();
			em.remove(entity);
			em.getTransaction().commit();
			return entity;
		}catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}
}
