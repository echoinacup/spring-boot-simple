package org.echo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("db")
public record DbConfig(String user, String pass) {
}
