package sec04.ex02;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class LoginImpl
 *
 */

// 어노테이션으로 WebListener 선언 ,HttpSessionBindListener를 제외한 모든 리스너는 어노테이션을 반드시 사용한다
@WebListener
public class LoginImpl implements HttpSessionListener {
	String user_id;
	String user_pw;
	static int total_user = 0;

	public LoginImpl() {
	}

	public LoginImpl(String user_id, String user_pw) {
		this.user_id = user_id;
		this.user_pw = user_pw;
	}

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("세션 생성");
		++total_user;	// 접속자 1 증가
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("세션 소멸");
		--total_user;	// 접속자 -1 감소
	}

}
