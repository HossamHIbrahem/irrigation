package com.bm.irrigation.service.serviceImpl;

import com.bm.irrigation.dto.PlotDetailsDto;
import com.bm.irrigation.dto.PlotDto;
import com.bm.irrigation.model.Plot;
import com.bm.irrigation.model.PlotDetails;
import com.bm.irrigation.repository.PlotDetailsRepository;
import com.bm.irrigation.repository.PlotRepository;
import com.bm.irrigation.service.PlotService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlotServiceImpl implements PlotService {

    @Autowired
    PlotRepository plotRepository;

    @Autowired
    PlotDetailsRepository plotDetailsRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<PlotDto> getAllPlots() {

        List<Plot> plotEBs = plotRepository.findAll();
        List<PlotDto> plotDtos = new ArrayList<>();

        for (Plot plotEB : plotEBs) {
            PlotDto plotDto = modelMapper.map(plotEB, PlotDto.class);
            plotDtos.add(plotDto);
        }

        return plotDtos;
    }

    @Override
    public PlotDto savePlot(PlotDto plotDto) {

        Plot newPlot = modelMapper.map(plotDto, Plot.class);
        newPlot = plotRepository.save(newPlot);

        return modelMapper.map(newPlot, PlotDto.class);
    }

    @Override
    public PlotDto updatePlot(PlotDto plotDto, long plotId) {

        Plot existingPlot = plotRepository.findPlotByPlotId(plotId);

        existingPlot.setPlotSize(plotDto.getPlotSize());
        existingPlot.setCrop(plotDto.getCrop());

        existingPlot = plotRepository.save(existingPlot);

        return modelMapper.map(existingPlot, PlotDto.class);
    }

    @Override
    public PlotDto configurePlot(PlotDetailsDto plotDetailsDto, long plotId) {

        PlotDetails newPlotDetails = modelMapper.map(plotDetailsDto, PlotDetails.class);

        Plot existingPlot = plotRepository.findPlotByPlotId(plotId);
        if (existingPlot.getPlotDetails() == null) {
            plotDetailsRepository.save(newPlotDetails);
        }
        existingPlot.setPlotDetails(newPlotDetails);

        return modelMapper.map(existingPlot, PlotDto.class);
    }
}
