package com.example.CoupangLite.Repository;

import com.example.CoupangLite.Entity.TbUserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TbUserInfoRepository extends JpaRepository<TbUserInfo, Long> {

    //ㄱ로그인 용 id 컬럼 으로 조회 id로 조회
    Optional<TbUserInfo> findById(String id);

}
