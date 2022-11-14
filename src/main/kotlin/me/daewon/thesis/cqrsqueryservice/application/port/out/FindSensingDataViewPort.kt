package me.daewon.thesis.cqrsqueryservice.application.port.out

import me.daewon.thesis.cqrsqueryservice.domain.SensingData

interface FindSensingDataViewPort {
    suspend fun findLatestBySerialNumber(serialNumber: String): SensingData
    suspend fun findAllBySerialNumber(serialNumber: String): List<SensingData>

    suspend fun findLatestNBySerialNumber(serialNumber: String, count: Long): List<SensingData>
}
