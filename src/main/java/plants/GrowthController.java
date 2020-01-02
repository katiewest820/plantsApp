package plants;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import plants.growthData.ImageUrl;
import plants.growthData.PlantData;
import plants.repository.GrowthRepository;

import java.util.List;

@RestController
public class GrowthController {

    @Autowired
    private GrowthRepository growthRepository;

    // Get growing info from third party API
    @RequestMapping(value = "/new/growth", method = RequestMethod.GET)
    public Growth newGrowth(@RequestParam("token") String token, @RequestParam("link") String link) {
        String userToken = "token=" + token;
        String url = link + "?" + userToken;
        CloseableHttpClient httpClient = HttpClientBuilder
                .create()
                .build();
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);
        RestTemplate restTemplate = new RestTemplate(factory);

        ResponseEntity<PlantData> result = restTemplate.getForEntity(url, PlantData.class);
        System.out.println("common name " + result.getBody().getMain_species().getCommonName());
        return result.getBody().getMain_species().getGrowth(
                result.getBody().getMain_species().getImages(),
                result.getBody().getMain_species().getId(),
                result.getBody().getMain_species().getDuration(),
                result.getBody().getMain_species().getCommonName(),
                result.getBody().getMain_species().getFamily_common_name(),
                result.getBody().getMain_species().getScientific_name()
        );
    }

    // Add growth info to DB
    @RequestMapping(value = "/growth", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public String saveGrowthData(@RequestBody Growth growth) throws RequestException {
        try {
            growthRepository.save(growth);
            return "Successfully saved growth data";
        } catch(Exception e) {
            throw new RequestException("Something bad happened when saving growth data");
        }
    }

    // Get growth info by id
    @RequestMapping(value = "/growth", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Growth getGrowthById(@RequestParam("id") long id) throws RequestException {
        Growth growth = growthRepository.findById(id);

        if(growth == null) {
            throw new RequestException("plant growth info with id of:" + id + " not found, please try querying by another name");
        }
        return growth;
    }

    // Get growth info by common name
    @RequestMapping(value = "/growth/name", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Growth getGrowthByName(@RequestParam("commonName") String commonName) throws RequestException {
        Growth growth = growthRepository.findByCommonName(commonName);

        if(growth == null) {
            throw new RequestException("plant growth info with name of:" + commonName + " not found, please try querying by another name");
        }
        return growth;
    }

    // Delete growth data by id
    @RequestMapping(value = "/growth", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public String deleteGrowthById(@RequestParam("id") long id) throws RequestException {
        String res = growthRepository.deleteGrowthById(id);
        if(!res.equals("1")) {
            throw new RequestException("no collection by the id of: " + id + " found");
        }

        return res + " collection has been deleted";
    }

    // Delete growth data by common name
    @RequestMapping(value = "/growth/name", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public String deleteGrowthByName(@RequestParam("commonName") String commonName) throws RequestException {
        String res = growthRepository.deleteGrowthByCommonName(commonName);
        System.out.println(res);
        System.out.println(res.getClass().getSimpleName());

        if(!res.equals("1")){
            throw new RequestException("no collection with the common name of: " + commonName + " found");
        }

        return res + " collection has been deleted";

    }

    // Update saved growth images information
    @RequestMapping(value = "/growth/images", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public String updateGrowthPictures(@RequestParam("id") long id, @RequestBody List<ImageUrl> imageUrls) throws RequestException {
        Growth growth = getGrowthById(id);

        if(growth == null) {
            throw new RequestException("plant growth info with id of:" + id + " not found");
        }

        growth.setImages(imageUrls);
        growthRepository.save(growth);
        return "success";
    }


}
