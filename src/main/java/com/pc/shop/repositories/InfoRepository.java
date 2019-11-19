package com.pc.shop.repositories;

import com.pc.shop.models.Info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InfoRepository extends JpaRepository<Info, Long> {
}
