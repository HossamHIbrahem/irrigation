package com.bm.irrigation.model;


import jakarta.persistence.*;

@Entity
@Table(name = "plot")
public class Plot {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "plot_id")
    private long plotId;

    @Column(name = "plot_size")
    private String plotSize;

    @Column(name = "crop")
    private String crop;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "plot|_details_id")
    private PlotDetails plotDetails;

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

    public PlotDetails getPlotDetails() {
        return plotDetails;
    }

    public void setPlotDetails(PlotDetails plotDetails) {
        this.plotDetails = plotDetails;
    }
}
