package com.example.CoupangLite.DTO;

public class LoginRequest {

    // DTO는 요청 데이터를 받기위한 전용 객체이다.(로그인 요청에서 전달된 값을 담ㅇ는 객체)
    // DTO가 없으면 Controller가 지저분해짐. 전용 데이터 클래스이다!!

    private String loginId;
    private String password;

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
