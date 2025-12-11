package com.example.CoupangLite.Repository;

import com.example.CoupangLite.Entity.TbProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<TbProductInfo,Long> {
}
