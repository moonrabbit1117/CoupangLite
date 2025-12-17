package com.example.CoupangLite.Service;

import com.example.CoupangLite.Entity.TbUserInfo;
import com.example.CoupangLite.Repository.TbUserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TbUserInfoService {
    private final TbUserInfoRepository tbUserInfoRepository;
    private final PasswordEncoder passwordEncoder;

    /*
    * 로그인
    * @Param loginId TbUserInfo.id
    * @Param rawPassword 사용자가 입력한 평문 비밀번호
    * @return 로그인 성공한 사용자의 엔티티
    */
    public TbUserInfo login(String loginId, String rawPassword){

        //아이디로 회원을 조회한다.
        TbUserInfo user = tbUserInfoRepository.findById(loginId).orElseThrow(() -> new IllegalArgumentException("아이디가 존재하지 않습니다."));

        //qlalfqjsgh qlry
        if (!passwordEncoder.matches(rawPassword, user.getPw())){
            throw new IllegalArgumentException("비밀번호가 올바르지 않습니다.");
        }

        return user;

    }

}
