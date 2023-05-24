package com.nieradko.task.conferences;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/conferences")
@AllArgsConstructor
public class ConferenceController {
    private final ConferenceService conferenceService;
    private final ModelMapper modelMapper;

    @GetMapping
    ResponseEntity<List<ConferenceDto>> getConferences(){
        List<ConferenceEntity> conferenceList = conferenceService.getAllConferences();
        List<ConferenceDto> conferenceDtos = conferenceList.stream()
                .map(conferenceEntity -> modelMapper.map(conferenceEntity,ConferenceDto.class))
                .toList();
        return new ResponseEntity<>(conferenceDtos, HttpStatus.OK);
    }

}
