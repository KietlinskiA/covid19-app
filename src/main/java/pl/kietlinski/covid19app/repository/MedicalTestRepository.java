package pl.kietlinski.covid19app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.kietlinski.covid19app.entity.MedicalTest;

@Repository
public interface MedicalTestRepository extends MongoRepository<MedicalTest, String> {
}
