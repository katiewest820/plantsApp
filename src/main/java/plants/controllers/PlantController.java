package plants.controllers;

import org.apache.coyote.Request;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import plants.Plant;
import plants.RequestException;
import plants.repository.PlantRepository;

@RestController
public class PlantController {

    @Autowired
    private PlantRepository plantRepository;

    // Get plant info from third party API
    @RequestMapping(value = "/new/plant", method = RequestMethod.GET)
    public Plant[] newPlant(@RequestParam("token") String token, @RequestParam("filterKey") String filterKey, @RequestParam("filterVal") String filterVal ) {
        String userToken = "token=" + token;
        String params = String.format("&%s=%s", filterKey, filterVal);
        String allPlantsUrl = "https://trefle.io/api/plants?" + userToken + params;
        CloseableHttpClient httpClient = HttpClientBuilder
                .create()
                .build();
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);
        RestTemplate restTemplate = new RestTemplate(factory);
        ResponseEntity<Plant[]> results = restTemplate.getForEntity(allPlantsUrl, Plant[].class);

        return results.getBody();
    }

    // Add plant info to DB
    @RequestMapping(value = "/plant", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public String savePlant(@RequestBody Plant plant) throws RequestException {
        try {
            plantRepository.save(plant);
            return "Successfully saved plant data";
        } catch(Exception e) {
            throw new RequestException("Something bad happened when saving growth data");
        }
    }

    // Get plant by id
    @RequestMapping(value = "/plant", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Plant getPlantById(@RequestParam("id") long id) throws RequestException {
        Plant plant = plantRepository.findById(id);

        if(plant == null){
            throw new RequestException("No plant with id of: " + id + " found");
        }
        return plant;
    }

    // Get plant by common name
    @RequestMapping(value = "/plant/name", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Plant getPlantByName(@RequestParam("commonName") String commonName) throws RequestException {
        Plant plant = plantRepository.findByCommonName(commonName);

        if(plant == null){
            throw new RequestException("No plant with the name of: " + commonName + " found");
        }
        return plant;
    }

    // Delete plant data by id
    @RequestMapping(value = "/plant", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public String deletePlantById(@RequestParam("id") long id) {
        plantRepository.deleteById(String.valueOf(id));
        return "plant has been deleted";
    }

    // Delete plant data by common name
    @RequestMapping(value = "/plant/name", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public String deletePlantByName(@RequestParam("commonName") String commonName) throws RequestException {
        String res = plantRepository.deletePlantByCommonName(commonName);

        if(!res.equals("1")){
            throw new RequestException("no plant by the name of: " + commonName + " found");
        }

        return res + " plant has been deleted";
    }

}
