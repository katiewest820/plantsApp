package plants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import plants.repository.PlantScheduleRepository;

@RestController
public class PlantScheduleController {

    @Autowired
    private PlantScheduleRepository plantScheduleRepository;

    @RequestMapping(value = "/schedule", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public String schedule(@RequestBody PlantSchedule plantSchedule) throws RequestException {
        try {
            System.out.println("my plant schedule");
            System.out.println(plantSchedule);
            plantScheduleRepository.save(plantSchedule);


            return "Successfully saved plant schedule data";
        } catch (Exception e) {
            System.out.println(e);
            throw new RequestException("Something bad happened when saving plant schedule data");
        }

    }

    @RequestMapping(value = "/schedule", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public PlantSchedule getSchedule(@RequestParam("id") Long id ) throws RequestException {
        PlantSchedule plantSchedule = plantScheduleRepository.findById(id);

        if(plantSchedule == null){
            throw new RequestException("no plant schedule with the id of: " + id + " found. Please try a different id");
        }
        return plantSchedule;
    }


}
