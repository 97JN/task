package com.nieradko.task.email;

import com.nieradko.task.reservation.ReservationEntity;
import com.nieradko.task.reservation.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ChangerService {
    private final ReservationRepository reservationRepository;

    public ResponseEntity<String> changeEmail(EmailRequest request) {
        String username = request.getUsername();
        String email = request.getEmail();
        String newEmail = request.getNewEmail();

        List<ReservationEntity> reservations = reservationRepository.findByUsername(username);
        if(!reservations.isEmpty()){
            for(ReservationEntity reservation : reservations){
                if(reservation.getEmail().equals(email)){
                    reservation.setEmail(newEmail);
                    reservationRepository.save(reservation);
                }
            }
            return new ResponseEntity<>("Email has been changed in all reservations", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("There is no reservations with given data", HttpStatus.NOT_FOUND);
        }
    }
}
