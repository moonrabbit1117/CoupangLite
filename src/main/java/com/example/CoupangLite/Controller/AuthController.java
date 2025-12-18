package com.example.CoupangLite.Controller;

import com.example.CoupangLite.DTO.LoginRequest;
import com.example.CoupangLite.Entity.TbUserInfo;
import com.example.CoupangLite.Service.TbUserInfoService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final TbUserInfoService tbUserInfoService;

    //로그인 화면
    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("loginRequest", new LoginRequest());
        return "auth/login";
    }

    //로그인 처리
    @PostMapping("/login")
    public String login(@ModelAttribute("loginRequest") LoginRequest loginRequest, HttpSession httpSession, Model model) {
        try {
            TbUserInfo tbUserInfo = tbUserInfoService.login(
                    loginRequest.getLoginId(),
                    loginRequest.getPassword()
            );

            //세션에 로그인 정보 저장
            httpSession.setAttribute("LOGIN_USER_SEQ", tbUserInfo.getSeq());
            httpSession.setAttribute("LOGIN_USER_ID", tbUserInfo.getId());
            httpSession.setAttribute("LOGIN_USER_NAME", tbUserInfo.getUser_name());
            httpSession.setAttribute("LOGIN_USER_TYPE", tbUserInfo.getUser_type());

            return "redirect:/"; //로그인 성공하면 메인으로 리다이렉션 한다
        } catch (IllegalArgumentException | IllegalStateException e) {
            model.addAttribute("ErrorMessage", e.getMessage());
            return "auth/login";
        }
    }

    //로그아웃
    @GetMapping("/logout")
    public String logout(HttpSession httpSession) {
        httpSession.invalidate();
        return "redirect:/";
    }

    //로그인 했는지 확인하는 기능
    @GetMapping("/login-check")
    public String loginCheck(HttpSession httpSession, Model model){

        Object loginUserId = httpSession.getAttribute("LOGIN_USER_IND");

        if(loginUserId != null){
            model.addAttribute("message", "로그인 상태입니다! (" + loginUserId + ")");
        } else {
            model.addAttribute("message", "로그인이 필요합니다!");
        }
        return "auth/login-check"; // login-check.html로 이동!
    }
}
