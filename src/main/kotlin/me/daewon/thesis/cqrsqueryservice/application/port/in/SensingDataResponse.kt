package me.daewon.thesis.cqrsqueryservice.application.port.`in`

import java.time.LocalDateTime
import me.daewon.thesis.cqrsqueryservice.domain.SensingData

sealed interface SensingDataResponse {
    data class Find(
        val serialNumber: String,
        val data: String,
        val sensingTime: LocalDateTime,
    ) : SensingDataResponse {
        companion object {
            fun from(sensingData: SensingData): Find =
                Find(
                    sensingData.serialNumber,
                    sensingData.data,
                    sensingData.sensingTime
                )
        }
    }
}
