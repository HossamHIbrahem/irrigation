package com.bm.irrigation.repository;

import com.bm.irrigation.model.Plot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlotRepository extends JpaRepository<Plot,Long> {

    Plot findPlotByPlotId(Long id);
}
