package com.shakhawat.pagination.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shakhawat.pagination.domain.entity.Visitor;

@Repository
public interface VisitorRepository extends JpaRepository<Visitor, Long>{

}
