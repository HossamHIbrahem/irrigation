package com.bm.irrigation.service;

import com.bm.irrigation.model.Plot;

public interface IrrigationLandService {

    public void irrigateLandSensor();

    public Boolean notifySensor(Plot plot);

}
