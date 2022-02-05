package com.poly.service;

import javax.servlet.ServletContext;

import com.poly.entity.User;

public interface MailService {
	void sendMail(ServletContext context, User recipient, String type);
}
