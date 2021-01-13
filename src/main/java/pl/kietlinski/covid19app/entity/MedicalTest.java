package pl.kietlinski.covid19app.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
@Data
@NoArgsConstructor
public class MedicalTest {

    @Id
    String id;
    TypeOfMedicalTest typeOfMedicalTest;
    LocalDate medicalTestDate;
    LocalDate resultDate;
    String result;
    String doctorName;

    public MedicalTest(TypeOfMedicalTest typeOfMedicalTest, LocalDate medicalTestDate, LocalDate resultDate, String result, String doctorName) {
        this.typeOfMedicalTest = typeOfMedicalTest;
        this.medicalTestDate = medicalTestDate;
        this.resultDate = resultDate;
        this.result = result;
        this.doctorName = doctorName;
    }
}
