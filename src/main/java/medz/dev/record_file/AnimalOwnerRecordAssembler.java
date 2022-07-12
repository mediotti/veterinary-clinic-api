package record_file;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class AnimalOwnerRecordAssembler implements RepresentationModelAssembler<AnimalOwnerRecord, EntityModel<AnimalOwnerRecord>> {

    @Override
    public EntityModel<AnimalOwnerRecord> toModel(AnimalOwnerRecord animalOwnerRecord){
        return EntityModel.of(animalOwnerRecord,
                linkTo(methodOn(AnimalOwnerRecordController.class).one(animalOwnerRecord.getId())).withSelfRel(),
                linkTo(methodOn(AnimalOwnerRecordController.class).all()).withRel("owners"));
    }
}
