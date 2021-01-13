package pl.kietlinski.covid19app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kietlinski.covid19app.entity.MedicalTest;
import pl.kietlinski.covid19app.entity.TypeOfMedicalTest;
import pl.kietlinski.covid19app.repository.MedicalTestRepository;
import pl.kietlinski.covid19app.repository.TypeOfMedicalTestRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MainService {

    MedicalTestRepository medicalTestRepository;
    TypeOfMedicalTestRepository typeOfMedicalTestRepository;

    @Autowired
    public MainService(MedicalTestRepository medicalTestRepository, TypeOfMedicalTestRepository typeOfMedicalTestRepository) {
        this.medicalTestRepository = medicalTestRepository;
        this.typeOfMedicalTestRepository = typeOfMedicalTestRepository;
        init();
    }

    public List<MedicalTest> getMedicalTests() {
        return medicalTestRepository.findAll();
    }

    private void init() {
        medicalTestRepository.deleteAll();
        List<TypeOfMedicalTest> all = typeOfMedicalTestRepository.findAll();
        medicalTestRepository.save(new MedicalTest(all.get(2), LocalDate.now(),LocalDate.now(),"TRUE","Kowalski"));
        medicalTestRepository.save(new MedicalTest(all.get(0),LocalDate.now(),LocalDate.now(),"FALSE","Kot"));
        medicalTestRepository.save(new MedicalTest(all.get(2),LocalDate.now(),LocalDate.now(),"TRUE","Kowalski"));
        medicalTestRepository.save(new MedicalTest(all.get(1),LocalDate.now(),LocalDate.now(),"FALSE","Kowalski"));
        medicalTestRepository.save(new MedicalTest(all.get(2),LocalDate.now(),LocalDate.now(),"FALSE","Kot"));
        medicalTestRepository.save(new MedicalTest(all.get(1),LocalDate.now(),LocalDate.now(),"TRUE","Kowalski"));
    }

    public MedicalTest getMedicalTestById(String id) {
        Optional<MedicalTest> medicalTest = medicalTestRepository.findById(id);
        return medicalTest.orElseGet(MedicalTest::new);
    }

    public MedicalTest addMedicalTest(MedicalTest medicalTest) {
        return medicalTestRepository.save(medicalTest);
    }
}
