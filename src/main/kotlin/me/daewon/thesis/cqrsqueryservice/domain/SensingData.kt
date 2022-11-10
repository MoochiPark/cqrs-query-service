package me.daewon.thesis.cqrsqueryservice.domain

import java.time.LocalDateTime

data class SensingData(
    val serialNumber: String,
    val data: String,
    val sensingTime: LocalDateTime,
)
