package net.ikazerskiy.projects.service;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("net.ikazerskiy.projects.service.dao")
@EntityScan("net.ikazerskiy.projects.service.dao.entity")
public class ServiceConfiguration {
}
