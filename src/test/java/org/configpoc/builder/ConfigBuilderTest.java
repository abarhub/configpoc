package org.configpoc.builder;

import org.configpoc.config.Config;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

class ConfigBuilderTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigBuilderTest.class);

    @Test
    void addPropertyFile() {
    }

    @Test
    void setExceptionOnMissingProperty() {
    }

    @Test
    void setProperty() {
    }

    @Test
    void build() {
        LOGGER.info("build");

        ConfigBuilder configBuilder=new ConfigBuilder();

        configBuilder.setProperty("key","value");

        // methode testée
        final Config config = configBuilder.build();

        // vérifications
        assertNotNull(config);
        assertEquals("value", config.getString("key"));
    }
}