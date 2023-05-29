package com.nieradko.task.raport;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api/report")
public class ReportController {
    private final ReportService reportService;
    @GetMapping("/interest")
    public ResponseEntity<Map<String, Double>> getReportByLectureInterest(){
        Map<String, Double> report = reportService.generateReportByLectureInterest();
        return ResponseEntity.ok(report);
    }

    @GetMapping("/conference")
    public ResponseEntity<Map<String,Double>> getReportByConferenceInterest(){
        Map<String,Double> report = reportService.getReportByConferenceInterest();
        return ResponseEntity.ok(report);
    }
}
