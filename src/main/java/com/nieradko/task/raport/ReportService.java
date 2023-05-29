package com.nieradko.task.raport;

import com.nieradko.task.conferences.ConferenceEntity;
import com.nieradko.task.conferences.ConferenceRepository;
import com.nieradko.task.lectures.LectureEntity;
import com.nieradko.task.lectures.LectureRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class ReportService {
    private final LectureRepository lectureRepository;
    private final ConferenceRepository conferenceRepository;
    public Map<String, Double> generateReportByLectureInterest() {
        List<LectureEntity> lectures = lectureRepository.findAll();
        Map<String, Double> lecturesMap = new HashMap<>();

        for (LectureEntity lecture : lectures) {
            double participantInterestInPercentage = (double) (lecture.getPersonLimit() - lecture.getPersonEntriesLeft()) / lecture.getPersonLimit() * 100;
            String lectureName = lecture.getLectureName();
            lecturesMap.put(lectureName, participantInterestInPercentage);
        }
        return lecturesMap;
    }

    public Map<String, Double> getReportByConferenceInterest() {
        List<ConferenceEntity> conferences = conferenceRepository.findAll();
        Map<String, Double> conferencesMap = new HashMap<>();

        DecimalFormat decimalFormat = new DecimalFormat("#.#");

        for (ConferenceEntity conference : conferences) {
            List<LectureEntity> lectures = conference.getAllLectures();
            int allLectures = lectures.size();
            double totalInterest = 0.0;

            for (LectureEntity lecture : lectures) {
                double participantInterestInPercentage = (double) (lecture.getPersonLimit() - lecture.getPersonEntriesLeft()) / lecture.getPersonLimit() * 100;
                totalInterest += participantInterestInPercentage;
            }

            String formattedInterest = decimalFormat.format(totalInterest / allLectures);
            conferencesMap.put(conference.getConferenceName(), Double.parseDouble(formattedInterest.replace(",", ".")));
        }

        return conferencesMap;
    }
}
