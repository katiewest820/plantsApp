package plants.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import plants.PlantSchedule;

public interface PlantScheduleRepository extends MongoRepository<PlantSchedule, String> {

    public PlantSchedule findByCommonName(String commonName);
    public PlantSchedule findById(long id);

}
