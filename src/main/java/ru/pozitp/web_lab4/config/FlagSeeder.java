package ru.pozitp.web_lab4.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.pozitp.web_lab4.model.FeatureFlag;
import ru.pozitp.web_lab4.repository.FeatureFlagRepository;

@Component
public class FlagSeeder implements CommandLineRunner {
    private final FeatureFlagRepository featureFlagRepository;

    public FlagSeeder(FeatureFlagRepository featureFlagRepository) {
        this.featureFlagRepository = featureFlagRepository;
    }

    @Override
    public void run(String... args) {
        if (!featureFlagRepository.existsByName("THEME_AMBER")) {
            featureFlagRepository.save(new FeatureFlag("THEME_AMBER", false));
        }
        if (!featureFlagRepository.existsByName("NEW_ALGORITHM")) {
            featureFlagRepository.save(new FeatureFlag("NEW_ALGORITHM", false));
        }
    }
}
