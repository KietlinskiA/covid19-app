package pl.kietlinski.covid19app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import pl.kietlinski.covid19app.entity.MedicalTest;

@Data
@AllArgsConstructor
public class Patient {
    long id;
    String name;
    String surname;
    MedicalTest medicalTest;
    String pesel;

}
