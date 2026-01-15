package ru.pozitp.web_lab4.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "feature_flags")
@Data
@NoArgsConstructor
public class FeatureFlag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private Boolean enabled;

    public FeatureFlag(String name, Boolean enabled) {
        this.name = name;
        this.enabled = enabled;
    }
}
