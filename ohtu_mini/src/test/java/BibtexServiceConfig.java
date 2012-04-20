
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import wad.spring.service.BibtexService;
import wad.spring.service.BibtexServiceImpl;
import wad.spring.service.ReferenceService;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tonykovanen
 */
@Configuration
public class BibtexServiceConfig {

    @Bean
    public BibtexService bibtexService() {
        BibtexService bibtexService = new BibtexServiceImpl(new ReferenceRepositoryTestImpl());
        return bibtexService;
    }
}
