package com.nieradko.task.conferences;

import com.nieradko.task.reservation.ReservationDto;
import com.nieradko.task.reservation.ReservationRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ConferenceService {
    private final ConferenceRepository conferenceRepository;
    private final ReservationRepository reservationRepository;
    private final ModelMapper modelMapper;


    public ResponseEntity<List<ConferenceDto>> getAllConferences() {
        var conferenceList = conferenceRepository.findAll();
        List<ConferenceDto> conferences = conferenceList.stream()
                .map(conferenceEntity -> modelMapper.map(conferenceEntity, ConferenceDto.class))
                .toList();
        return new ResponseEntity<>(conferences, HttpStatus.OK);
    }

    public ResponseEntity<List<ReservationDto>> getAllRegisteredUsers() {
        var reservations = reservationRepository.findAll();

        List<ReservationDto> reservationDtos = reservations.stream()
                .map(reservation -> {
                    ReservationDto reservationDto = new ReservationDto();
                    reservationDto.setId(reservation.getId());
                    reservationDto.setUsername(reservation.getUsername());
                    reservationDto.setEmail(reservation.getEmail());
                    return reservationDto;
                }).toList();
        return new ResponseEntity<>(reservationDtos, HttpStatus.OK);
    }
}
