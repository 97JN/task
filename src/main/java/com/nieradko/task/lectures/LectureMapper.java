package com.nieradko.task.lectures;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class LectureMapper {
    private final ModelMapper modelMapper;

    public LectureDto lectureEntityToDto(LectureEntity lectureEntity){
        return modelMapper.map(lectureEntity, LectureDto.class);
    }

    public LectureEntity lectureDtoToEntity(LectureDto lectureDto){
        return modelMapper.map(lectureDto,LectureEntity.class);
    }
}
