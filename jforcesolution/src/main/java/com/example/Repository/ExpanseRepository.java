package com.example.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Entity.Expanse;


@Repository
public interface ExpanseRepository extends JpaRepository<Expanse, Long>{

	List<Expanse> findByUserUserId(Long userId);

}
