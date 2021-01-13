package pl.kietlinski.covid19app.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class TypeOfMedicalTest {

    @Id
    String id;
    String medicalTestName;
    String medicalTestMethod;
    String collectMethod;
    String medicalTestDescription;

    public TypeOfMedicalTest(String medicalTestName, String medicalTestMethod, String collectMethod, String medicalTestDescription) {
        this.medicalTestName = medicalTestName;
        this.medicalTestMethod = medicalTestMethod;
        this.collectMethod = collectMethod;
        this.medicalTestDescription = medicalTestDescription;
    }
}
