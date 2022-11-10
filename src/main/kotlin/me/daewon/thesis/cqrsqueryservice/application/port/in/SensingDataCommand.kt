package me.daewon.thesis.cqrsqueryservice.application.port.`in`

import java.time.LocalDateTime
import me.daewon.thesis.cqrsqueryservice.domain.SensingData

sealed interface SensingDataCommand {
    data class UpdateView(
        val id: String,
        val serialNumber: String,
        val data: String,
        val sensingTime: LocalDateTime,
    ) : SensingDataCommand {
        fun toDomain(): SensingData =
            SensingData(
                serialNumber = serialNumber,
                data = data,
                sensingTime = sensingTime
            )
    }
}
