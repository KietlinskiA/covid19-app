package pl.kietlinski.covid19app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/patient/{pesel}")
    public ResponseEntity<Patient> getPatientList(@PathVariable String pesel) {
        return ResponseEntity.ok(mainService.getPatient(pesel));
    }

}
