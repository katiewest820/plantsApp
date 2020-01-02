package plants.repository;

import plants.Plant;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlantRepository extends MongoRepository<Plant,String> {
    public Plant findByCommonName(String commonName);

    public Plant findById(long id);

}
