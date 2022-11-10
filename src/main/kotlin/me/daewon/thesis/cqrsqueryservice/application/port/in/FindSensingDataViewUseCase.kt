package me.daewon.thesis.cqrsqueryservice.application.port.`in`

interface FindSensingDataViewUseCase {
    suspend fun findLatestBySerialNumber(
        serialNumber: String,
    ): SensingDataResponse.Find

    suspend fun findAllBySerialNumber(
        serialNumber: String,
    ): List<SensingDataResponse.Find>
}
