package com.example.demo.config

import com.typesafe.config.ConfigFactory

object AppConfig {
    private val config = ConfigFactory.load()

    val kafkaBootstrapServers = config.getString("kafka.bootstrap.servers")
    val kafkaTopic = config.getString("kafka.topic")
    val generationIntervalMs = config.getLong("generation.interval.ms")
    val productIdRange = config.getInt("product.id.range")
    val userIdRange = config.getInt("user.id.range")
}