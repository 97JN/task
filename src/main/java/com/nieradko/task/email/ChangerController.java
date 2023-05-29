package com.nieradko.task.email;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/changer")
public class ChangerController {
    private final ChangerService changerService;

    @PostMapping
    public ResponseEntity<String> changeEmail(@RequestBody EmailRequest request){
        return changerService.changeEmail(request);
    }

}
