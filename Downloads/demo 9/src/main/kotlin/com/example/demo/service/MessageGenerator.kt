package com.example.demo.service

import com.example.demo.config.AppConfig
import com.example.demo.domain.KafkaMessage
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class MessageGenerator {
    private val random = Random()
    private val dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

    fun generate(): KafkaMessage {
        return KafkaMessage(
            product_id = random.nextInt(AppConfig.productIdRange) + 1,
            user_id = random.nextInt(AppConfig.userIdRange) + 1,
            timestamp = LocalDateTime.now().format(dateFormatter)
        )
    }
}