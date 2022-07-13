package medz.dev.record_file;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class AnimalOwnerRecordController {
    private final AnimalOwnerRecordRepository repository;
    private final AnimalOwnerRecordAssembler assembler;

    public AnimalOwnerRecordController(AnimalOwnerRecordRepository repository, AnimalOwnerRecordAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @GetMapping("/owners")
    CollectionModel<EntityModel<AnimalOwnerRecord>> all(){
        List<EntityModel<AnimalOwnerRecord>> animalOwnerRecords = repository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());
        return CollectionModel.of(animalOwnerRecords, linkTo(methodOn(AnimalOwnerRecordController.class).all()).withSelfRel());
    }

    @GetMapping("/owners/{id}")
    EntityModel<AnimalOwnerRecord> one(@PathVariable Long id){
        AnimalOwnerRecord animalOwnerRecord = repository.findById(id)
                .orElseThrow(() -> new AnimalOwnerRecordNotFoundException(id));
        return assembler.toModel(animalOwnerRecord);

    }

    @PutMapping("owners/{id}")
    ResponseEntity<?> replaceOwner(@RequestBody AnimalOwnerRecord newAnimalOwnerRecord, @PathVariable Long id){
        AnimalOwnerRecord updatedAnimalOwnerRecord = repository.findById(id)//
                .map(animalOwnerRecord -> {
                    animalOwnerRecord.setFirstName(newAnimalOwnerRecord.getFirstName());
                    animalOwnerRecord.setLastName(newAnimalOwnerRecord.getLastName());
                    animalOwnerRecord.setPetName(newAnimalOwnerRecord.getPetName());
                    animalOwnerRecord.setPhoneNumber(newAnimalOwnerRecord.getPhoneNumber());
                    return repository.save(animalOwnerRecord);
                })
                .orElseGet(() -> {
                    newAnimalOwnerRecord.setId(id);
                    return repository.save(newAnimalOwnerRecord);
                });
        EntityModel<AnimalOwnerRecord> entityModel = assembler.toModel(updatedAnimalOwnerRecord);
        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }

    @PostMapping("/owners")
    ResponseEntity<?> newOwner(@RequestBody AnimalOwnerRecord newAnimalOwnerRecord){
        EntityModel<AnimalOwnerRecord> entityModel = assembler.toModel(repository.save(newAnimalOwnerRecord));
        return ResponseEntity//
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }

    @DeleteMapping("/owners/{id}")
    ResponseEntity<?> deleteOwner(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
