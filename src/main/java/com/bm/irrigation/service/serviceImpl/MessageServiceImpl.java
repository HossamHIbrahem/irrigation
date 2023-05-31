package com.bm.irrigation.service.serviceImpl;

import com.bm.irrigation.dto.MessageDto;
import com.bm.irrigation.model.Message;
import com.bm.irrigation.repository.MessageRepository;
import com.bm.irrigation.service.MessageService;
import com.bm.irrigation.service.SensorService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private ModelMapper modelMapper;

    Logger logger = LoggerFactory.getLogger(SensorService.class);

    private final RestTemplate restTemplate = new RestTemplate();

//    @Value("${irrigate.sensor.base_url}")
    private String baseUrl;

//    @Value("${server.port}")
    private String port;

    public MessageDto saveMessage(MessageDto messageDTO) {

        Message messageEB = modelMapper.map(messageDTO, Message.class);
        return modelMapper.map(messageRepository.save(messageEB), MessageDto.class);
    }

    @Override
    public Boolean alertService() {

        // make a call to external alert service through sms
        Message message = new Message();
        message.setMessage("Hey! we were unable to reach the sensor. Please check it out.");

        String sensorUrl = baseUrl + ":" + port + "/alerts/send";
        logger.info("Sensor Url " + sensorUrl);

        // send POST request
        restTemplate.postForEntity(sensorUrl, modelMapper.map(message, MessageDto.class), MessageDto.class);

        return true;
    }
}
