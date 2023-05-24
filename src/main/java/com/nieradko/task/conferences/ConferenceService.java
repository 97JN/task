package com.nieradko.task.conferences;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ConferenceService {
    private final ConferenceRepository conferenceRepository;

    public List<ConferenceEntity> getAllConferences() {
        return conferenceRepository.findAll();
    }
}
