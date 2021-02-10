package com.shakhawat.pagination.domain.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.shakhawat.pagination.domain.entity.Visitor;

public interface VisitorService {
	
	void saveVisitorInfo(Visitor visitor);
	
	void saveAllVisitors(List<Visitor> visitors);
	
	Page<Visitor> getAllVisitors(Pageable pageable);

}
