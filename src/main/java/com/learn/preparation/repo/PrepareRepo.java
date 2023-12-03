package com.learn.preparation.repo;

import com.learn.preparation.entity.Prepare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrepareRepo extends JpaRepository<Prepare, Long> {

}
