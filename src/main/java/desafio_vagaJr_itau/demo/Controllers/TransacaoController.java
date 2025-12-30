package desafio_vagaJr_itau.demo.Controllers;

import java.time.OffsetDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import desafio_vagaJr_itau.demo.Models.Transacao;
import desafio_vagaJr_itau.demo.Services.TransacaoService;
import desafio_vagaJr_itau.demo.dto.TransacoesRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    private final TransacaoService transacaoService;

    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    @PostMapping
    public ResponseEntity<Void> criarTransacao(@Valid @RequestBody TransacoesRequest request) {
        // Lógica para adicionar uma transação
        if (request.getDataHora().isAfter(OffsetDateTime.now()) || request.getValor() <= 0 ) {
            return ResponseEntity.unprocessableEntity().build();
    }
    transacaoService.addTransacao(new Transacao(request.getValor(), request.getDataHora()));
    return ResponseEntity.status(HttpStatus.CREATED).build();   
    }

    @DeleteMapping  
    public ResponseEntity<Void> limparTransacoes() {
        transacaoService.limparTransacoes();
        return ResponseEntity.ok().build();
    }

}
