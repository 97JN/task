package com.nieradko.task.lectures;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nieradko.task.conferences.ConferenceEntity;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Entity
@Table(name = "lecture")
public class LectureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String lectureName;
    private Integer personLimit;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "conference_id", nullable = false)
    @JsonIgnore
    private ConferenceEntity conferenceEntity;

}
