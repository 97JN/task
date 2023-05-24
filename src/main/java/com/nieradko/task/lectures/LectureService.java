package com.nieradko.task.lectures;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LectureService {
    private final LectureRepository lectureRepository;
}
