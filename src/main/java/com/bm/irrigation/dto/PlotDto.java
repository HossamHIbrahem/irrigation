package com.bm.irrigation.dto;

public class PlotDto {

    private long plotId;

    private String plotSize;

    private String crop;

    private PlotDetailsDto plotDetailsDto;

    public long getPlotId() {
        return plotId;
    }

    public void setPlotId(long plotId) {
        this.plotId = plotId;
    }

    public String getPlotSize() {
        return plotSize;
    }

    public void setPlotSize(String plotSize) {
        this.plotSize = plotSize;
    }

    public String getCrop() {
        return crop;
    }

    public void setCrop(String crop) {
        this.crop = crop;
    }

    public PlotDetailsDto getPlotDetailsDto() {
        return plotDetailsDto;
    }

    public void setPlotDetailsDto(PlotDetailsDto plotDetailsDto) {
        this.plotDetailsDto = plotDetailsDto;
    }
}
