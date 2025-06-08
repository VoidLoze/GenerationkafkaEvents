package com.example.demo.service

import com.example.demo.config.AppConfig
import com.example.demo.domain.KafkaMessage
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord
import java.util.*

class KafkaProducerService {
    private val producer: KafkaProducer<String, String>
    private val objectMapper = jacksonObjectMapper()

    init {
        val props = Properties().apply {
            put("bootstrap.servers", AppConfig.kafkaBootstrapServers)
            put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
            put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
            put("acks", "all")
        }
        producer = KafkaProducer(props)
    }

    fun send(message: KafkaMessage) {
        try {
            val jsonMessage = objectMapper.writeValueAsString(message)
            val record = ProducerRecord(AppConfig.kafkaTopic, null, jsonMessage)
            producer.send(record)
            println("Sent message: $jsonMessage")
        } catch (e: Exception) {
            println("Error sending message: ${e.message}")
        }
    }

    fun close() {
        producer.close()
    }
}