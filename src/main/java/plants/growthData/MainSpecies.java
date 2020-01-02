package plants.growthData;

import com.fasterxml.jackson.annotation.JsonProperty;
import plants.Growth;

import java.util.List;

public class MainSpecies {

    private Growth growth;
    private List<ImageUrl> images;
    private long id;
    private String duration;
    private String commonName;
    private String scientific_name;
    private String family_common_name;

    public MainSpecies() {
    }

    public Growth getGrowth(
            List<ImageUrl> images,
            long id,
            String duration,
            String commonName,
            String familyCommonName,
            String scientificName) {
        growth.setImages(images);
        growth.setId(id);
        growth.setDuration(duration);
        growth.setCommonName(commonName);
        growth.setFamily_common_name(familyCommonName);
        growth.setScientific_name(scientificName);
        return growth;
    }

    public void setGrowth(Growth growth) {
        this.growth = growth;
    }

    public List<ImageUrl> getImages() {
        return images;
    }

    public void setImages(List<ImageUrl> images) {
        this.images = images;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @JsonProperty("common_name")
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

    public String getFamily_common_name() {
        return family_common_name;
    }

    public void setFamily_common_name(String family_common_name) {
        this.family_common_name = family_common_name;
    }
}
