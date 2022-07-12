package record_file;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalOwnerRecordRepository extends JpaRepository<AnimalOwnerRecord, Long> {
}
