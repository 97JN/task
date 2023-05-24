package com.nieradko.task.reservation;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ReservationRequest {
    @Column(unique = true)
    private String username;
    @Column(unique = true)
    private String email;
}
