package nl.programit.spring_test.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import nl.programit.spring_test.domain.Page;

/**
 * 
 * @author FaerieRose
 */
@Component
public interface PageRepository extends CrudRepository<Page, Long> {

}
