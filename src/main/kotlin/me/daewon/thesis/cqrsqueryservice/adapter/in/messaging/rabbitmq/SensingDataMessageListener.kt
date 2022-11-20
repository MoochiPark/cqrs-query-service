package me.daewon.thesis.cqrsqueryservice.adapter.`in`.messaging.rabbitmq

import com.fasterxml.jackson.module.kotlin.readValue
import java.util.concurrent.atomic.AtomicLong
import kotlin.system.measureTimeMillis
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import me.daewon.thesis.cqrsqueryservice.application.port.`in`.UpdateSensingDataViewUseCase
import me.daewon.thesis.cqrsqueryservice.config.mapper
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

private const val QUEUE: String = "cqrs-rabbitmq-queue"

@Component
class SensingDataMessageListener(
    private val updateViewUseCase: UpdateSensingDataViewUseCase,
) {

    @RabbitListener(queues = [QUEUE])
    fun listen(message: String) = runBlocking(Dispatchers.IO) {
        CoroutineScope(Dispatchers.IO).launch {
            updateViewUseCase
                .updateView(mapper.readValue(message))
        }
    }
}
