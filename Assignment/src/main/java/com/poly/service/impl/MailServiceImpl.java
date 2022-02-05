package com.poly.service.impl;

import javax.servlet.ServletContext;

import com.poly.entity.User;
import com.poly.service.MailService;
import com.poly.util.MailUtil;

public class MailServiceImpl implements MailService {
	private static final String EMAIL_WELCOME_SUBJECT = "Welcome to our WORLD!";
	private static final String EMAIL_FORGOT_SUBJECT = "Your New Password Is!";

	@Override
	public void sendMail(ServletContext context, User recipient, String type) {
		// TODO Auto-generated method stub
		String host = context.getInitParameter("host");
		String port = context.getInitParameter("port");
		String user = context.getInitParameter("user");
		String pass = context.getInitParameter("pass");
		try {
			String content = null;
			String subject = null;
			switch (type) {
			case "welcome":
				subject = EMAIL_WELCOME_SUBJECT;
				content = "Dear " + recipient.getUsername() + ", Tinh tro!!";
				break;
			case "forgot":
				subject = EMAIL_FORGOT_SUBJECT;
				content = "Your password is: " + recipient.getPassword();
				break;
			default:
				subject = "Porn porn porn";
				content = "Chet may zoi tao nha con tro!";
			}
			MailUtil.sendEmail(host, port, user, pass, recipient.getEmail(), subject, subject);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
