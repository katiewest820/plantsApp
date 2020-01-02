package plants;


import com.fasterxml.jackson.annotation.JsonProperty;
import plants.growthData.*;

import java.util.List;

public class Growth {
    private long id;
    private List<ImageUrl> images;
    private String family_common_name;
    private String duration;
    private String commonName;
    private String scientific_name;
    private TemperatureMinimum temperature_minimum;
    private String shade_tolerance;
    private String salinity_tolerance;
    private RootDepthMinimum root_depth_minimum;
    private String resprout_ability;
    private PrecipitationMinimum precipitation_minimum;
    private PrecipitationMaximum precipitation_maximum;
    private PlantingDensityMinimum planting_density_minimum;
    private PlantingDensityMaximum planting_density_maximum;
    private float ph_minimum;
    private float ph_maximum;
    private String moisture_use;
    private String hedge_tolerance;
    private float frost_free_days_minimum;
    private String fire_tolerance;
    private String fertility_requirement;
    private String drought_tolerance;
    private boolean cold_stratification_required;
    private String caco_3_tolerance;
    private String anaerobic_tolerance;

    public Growth() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<ImageUrl> getImages() {
        return images;
    }

    public void setImages(List<ImageUrl> images) {
        this.images = images;
    }

    public String getFamily_common_name() {
        return family_common_name;
    }

    public void setFamily_common_name(String family_common_name) {
        this.family_common_name = family_common_name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getCommonName() {
        return commonName;
    }

    @JsonProperty("common_name")
    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getScientific_name() {
        return scientific_name;
    }

    public void setScientific_name(String scientific_name) {
        this.scientific_name = scientific_name;
    }

    public TemperatureMinimum getTemperature_minimum() {
        return temperature_minimum;
    }

    public void setTemperature_minimum(TemperatureMinimum temperature_minimum) {
        this.temperature_minimum = temperature_minimum;
    }

    public String getShade_tolerance() {
        return shade_tolerance;
    }

    public void setShade_tolerance(String shade_tolerance) {
        this.shade_tolerance = shade_tolerance;
    }

    public String getSalinity_tolerance() {
        return salinity_tolerance;
    }

    public void setSalinity_tolerance(String salinity_tolerance) {
        this.salinity_tolerance = salinity_tolerance;
    }

    public RootDepthMinimum getRoot_depth_minimum() {
        return root_depth_minimum;
    }

    public void setRoot_depth_minimum(RootDepthMinimum root_depth_minimum) {
        this.root_depth_minimum = root_depth_minimum;
    }

    public String getResprout_ability() {
        return resprout_ability;
    }

    public void setResprout_ability(String resprout_ability) {
        this.resprout_ability = resprout_ability;
    }

    public PrecipitationMinimum getPrecipitation_minimum() {
        return precipitation_minimum;
    }

    public void setPrecipitation_minimum(PrecipitationMinimum precipitation_minimum) {
        this.precipitation_minimum = precipitation_minimum;
    }

    public PrecipitationMaximum getPrecipitation_maximum() {
        return precipitation_maximum;
    }

    public void setPrecipitation_maximum(PrecipitationMaximum precipitation_maximum) {
        this.precipitation_maximum = precipitation_maximum;
    }

    public PlantingDensityMinimum getPlanting_density_minimum() {
        return planting_density_minimum;
    }

    public void setPlanting_density_minimum(PlantingDensityMinimum planting_density_minimum) {
        this.planting_density_minimum = planting_density_minimum;
    }

    public PlantingDensityMaximum getPlanting_density_maximum() {
        return planting_density_maximum;
    }

    public void setPlanting_density_maximum(PlantingDensityMaximum planting_density_maximum) {
        this.planting_density_maximum = planting_density_maximum;
    }

    public float getPh_minimum() {
        return ph_minimum;
    }

    public void setPh_minimum(float ph_minimum) {
        this.ph_minimum = ph_minimum;
    }

    public float getPh_maximum() {
        return ph_maximum;
    }

    public void setPh_maximum(float ph_maximum) {
        this.ph_maximum = ph_maximum;
    }

    public String getMoisture_use() {
        return moisture_use;
    }

    public void setMoisture_use(String moisture_use) {
        this.moisture_use = moisture_use;
    }

    public String getHedge_tolerance() {
        return hedge_tolerance;
    }

    public void setHedge_tolerance(String hedge_tolerance) {
        this.hedge_tolerance = hedge_tolerance;
    }

    public float getFrost_free_days_minimum() {
        return frost_free_days_minimum;
    }

    public void setFrost_free_days_minimum(float frost_free_days_minimum) {
        this.frost_free_days_minimum = frost_free_days_minimum;
    }

    public String getFire_tolerance() {
        return fire_tolerance;
    }

    public void setFire_tolerance(String fire_tolerance) {
        this.fire_tolerance = fire_tolerance;
    }

    public String getFertility_requirement() {
        return fertility_requirement;
    }

    public void setFertility_requirement(String fertility_requirement) {
        this.fertility_requirement = fertility_requirement;
    }

    public String getDrought_tolerance() {
        return drought_tolerance;
    }

    public void setDrought_tolerance(String drought_tolerance) {
        this.drought_tolerance = drought_tolerance;
    }

    public boolean isCold_stratification_required() {
        return cold_stratification_required;
    }

    public void setCold_stratification_required(boolean cold_stratification_required) {
        this.cold_stratification_required = cold_stratification_required;
    }

    public String getCaco_3_tolerance() {
        return caco_3_tolerance;
    }

    public void setCaco_3_tolerance(String caco_3_tolerance) {
        this.caco_3_tolerance = caco_3_tolerance;
    }

    public String getAnaerobic_tolerance() {
        return anaerobic_tolerance;
    }

    public void setAnaerobic_tolerance(String anaerobic_tolerance) {
        this.anaerobic_tolerance = anaerobic_tolerance;
    }
}
