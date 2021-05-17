package com.rrbinny;

import com.rrbinny.repository.HibernateSpeakerRepositoryImpl;
import com.rrbinny.repository.SpeakerRepository;
import com.rrbinny.service.SpeakerService;
import com.rrbinny.service.SpeakerServiceImpl;
import com.rrbinny.util.CalendarFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Calendar;

@Configuration
@ComponentScan({"com.rrbinny"})
public class AppConfig {

    @Bean(name = "cal")
    public CalendarFactory calFactory() {
        CalendarFactory factory = new CalendarFactory();
        factory.addDays(2);
        return factory;
    }

    @Bean
    public Calendar calObject() throws Exception{
        return calFactory().getObject();
    }
    // Our repository is setter injected into a speaker service
//    @Bean(name = "speakerService")
//    @Scope(value = BeanDefinition.SCOPE_SINGLETON)
//    public SpeakerService getSpeakerService() {
//        // SpeakerServiceImpl service = new SpeakerServiceImpl(getSpeakerRepository());
//        SpeakerServiceImpl service = new SpeakerServiceImpl();
//        // service.setRepository(getSpeakerRepository());
//        return service;
//    }

    // Bean makes sure it's a singleton
//    @Bean(name = "speakerRepository")
//    public SpeakerRepository getSpeakerRepository() {
//        return new HibernateSpeakerRepositoryImpl();
//    }
}
