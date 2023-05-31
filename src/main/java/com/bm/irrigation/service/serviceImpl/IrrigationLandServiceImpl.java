package com.bm.irrigation.service.serviceImpl;

import com.bm.irrigation.dto.PlotDto;
import com.bm.irrigation.model.Plot;
import com.bm.irrigation.model.PlotDetails;
import com.bm.irrigation.repository.PlotDetailsRepository;
import com.bm.irrigation.repository.PlotRepository;
import com.bm.irrigation.service.IrrigationLandService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import java.time.LocalTime;
import java.util.List;

public class IrrigationLandServiceImpl implements IrrigationLandService {

    @Autowired
    PlotRepository plotRepository;

    @Autowired
    PlotDetailsRepository plotDetailsRepository;

    @Autowired
    SensorServiceImpl sensorServiceImpl;
    @Autowired
    ModelMapper modelMapper;

    @Value("${irrigate.sensor.base_url}")
    private String baseUrl;

    @Value("${server.port}")
    private String port;

    Logger logger = LoggerFactory.getLogger(PlotServiceImpl.class);
    private final RestTemplate restTemplate = new RestTemplate();

    @Scheduled(cron = "0/60 * * * * *") // run job after every 60 seconds || 1 minute
    public void irrigateLandSensor() {
        LocalTime my_time = LocalTime.now();
        logger.info("Scheduler running at " + my_time);

        List<Plot> plots = plotRepository.findAll();

        for (Plot plot : plots) {
            if (plot.getPlotDetails() != null) {
                PlotDetails details = plot.getPlotDetails();
                String irrigate_time = details.getStartTime().toString();
                logger.info("Irrigate time " + irrigate_time);

                String current_time = LocalTime.now().toString();

                logger.info("Scheduler running at " + current_time);

                System.out.println("Current local time " + current_time);
                logger.info("About to notify sensor! ");

                Boolean notified = notifySensor(plot);
                if (notified) {
                    // update sensor notified status
                    Plot updatePlot = plotRepository.findById(plot.getPlotId()).get();
                    details.setSensorNotified(true);
                    updatePlot.setPlotDetails(details);
                    plotRepository.save(updatePlot);

                }
            }
        }
    }

    @Override
    public Boolean notifySensor(Plot plot) {
        PlotDto plotDto = modelMapper.map(plot, PlotDto.class);
        return sensorServiceImpl.notifySensor(plotDto);
    }
}
