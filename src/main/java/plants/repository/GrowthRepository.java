package plants.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import plants.Growth;
import plants.Plant;

public interface GrowthRepository extends MongoRepository<Growth, String> {
    public Growth findByCommonName(String commonName);

    public Growth findById(long id);

    public String deleteGrowthById(long id);

    public String deleteGrowthByCommonName(String commonName);

}
