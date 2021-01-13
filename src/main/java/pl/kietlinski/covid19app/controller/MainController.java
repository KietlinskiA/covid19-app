package pl.kietlinski.covid19app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kietlinski.covid19app.entity.MedicalTest;
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

    @GetMapping("/byId")
    public ResponseEntity<MedicalTest> getMedicalTestById(@RequestParam String id) {
        return ResponseEntity.ok(mainService.getMedicalTestById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<MedicalTest>> getMedicalTests() {
        return ResponseEntity.ok(mainService.getMedicalTests());
    }

    @PostMapping
    public MedicalTest add(@RequestBody MedicalTest medicalTest) {
        return mainService.addMedicalTest(medicalTest);
    }

}
