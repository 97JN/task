package com.nieradko.task.conferences;

import com.nieradko.task.reservation.ReservationDto;
import com.nieradko.task.reservation.ReservationRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ConferenceService {
    private final ConferenceRepository conferenceRepository;
    private final ReservationRepository reservationRepository;
    private final ModelMapper modelMapper;


    public ResponseEntity<List<ConferenceDto>> getAllConferences() {
        List<ConferenceDto> conferences = conferenceRepository.findAll()
                .stream()
                .map(conferenceEntity -> modelMapper.map(conferenceEntity, ConferenceDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(conferences, HttpStatus.OK);
    }

    public ResponseEntity<List<ReservationDto>> getAllRegisteredUsers() {
        List<ReservationDto> reservationDtos = reservationRepository.findAll()
                .stream()
                .map(reservation -> modelMapper.map(reservation, ReservationDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(reservationDtos, HttpStatus.OK);
    }
}
