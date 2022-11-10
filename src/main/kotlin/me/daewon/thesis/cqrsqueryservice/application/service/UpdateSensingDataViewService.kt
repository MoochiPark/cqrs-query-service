package me.daewon.thesis.cqrsqueryservice.application.service

import me.daewon.thesis.cqrsqueryservice.application.port.`in`.SensingDataCommand
import me.daewon.thesis.cqrsqueryservice.application.port.`in`.UpdateSensingDataViewUseCase
import me.daewon.thesis.cqrsqueryservice.application.port.out.UpdateSensingDataViewPort
import org.springframework.stereotype.Service

@Service
class UpdateSensingDataViewService(
    private val updateViewPort: UpdateSensingDataViewPort,
) : UpdateSensingDataViewUseCase {
    override suspend fun updateView(command: SensingDataCommand.UpdateView) {
        updateViewPort.updateView(command.toDomain())
    }
}
