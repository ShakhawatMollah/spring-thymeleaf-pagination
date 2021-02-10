package com.shakhawat.pagination.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shakhawat.pagination.domain.entity.Visitor;
import com.shakhawat.pagination.domain.repository.VisitorRepository;
import com.shakhawat.pagination.exception.InternalServerError;

@Transactional
@Service
public class VisitorServiceImpl implements VisitorService{
	
	@Autowired
	private VisitorRepository visitorRepository;

	@Override
	public Page<Visitor> getAllVisitors(Pageable pageable) {
		Page<Visitor> visitorEntities;

        try {
            visitorEntities = this.visitorRepository.findAll(pageable);
        } catch (Exception ex) {
            throw new InternalServerError();
        }

        return visitorEntities;
	}


	@Override
	public void saveVisitorInfo(Visitor visitor) {
		try {
			this.visitorRepository.save(visitor);
        } catch (Exception ex) {
            throw new InternalServerError();
        }
	}


	@Override
	public void saveAllVisitors(List<Visitor> visitors) {
		try {
			this.visitorRepository.saveAll(visitors);
        } catch (Exception ex) {
            throw new InternalServerError();
        }
	}

}
