package com.nieradko.task.reservation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ReservationRequest {
    private String username;
    private String email;
}
