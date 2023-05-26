package com.nieradko.task.conferences;

import com.nieradko.task.reservation.ReservationDto;
import com.nieradko.task.reservation.ReservationEntity;
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


    public List<ConferenceDto> getAllConferences() {
        var conferenceList= conferenceRepository.findAll();
        List<ConferenceDto> conferences = conferenceList.stream()
                .map(conferenceEntity -> modelMapper.map(conferenceEntity,ConferenceDto.class))
                .toList();
        return new ResponseEntity<>(conferences, HttpStatus.OK).getBody();
    }

    public List<ReservationDto> getAllRegisteredUsers() {
        var reservations = reservationRepository.findAll();

        return reservations.stream().distinct()
                .map(reservation -> {
                    ReservationDto reservationDto = new ReservationDto();
                    reservationDto.setId(reservation.getId());
                    reservationDto.setUsername(reservation.getUsername());
                    reservationDto.setEmail(reservation.getEmail());
                    return reservationDto;
                })
                .toList();
    }
}
