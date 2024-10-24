package com.example.demo.controller

import com.example.demo.response.JsendResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class JsendController {

    @GetMapping("/success")
    fun success(): ResponseEntity<JsendResponse> {
        return ResponseEntity.ok(
            JsendResponse.success(
                data = "Datos completos",
                message = "Operación exitosa"
            )
        )
    }

    @GetMapping("/fail")
    fun fail(): ResponseEntity<JsendResponse> {
        return ResponseEntity.badRequest().body(
            JsendResponse.fail(
                data = "Datos incompletos",
                message = "Hubo un problema con la solicitud"
            )
        )
    }

    @GetMapping("/error")
    fun error(): ResponseEntity<JsendResponse> {
        return ResponseEntity.status(500).body(
            JsendResponse.error(
                message = "Error en el servidor",
                code = 500
            )
        )
    }
}
