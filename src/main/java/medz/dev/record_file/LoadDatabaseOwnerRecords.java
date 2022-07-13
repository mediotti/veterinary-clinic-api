package medz.dev.record_file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabaseOwnerRecords {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabaseOwnerRecords.class);

    @Bean
    CommandLineRunner initDatabase(AnimalOwnerRecordRepository animalOwnerRecordRepository){
        return args -> {
            animalOwnerRecordRepository.save(new AnimalOwnerRecord("Gabriel", "Mediotti", "11971317653", "Lola"));
            animalOwnerRecordRepository.save(new AnimalOwnerRecord("Giulia", "Pugliesi", "11940222763", "Luna"));
            animalOwnerRecordRepository.findAll().forEach(animalOwnerRecord -> log.info("Pre-loaded" + animalOwnerRecord));
        };
    }
}
