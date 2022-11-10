package me.daewon.thesis.cqrsqueryservice.application.port.`in`

interface UpdateSensingDataViewUseCase {
    suspend fun updateView(command: SensingDataCommand.UpdateView)
}
