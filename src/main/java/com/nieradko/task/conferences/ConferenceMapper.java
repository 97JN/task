package com.nieradko.task.conferences;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ConferenceMapper {
    private final ModelMapper modelMapper;

    public ConferenceDto conferenceEntityToDto(ConferenceEntity conferenceEntity){
        return modelMapper.map(conferenceEntity,ConferenceDto.class);
    }

    public ConferenceEntity conferenceDtoToEntity(ConferenceDto conferenceDto){
        return modelMapper.map(conferenceDto,ConferenceEntity.class);
    }
}
