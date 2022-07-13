package medz.dev.record_file;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class AnimalOwnerRecord {
    private @Id @GeneratedValue Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String petName;

    public AnimalOwnerRecord(){}

    public AnimalOwnerRecord(String firstName, String lastName, String phoneNumber, String petName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.petName = petName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName(){
        return this.firstName + " " + this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o)
            return true;
        if (!(o instanceof AnimalOwnerRecord))
            return false;
        AnimalOwnerRecord animalOwnerRecord = (AnimalOwnerRecord) o;
            return Objects.equals(this.id, animalOwnerRecord.id)
                    && Objects.equals(this.firstName, animalOwnerRecord.firstName)
                    && Objects.equals(this.lastName, animalOwnerRecord.lastName)
                    && Objects.equals(this.petName, animalOwnerRecord.petName)
                    && Objects.equals(this.phoneNumber, animalOwnerRecord.phoneNumber);
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.id, this.firstName, this.lastName, this.petName, this.phoneNumber);
    }

    @Override
    public String toString(){
        return "AnimalOwnerRecord{" + "id=" + this.id + ", firstName='" + this.firstName + '\'' + ", lastName='" + this.lastName
                + '\'' + ", petName='" + this.petName + '\'' + ", phoneNumber='" + this.phoneNumber + '\'' + '}';
    }
}
