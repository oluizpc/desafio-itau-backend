package desafio_vagaJr_itau.demo.Services;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.springframework.stereotype.Service;
import desafio_vagaJr_itau.demo.Models.Transacao;

@Service
public class TransacaoService {

    private final Queue<Transacao> transacoes = new ConcurrentLinkedQueue<>();

    public void addTransacao(Transacao transacao) { 
        transacoes.add(transacao);
    }  


    public void limparTransacoes() {
        transacoes.clear();
    }


    public DoubleSummaryStatistics getEstatisticas() {
        OffsetDateTime now = OffsetDateTime.now();
        return transacoes.stream()
                //.filter(tempo -> tempo.getDataHora().isAfter(now.minusSeconds(60)))
                .mapToDouble(Transacao::getValor)
                .summaryStatistics();   
    }
}