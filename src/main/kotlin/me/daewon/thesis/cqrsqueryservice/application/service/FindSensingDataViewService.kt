package me.daewon.thesis.cqrsqueryservice.application.service

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
    ): SensingDataResponse.Find =
        SensingDataResponse.Find
            .from(findViewPort.findLatestBySerialNumber(serialNumber))

    override suspend fun findAllBySerialNumber(
        serialNumber: String,
    ): List<SensingDataResponse.Find> =
        findViewPort.findAllBySerialNumber(serialNumber)
            .map(SensingDataResponse.Find::from)
}
