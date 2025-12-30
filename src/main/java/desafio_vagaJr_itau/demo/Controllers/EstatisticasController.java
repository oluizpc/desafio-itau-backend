package desafio_vagaJr_itau.demo.Controllers;

import java.util.DoubleSummaryStatistics;

import javax.swing.text.html.parser.Entity;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import desafio_vagaJr_itau.demo.Services.TransacaoService;
import desafio_vagaJr_itau.demo.dto.EstatiscasResponse;

@RestController
@RequestMapping("/estatisticas")
public class EstatisticasController {
    private final TransacaoService transacaoService;

    
    public EstatisticasController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    @GetMapping
    public ResponseEntity<EstatiscasResponse> getEstatisticas() {
        DoubleSummaryStatistics stats = transacaoService.getEstatisticas();
        return ResponseEntity.ok(new EstatiscasResponse(stats));
    }
}
