/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import wad.spring.service.ReferenceService;
import wad.spring.service.ReferenceServiceImpl;

/**
 *
 * @author tonykovanen
 */
@Configuration
public class ReferenceServiceConfig {

    @Bean
    public ReferenceService referenceService() {
        ReferenceService referenceService = new ReferenceServiceImpl(new ReferenceRepositoryTestImpl());
        return referenceService;
    }
}