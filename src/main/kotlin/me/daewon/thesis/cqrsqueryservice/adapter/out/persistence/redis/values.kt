package me.daewon.thesis.cqrsqueryservice.adapter.out.persistence.redis

import java.time.LocalDateTime
import me.daewon.thesis.cqrsqueryservice.domain.SensingData

data class SensingDataValue(
    val data: String,
    val sensingTime: LocalDateTime,
) {
    companion object {
        fun from(sensingData: SensingData) =
            SensingDataValue(
                data = sensingData.data,
                sensingTime = sensingData.sensingTime
            )
    }

    fun toDomain(serialNumber: String) =
        SensingData(
            serialNumber = serialNumber,
            data = data,
            sensingTime = sensingTime
        )
}
