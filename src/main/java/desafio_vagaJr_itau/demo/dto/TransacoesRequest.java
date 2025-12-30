package desafio_vagaJr_itau.demo.dto;

import java.time.OffsetDateTime;
import jakarta.validation.constraints.NotNull;

public class TransacoesRequest {
    @NotNull
    private Double valor;

    @NotNull
    private OffsetDateTime dataHora;

    public TransacoesRequest() {
    }

    public double getValor() {
        return valor;
    }

    public OffsetDateTime getDataHora() {
        return dataHora;
    }

}
