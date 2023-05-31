package com.bm.irrigation.dto;


public class PlotDetailsDto {

    private long plotDetailsId;

    private Double waterAmount;

    private String startTime;

    private String endTime;

    private Boolean sensorNotified;

    public Boolean getSensorNotified() {
        return sensorNotified;
    }

    public void setSensorNotified(Boolean sensorNotified) {
        this.sensorNotified = sensorNotified;
    }

    public long getPlotDetailsId() {
        return plotDetailsId;
    }

    public void setPlotDetailsId(long plotDetailsId) {
        this.plotDetailsId = plotDetailsId;
    }

    public Double getWaterAmount() {
        return waterAmount;
    }

    public void setWaterAmount(Double waterAmount) {
        this.waterAmount = waterAmount;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
