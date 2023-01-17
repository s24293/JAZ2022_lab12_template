package com.westeros.diagnostics.controllers;

import com.westeros.diagnostics.runners.IRunDiagnoses;
import com.westeros.diagnostics.service.contract.DiagnosticsResultsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("diagnostics")
@RequiredArgsConstructor
public class DiagnosticsController {

    @Value("${westeros.service.name}")
    private String serviceName;
    private final IRunDiagnoses diagnosticsRunner;

    @GetMapping
    public ResponseEntity<String> checkStatus(){
        return ResponseEntity.ok("ALIVE");
    }

    @GetMapping("check")
    public ResponseEntity<DiagnosticsResultsDto> checkDiagnostics(){
        var result = new DiagnosticsResultsDto();
        result.setServiceName(serviceName);
        result.setDiagnostics(diagnosticsRunner.runAll());
        return ResponseEntity.ok(result);
    }
}
