package com.bm.irrigation.controller;

import com.bm.irrigation.dto.PlotDetailsDto;
import com.bm.irrigation.dto.PlotDto;
import com.bm.irrigation.service.serviceImpl.PlotServiceImpl;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plot")
@CrossOrigin(origins = "*", maxAge = 3600)
public class PlotController {

    @Autowired
    PlotServiceImpl plotService;

    @PostMapping("/addPlot")
    public ResponseEntity<PlotDto> savePlot(@RequestBody PlotDto newPlot) {
        PlotDto plotDto = plotService.savePlot(newPlot);
        return new ResponseEntity<>(plotDto, HttpStatus.CREATED);
    }

    @PutMapping("/updatePlot/{plotId}")
    public ResponseEntity<PlotDto> updatePlot(@RequestBody PlotDto plotDto, @PathParam("plotId") Long plotId) {
        PlotDto updatedPlot = plotService.updatePlot(plotDto, plotId);
        return new ResponseEntity<>(updatedPlot, HttpStatus.OK);
    }

    @GetMapping("/getAllPlots")
    public ResponseEntity<List<PlotDto>> getAllPlots() {
        List<PlotDto> plots = plotService.getAllPlots();
        return new ResponseEntity<>(plots, HttpStatus.OK);
    }

    @PutMapping("/configurePlot/{plotId}")
    public ResponseEntity<PlotDto> configurePlot(@RequestBody PlotDetailsDto plotDetailsDto, @PathVariable long plotId) {
        PlotDto plotDto = null;
        plotDto = plotService.configurePlot(plotDetailsDto, plotId);
        return new ResponseEntity<>(plotDto, HttpStatus.OK);
    }

}
