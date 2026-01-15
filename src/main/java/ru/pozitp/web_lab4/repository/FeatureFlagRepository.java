package ru.pozitp.web_lab4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pozitp.web_lab4.model.FeatureFlag;

import java.util.Optional;

public interface FeatureFlagRepository extends JpaRepository<FeatureFlag, Long> {
    Optional<FeatureFlag> findByName(String name);
    boolean existsByName(String name);
}
