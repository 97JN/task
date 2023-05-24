package com.nieradko.task.lectures;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/lecture")
@AllArgsConstructor
public class LectureController {
    private final LectureService lectureService;

    @GetMapping("/{username}")
    ResponseEntity<Void> userLectures(){
        return null;
    }
}
