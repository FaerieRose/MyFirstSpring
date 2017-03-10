package nl.programit.spring_test.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.programit.spring_test.domain.Novel;

@Service
@Transactional
public class NovelService {
	
	@Autowired
	private NovelRepository novelRepository;
	
	public Novel save(Novel novel) {
		return novelRepository.save(novel);
	}
	
	public Novel findById(Long id) {
		return novelRepository.findOne(id);
	}
	
	public Iterable<Novel> findAll() {
		return novelRepository.findAll();
	}
}
