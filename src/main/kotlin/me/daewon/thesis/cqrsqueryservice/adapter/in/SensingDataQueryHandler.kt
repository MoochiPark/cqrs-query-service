package me.daewon.thesis.cqrsqueryservice.adapter.`in`

import me.daewon.thesis.cqrsqueryservice.application.port.`in`.FindSensingDataViewUseCase
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.bodyValueAndAwait

@Component
class SensingDataQueryHandler(
    private val findViewUseCase: FindSensingDataViewUseCase,
) {
    suspend fun findLatestBySerialNumber(request: ServerRequest): ServerResponse =
        ok().bodyValueAndAwait(
            findViewUseCase
                .findLatestBySerialNumber(
                    request.pathVariable("serialNumber")
                )
        )

    suspend fun findAllBySerialNumber(request: ServerRequest): ServerResponse =
        ok().bodyValueAndAwait(
            findViewUseCase
                .findAllBySerialNumber(
                    request.pathVariable("serialNumber")
                )
        )
}
