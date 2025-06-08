package com.example.demo.domain

import java.time.LocalDateTime

data class KafkaMessage(
    val product_id: Int,
    val user_id: Int,
    val timestamp: String
)