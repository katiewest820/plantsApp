package plants;

import org.springframework.boot.SpringApplication;

import plants.repository.PlantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//
//        repository.deleteAll();
//
//        // save a couple of plants
//        Plant blah = new Plant();
//        blah.setId(1);
//        blah.setCommonName("katie_common");
//        blah.setScientific_name("katie_scientific");
//        blah.setLink("http://trefle.io/api/plants/103505");
//
//        repository.save(blah);
//
//        Plant blah2 = new Plant();
//        blah2.setId(2);
//        blah2.setCommonName("katie_common2");
//        blah2.setScientific_name("katie_scientific2");
//        blah2.setLink("http://trefle.io/api/plants/103505");
//
//        repository.save(blah2);
//
//
//        // fetch all customers
//        System.out.println("Plants found with findAll():");
//        System.out.println("-------------------------------");
//        for (Plant plant : repository.findAll()) {
//            System.out.println(plant);
//        }
//        System.out.println();
//
//        // fetch an individual plant
//        System.out.println("Customer found with findByFirstName('Alice'):");
//        System.out.println("--------------------------------");
//        System.out.println(repository.findByCommonName(blah.getCommonName()));
//
//    }
}
