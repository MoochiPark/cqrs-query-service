package me.daewon.thesis.cqrsqueryservice.application.port.out

import me.daewon.thesis.cqrsqueryservice.domain.SensingData

interface UpdateSensingDataViewPort {
    suspend fun updateView(sensingData: SensingData)
}
