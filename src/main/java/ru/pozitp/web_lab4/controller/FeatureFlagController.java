package ru.pozitp.web_lab4.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.pozitp.web_lab4.model.FeatureFlag;
import ru.pozitp.web_lab4.repository.FeatureFlagRepository;

import java.util.List;

@RestController
@RequestMapping("/api/features")
@CrossOrigin
public class FeatureFlagController {
    private final FeatureFlagRepository featureFlagRepository;

    public FeatureFlagController(FeatureFlagRepository featureFlagRepository) {
        this.featureFlagRepository = featureFlagRepository;
    }

    @GetMapping
    public ResponseEntity<List<FeatureFlag>> getAllFlags() {
        return ResponseEntity.ok(featureFlagRepository.findAll());
    }

    @PostMapping("/{name}/toggle")
    public ResponseEntity<FeatureFlag> toggleFlag(@PathVariable String name) {
        FeatureFlag flag = featureFlagRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Feature flag not found: " + name));
        flag.setEnabled(!flag.getEnabled());
        return ResponseEntity.ok(featureFlagRepository.save(flag));
    }
}
