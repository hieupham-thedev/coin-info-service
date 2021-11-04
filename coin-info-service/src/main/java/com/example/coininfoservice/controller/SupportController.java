package com.example.coininfoservice.controller;

import com.example.coininfoservice.dto.StatusDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class SupportController {

    @RequestMapping(value = "/status")
    public ResponseEntity<StatusDTO> checkStatus() {
        return new ResponseEntity<>(new StatusDTO("Active", new Date()), HttpStatus.OK);
    }
}
