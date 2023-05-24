package com.nieradko.task.conferences;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nieradko.task.lectures.LectureEntity;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class ConferenceDto {
    private Long id;
    private String conferenceName;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private String startDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private String endDate;
    private List<LectureEntity> lectureEntities;
}
