package com.bm.irrigation.dto;

import com.bm.irrigation.model.Plot;

public class SlotDto {

    private long slotId;

    private String startTime;

    private String endTime;

    private Integer irrigationWaterAmount;

    public long getSlotId() {
        return slotId;
    }

    public void setSlotId(long slotId) {
        this.slotId = slotId;
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

    public Integer getIrrigationWaterAmount() {
        return irrigationWaterAmount;
    }

    public void setIrrigationWaterAmount(Integer irrigationWaterAmount) {
        this.irrigationWaterAmount = irrigationWaterAmount;
    }

    public String getIrrigationStatus() {
        return irrigationStatus;
    }

    public void setIrrigationStatus(String irrigationStatus) {
        this.irrigationStatus = irrigationStatus;
    }

    public Plot getPlot() {
        return plot;
    }

    public void setPlot(Plot plot) {
        this.plot = plot;
    }

    private String irrigationStatus;

    private Plot plot;

}
