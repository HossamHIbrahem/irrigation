package com.bm.irrigation.service.serviceImpl;

import com.bm.irrigation.dto.PlotDto;
import com.bm.irrigation.service.SensorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class SensorServiceImpl implements SensorService {

    Logger logger = LoggerFactory.getLogger(SensorService.class);

    private final RestTemplate restTemplate = new RestTemplate();

//    @Value("${irrigate.sensor.base_url}")
    private String baseUrl;

//    @Value("${server.port}")
    private String port;


    @Override
    public Boolean notifySensor(PlotDto plotDto) {
        String sensorUrl = baseUrl + ":" + port + "/sensor/notify";
        logger.info("Sensor Url " + sensorUrl);

        // send POST request
        ResponseEntity<PlotDto> response = this.restTemplate.postForEntity(sensorUrl, plotDto, PlotDto.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("Sensor notified ok!");
            return true;
        } else {
            return false;
        }
    }
}
