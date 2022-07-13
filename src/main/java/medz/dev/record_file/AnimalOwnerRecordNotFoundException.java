package medz.dev.record_file;

public class AnimalOwnerRecordNotFoundException extends RuntimeException {
    public AnimalOwnerRecordNotFoundException(Long id){
        super("Couldn't find the owner " + id);
    }
}
