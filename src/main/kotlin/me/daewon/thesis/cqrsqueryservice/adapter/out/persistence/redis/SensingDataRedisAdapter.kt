package me.daewon.thesis.cqrsqueryservice.adapter.out.persistence.redis

import com.fasterxml.jackson.module.kotlin.readValue
import io.lettuce.core.ExperimentalLettuceCoroutinesApi
import io.lettuce.core.api.coroutines.RedisCoroutinesCommands
import me.daewon.thesis.cqrsqueryservice.application.port.out.FindSensingDataViewPort
import me.daewon.thesis.cqrsqueryservice.application.port.out.UpdateSensingDataViewPort
import me.daewon.thesis.cqrsqueryservice.config.mapper
import me.daewon.thesis.cqrsqueryservice.domain.SensingData
import org.springframework.stereotype.Component

@Component
@ExperimentalLettuceCoroutinesApi
class SensingDataRedisAdapter(
    private val redisApi: RedisCoroutinesCommands<String, String>,
) : UpdateSensingDataViewPort,
    FindSensingDataViewPort {
    override suspend fun updateView(sensingData: SensingData) {
        redisApi.rpush(
            sensingData.serialNumber,
            mapper.writeValueAsString(
                SensingDataValue.from(sensingData)
            )
        )
    }

    override suspend fun findLatestBySerialNumber(serialNumber: String): SensingData =
        redisApi.lindex(serialNumber, -1)
            ?.let {
                mapper.readValue<SensingDataValue>(it)
                    .toDomain(serialNumber)
            }
            ?: throw IllegalStateException("해당하는 센싱 데이터가 없습니다.")


    override suspend fun findAllBySerialNumber(serialNumber: String): List<SensingData> =
        redisApi.lrange(serialNumber, 0, -1)
            .map {
                mapper.readValue<SensingDataValue>(it)
                    .toDomain(serialNumber)
            }
}
