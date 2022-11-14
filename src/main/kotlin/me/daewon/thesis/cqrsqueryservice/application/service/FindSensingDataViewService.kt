package me.daewon.thesis.cqrsqueryservice.application.service

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import me.daewon.thesis.cqrsqueryservice.application.port.`in`.FindSensingDataViewUseCase
import me.daewon.thesis.cqrsqueryservice.application.port.`in`.SensingDataCommand
import me.daewon.thesis.cqrsqueryservice.application.port.`in`.SensingDataResponse
import me.daewon.thesis.cqrsqueryservice.application.port.`in`.UpdateSensingDataViewUseCase
import me.daewon.thesis.cqrsqueryservice.application.port.out.FindSensingDataViewPort
import me.daewon.thesis.cqrsqueryservice.application.port.out.UpdateSensingDataViewPort
import org.springframework.stereotype.Service

@Service
class FindSensingDataViewService(
    private val findViewPort: FindSensingDataViewPort,
) : FindSensingDataViewUseCase {
    override suspend fun findLatestBySerialNumber(
        serialNumber: String,
    ): SensingDataResponse.Find = withContext(Dispatchers.IO) {
        SensingDataResponse.Find
            .from(findViewPort.findLatestBySerialNumber(serialNumber))
    }

    override suspend fun findAllBySerialNumber(
        serialNumber: String,
    ): List<SensingDataResponse.Find> = withContext(Dispatchers.IO) {
        findViewPort.findAllBySerialNumber(serialNumber)
            .map(SensingDataResponse.Find::from)
    }

    override suspend fun findLatestNBySerialNumber(
        serialNumber: String,
        count: Long,
    ): List<SensingDataResponse.Find> = withContext(Dispatchers.IO) {
        findViewPort.findLatestNBySerialNumber(serialNumber, count)
            .map(SensingDataResponse.Find::from)
    }
}
