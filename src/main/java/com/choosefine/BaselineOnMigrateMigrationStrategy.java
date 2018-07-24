package com.choosefine;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.MigrationVersion;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.stereotype.Component;

@Component
public class BaselineOnMigrateMigrationStrategy implements FlywayMigrationStrategy {


    @Override
    public void migrate(Flyway flyway) {
//        flyway.setLocations();
//        flyway.setBaselineVersion(MigrationVersion.fromVersion("1.1"));
        flyway.migrate();

    }
}
