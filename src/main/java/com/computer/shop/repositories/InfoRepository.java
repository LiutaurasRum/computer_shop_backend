package com.computer.shop.repositories;

import com.computer.shop.models.Info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InfoRepository extends JpaRepository<Info, Long> {
}
