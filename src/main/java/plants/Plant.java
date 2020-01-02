package plants;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Plant {

    private long id;
    private String scientific_name;
    private String commonName;
    private String link;

    public Plant() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setScientific_name(String scientific_name) {
        this.scientific_name = scientific_name;
    }

    @JsonProperty("common_name")
    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public long getId() {
        return id;
    }

    public String getScientific_name() {
        return scientific_name;
    }

    public String getCommonName() {
        return commonName;
    }

    public String getLink() {
        return link;
    }

    @Override
    public String toString() {
        return "Plant{" +
                "id=" + id +
                ", scientific_name='" + scientific_name + '\'' +
                ", commonName='" + commonName + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}