package com.vhre.telemetrybasics.config;

import org.apache.kafka.common.config.TopicConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

@Configuration
public class KafkaTopicConfig {

    public static final String TEMPERATURE_TOPIC = "office.sensors.temperature.raw";
    public static final String OCCUPANCY_TOPIC = "office.sensors.occupancy.raw";
    public static final String ENERGY_METER = "office.energy.meter.readings";
    public static final String ACCESS_EVENTS = "office.access.events";
    public static final String ALERTS_DERIVED = "office.alerts.derived";

    @Bean
    public KafkaAdmin.NewTopics appTopics() {
        return new KafkaAdmin.NewTopics(
                TopicBuilder.name(TEMPERATURE_TOPIC)
                        .partitions(6)
                        .replicas(3)
                        .config(TopicConfig.RETENTION_MS_CONFIG, "604800000")
                        .config(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE)
                        .build(),

                TopicBuilder.name(OCCUPANCY_TOPIC)
                        .partitions(3)
                        .replicas(2)
                        .config(TopicConfig.RETENTION_MS_CONFIG, "86400000")
                        .config(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE)
                        .build(),

                TopicBuilder.name(ENERGY_METER)
                        .partitions(12)
                        .replicas(2)
                        .config(TopicConfig.RETENTION_MS_CONFIG, "2592000000")
                        .config(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE)
                        .build(),

                TopicBuilder.name(ACCESS_EVENTS)
                        .partitions(6)
                        .replicas(3)
                        .config(TopicConfig.RETENTION_MS_CONFIG, "7776000000")
                        .config(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE)
                        .build(),

                TopicBuilder.name(ALERTS_DERIVED)
                        .partitions(3)
                        .replicas(2)
                        .config(TopicConfig.RETENTION_MS_CONFIG, "604800000")
                        .config(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE)
                        .build()
        );

    }

}
