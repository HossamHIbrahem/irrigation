package com.bm.irrigation.model;


import jakarta.persistence.*;

@Entity
@Table(name = "plot_details")
public class PlotDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "plot|_details_id")
    private long plotDetailsId;

    @Column(name = "water_amount")
    private Double waterAmount;

    @Column(name = "start_time")
    private String startTime;

    @Column(name = "sensor_notified")
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

    @Column(name = "end_time")
    private String endTime;

}
