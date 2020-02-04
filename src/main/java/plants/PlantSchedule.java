package plants;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class PlantSchedule {

    private Long id;
    private String commonName;
    private String scientific_name;

    public static LocalDate generateDate(String date) {
        if(date.length() > 0){
            return LocalDate.parse(date);
        }
        return LocalDate.now();
    }

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate lastWaterDate;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate nextWaterDate;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate lastFertilizeDate;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate nextFertilizeDate;

    private Integer waterFrequency; // change to monthlyWaterFrequency
    private Integer fertilizeFrequency; // change to monthlyFertilizeFrequency


    public PlantSchedule() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getScientific_name() {
        return scientific_name;
    }

    public void setScientific_name(String scientific_name) {
        this.scientific_name = scientific_name;
    }

    @JsonFormat(pattern="yyyy-MM-dd")
    public LocalDate getLastWaterDate() {
        return lastWaterDate;
    }

    @JsonFormat(pattern="yyyy-MM-dd")
    public void setLastWaterDate(String lastWaterDate) {
        this.lastWaterDate = generateDate(lastWaterDate);
    }

    @JsonFormat(pattern="yyyy-MM-dd")
    public LocalDate getNextWaterDate() {
        return nextWaterDate;
    }

    @JsonFormat(pattern="yyyy-MM-dd")
    public void setNextWaterDate(String nextWaterDate) {
        this.nextWaterDate = generateDate(nextWaterDate);
    }

    @JsonFormat(pattern="yyyy-MM-dd")
    public LocalDate getLastFertilizeDate() {
        return lastFertilizeDate;
    }

    @JsonFormat(pattern="yyyy-MM-dd")
    public void setLastFertilizeDate(String lastFertilizeDate) {
        this.lastFertilizeDate = generateDate(lastFertilizeDate);
    }

    @JsonFormat(pattern="yyyy-MM-dd")
    public LocalDate getNextFertilizeDate() {
        return nextFertilizeDate;
    }

    @JsonFormat(pattern="yyyy-MM-dd")
    public void setNextFertilizeDate(String nextFertilizeDate) {
        this.nextFertilizeDate = generateDate(nextFertilizeDate);
    }

    public Integer getWaterFrequency() {
        return waterFrequency;
    }

    public void setWaterFrequency(Integer waterFrequency) {
        this.waterFrequency = waterFrequency;
    }

    public Integer getFertilizeFrequency() {
        return fertilizeFrequency;
    }

    public void setFertilizeFrequency(Integer fertilizeFrequency) {
        this.fertilizeFrequency = fertilizeFrequency;
    }
}
