package com.bm.irrigation.service;

import com.bm.irrigation.dto.PlotDetailsDto;
import com.bm.irrigation.dto.PlotDto;

import java.util.List;

public interface PlotService {

    PlotDto savePlot(PlotDto plotDto);

    PlotDto updatePlot(PlotDto plotDto, long plotId);

    PlotDto configurePlot(PlotDetailsDto plotDetailsDto, long plotId);

    List<PlotDto> getAllPlots();

}
