package com.rrbinny.repository;

import com.rrbinny.model.Speaker;

import java.util.List;

public interface SpeakerRepository {
    List<Speaker> findAll();
}
