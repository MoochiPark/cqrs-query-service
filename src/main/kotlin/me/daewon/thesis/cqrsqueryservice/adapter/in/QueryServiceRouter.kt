package me.daewon.thesis.cqrsqueryservice.adapter.`in`

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType.TEXT_PLAIN
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class QueryServiceRouter(
    private val sensingDataQueryHandler: SensingDataQueryHandler,
) {
    @Bean
    fun queryRoutes() =
        coRouter {
            "/api".nest {
                accept(TEXT_PLAIN).nest {
                    "/sensing-data".nest {
                        GET(
                            "/{serialNumber}",
                            sensingDataQueryHandler::findAllBySerialNumber
                        )
                        GET(
                            "/{serialNumber}/latest",
                            sensingDataQueryHandler::findLatestBySerialNumber
                        )
                    }
                }
            }
        }
}
