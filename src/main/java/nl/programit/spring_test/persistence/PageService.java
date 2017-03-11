package nl.programit.spring_test.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.programit.spring_test.domain.Page;

@Service
@Transactional
public class PageService {

	@Autowired
	PageRepository pageRepository;
	
	public Page save(Page page) {
		return pageRepository.save(page);
	}
	
	public Page findById(Long id) {
		return pageRepository.findOne(id);
	}
	
	public Iterable<Page> findAll() {
		return pageRepository.findAll();
	}
	
	public void deleteById(Long id) {
		this.pageRepository.delete(id);
	}
	
	public void deletePage(Page page) {
		this.pageRepository.delete(page);
	}
}
