package com.rrbinny.service;

import com.rrbinny.model.Speaker;
import com.rrbinny.repository.HibernateSpeakerRepositoryImpl;
import com.rrbinny.repository.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service("speakerService")
@Profile("dev")
public class SpeakerServiceImpl implements SpeakerService {
    private SpeakerRepository repository;

    public SpeakerServiceImpl() {
        System.out.println("SpeakerService Impl NoArgs constructor");
    }

    // constructor injection
    public SpeakerServiceImpl(SpeakerRepository speakerRepository) {
        System.out.println("SpeakerService Impl repository constructor");
        repository = speakerRepository;
    }

    @PostConstruct
    private void initialize() {
        System.out.println("Called after constructors");
    }

    @Override
    public List<Speaker> findAll() {
        return repository.findAll();
    }

    // converted our speaker service implementation to be injected instead of hardcoded.
    @Autowired // automatically injects the SpeakerRepository bean into this setter
    public void setRepository(SpeakerRepository repository) {
        System.out.println("SpeakerService Impl setter");
        this.repository = repository;
    }
}
