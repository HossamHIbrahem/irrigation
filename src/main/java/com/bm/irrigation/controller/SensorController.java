package com.bm.irrigation.controller;

import com.bm.irrigation.dto.PlotDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sensor")
public class SensorController {


    @PostMapping("/notify")
    public ResponseEntity<String> notifySensor(@RequestBody PlotDto plot) {

        return new ResponseEntity<>("", HttpStatus.OK);
    }


}
