package pl.kietlinski.covid19app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kietlinski.covid19app.entity.MedicalTest;
import pl.kietlinski.covid19app.model.Patient;
import pl.kietlinski.covid19app.service.MainService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {

    private MainService mainService;

    @Autowired
    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping("/testById/{id}")
    public ResponseEntity<MedicalTest> getMedicalTestById(@PathVariable String id) {
        return ResponseEntity.ok(mainService.getMedicalTestById(id));
    }

    @GetMapping("/tests")
    public ResponseEntity<List<MedicalTest>> getMedicalTests() {
        return ResponseEntity.ok(mainService.getMedicalTests());
    }

    @GetMapping("/patients")
    public ResponseEntity<List<Patient>> getPatientList() {
        return ResponseEntity.ok(mainService.getPatientList());
    }

}
