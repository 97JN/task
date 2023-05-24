package com.nieradko.task.lectures;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nieradko.task.conferences.ConferenceEntity;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class LectureDto {
    private Long id;
    private String lectureName;
    private Integer personLimit;
    @JsonIgnore
    private ConferenceEntity conferenceEntity;
}
