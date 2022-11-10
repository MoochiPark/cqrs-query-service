package me.daewon.thesis.cqrsqueryservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CqrsQueryServiceApplication

fun main(args: Array<String>) {
    runApplication<CqrsQueryServiceApplication>(*args)
}
