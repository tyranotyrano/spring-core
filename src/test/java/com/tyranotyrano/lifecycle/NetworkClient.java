package com.tyranotyrano.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient implements InitializingBean, DisposableBean {
    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + this.url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // 서비스 시작 시, 호출
    public void connect() {
        System.out.println("connect : " + this.url);
    }

    public void call(String message) {
        System.out.println("call : " + url + ", message : " + message);
    }

    // 서비스 종료 시, 호출
    public void disconnect() {
        System.out.println("close : " + this.url);
    }

    // 빈 초기화 메서드(객체생성 -> 의존관계 설정 후 호출되는 콜백 메서드)
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("NetworkClient.afterPropertiesSet");
        connect();
        call("초기화 연결 메세지");
    }


    // 빈 소멸 메서드(객체 소멸 전 호출되는 콜백 메서드)
    @Override
    public void destroy() throws Exception {
        System.out.println("NetworkClient.destroy");
        disconnect();
    }
}
