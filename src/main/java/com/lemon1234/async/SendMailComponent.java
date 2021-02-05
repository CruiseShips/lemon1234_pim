package com.lemon1234.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 发送邮件通知
 */
@Component
public class SendMailComponent {

	
	/**
	 * 异步发送邮件
	 * @param template 邮件主题模板
	 * @throws Exception
	 */
	@Async
	public void sendMail(String template) throws Exception {
		// TODO 假装发送了邮件
	}
}
