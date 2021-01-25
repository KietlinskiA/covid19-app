package pl.kietlinski.covid19app.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kietlinski.covid19app.entity.MedicalTest;
import pl.kietlinski.covid19app.entity.TypeOfMedicalTest;
import pl.kietlinski.covid19app.model.Patient;
import pl.kietlinski.covid19app.repository.MedicalTestRepository;
import pl.kietlinski.covid19app.repository.TypeOfMedicalTestRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@Service
public class MainService {

    MedicalTestRepository medicalTestRepository;
    TypeOfMedicalTestRepository typeOfMedicalTestRepository;
    List<Patient> patientList;

    @Autowired
    public MainService(MedicalTestRepository medicalTestRepository, TypeOfMedicalTestRepository typeOfMedicalTestRepository) {
        this.medicalTestRepository = medicalTestRepository;
        this.typeOfMedicalTestRepository = typeOfMedicalTestRepository;
        patientList = new ArrayList<>();
        init();
    }

    public List<MedicalTest> getMedicalTests() {
        return medicalTestRepository.findAll();
    }

    private void init() {
        medicalTestRepository.deleteAll();
        List<TypeOfMedicalTest> typeOfMedicalTestList = typeOfMedicalTestRepository.findAll();
        MedicalTest medicalTest1 = new MedicalTest(typeOfMedicalTestList.get(2), LocalDate.now(), LocalDate.now(), "TRUE", "Kowalski");
        MedicalTest medicalTest2 = new MedicalTest(typeOfMedicalTestList.get(0),LocalDate.now(),LocalDate.now(),"FALSE","Kot");
        medicalTestRepository.save(medicalTest1);
        medicalTestRepository.save(medicalTest2);

        patientList.add(new Patient(
                1L,
                "Ewa",
                "Kopacz",
                medicalTest1,
                "1111"));
        patientList.add(new Patient(
                2L,
                "Maciej",
                "Stern",
                medicalTest2,
                "2222"));
    }

    public MedicalTest getMedicalTestById(String id) {
        Optional<MedicalTest> medicalTest = medicalTestRepository.findById(id);
        return medicalTest.orElseGet(MedicalTest::new);
    }

}
