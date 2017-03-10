package nl.programit.spring_test.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import nl.programit.spring_test.domain.Novel;

@Component
public interface NovelRepository extends CrudRepository<Novel, Long> {

}
