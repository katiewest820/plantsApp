package plants;

import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import plants.repository.PlantScheduleRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import plants.repository.PlantScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;


@Component
class PlantScheduleGraphQLDataFetchers {

    @Autowired
    private PlantScheduleRepository plantScheduleRepository;

    private PlantSchedule plantSchedule;

    public DataFetcher getPlantScheduleIdDataFetcher() {
        return dataFetchingEnvironment -> {
            String plantScheduleId = dataFetchingEnvironment.getArgument("id");
            long id = Long.parseLong(plantScheduleId);
            PlantSchedule plantSchedule = plantScheduleRepository.findById(id);
            System.out.println(plantSchedule);
            return plantSchedule;
        };
    }

    public DataFetcher getPlantScheduleNameDataFetcher() {
        return dataFetchingEnvironment -> {
            String plantScheduleName = dataFetchingEnvironment.getArgument("commonName");
            PlantSchedule plantSchedule = plantScheduleRepository.findByCommonName(plantScheduleName);
            System.out.println(plantSchedule);
            return plantSchedule;
        };
    }

    public DataFetcher addPlantSchedule() {
        return dataFetchingEnvironment -> {
            PlantSchedule plantSchedule = new PlantSchedule();

            String plantScheduleName = dataFetchingEnvironment.getArgument("commonName");
            Long id = Long.parseLong(dataFetchingEnvironment.getArgument("id"));
            String scientificName = dataFetchingEnvironment.getArgument("scientific_name");
            String lastWaterDate = dataFetchingEnvironment.getArgument("lastWaterDate");
            String nextWaterDate = dataFetchingEnvironment.getArgument("nextWaterDate");
            String lastFertilizeDate = dataFetchingEnvironment.getArgument("lastFertilizeDate");
            String nextFertilizeDate = dataFetchingEnvironment.getArgument("nextFertilizeDate");
            Integer monthlyWaterFrequency = dataFetchingEnvironment.getArgument("monthlyWaterFrequency");
            Integer monthlyFertilizeFrequency = dataFetchingEnvironment.getArgument("monthlyFertilizeFrequency");

            plantSchedule.setCommonName(plantScheduleName);
            plantSchedule.setId(id);
            plantSchedule.setScientific_name(scientificName);
            plantSchedule.setLastWaterDate(lastWaterDate);
            plantSchedule.setNextWaterDate(nextWaterDate);
            plantSchedule.setLastFertilizeDate(lastFertilizeDate);
            plantSchedule.setNextFertilizeDate(nextFertilizeDate);
            plantSchedule.setMonthlyWaterFrequency(monthlyWaterFrequency);
            plantSchedule.setMonthlyFertilizeFrequency(monthlyFertilizeFrequency);

            plantScheduleRepository.save(plantSchedule);
            return plantSchedule;
        };
    }

    public DataFetcher deletePlantSchedule() {
        return dataFetchingEnvironment -> {
            String id = dataFetchingEnvironment.getArgument("id");
            plantScheduleRepository.deletePlantScheduleById(Long.parseLong(id));
            StringResponse stringResponse = new StringResponse();
            stringResponse.setResponse("Plant schedule " + id + " successfully deleted");
            System.out.println(stringResponse);
            return stringResponse;
        };
    }




}
