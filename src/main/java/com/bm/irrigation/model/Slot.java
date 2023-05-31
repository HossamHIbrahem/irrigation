package com.bm.irrigation.model;

import jakarta.persistence.*;

@Entity
@Table(name = "slot")
public class Slot {
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

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "slot_id")
    private long slotId;

    @Column(name = "start_time")
    private String startTime;

    @Column(name = "end_time")
    private String endTime;

    @Column(name = "water_amount")
    private Integer irrigationWaterAmount;

    @Column(name = "irrigation_status")
    private String irrigationStatus;

    @OneToOne
    @JoinColumn(name = "plot_id")
    private Plot plot;

}
