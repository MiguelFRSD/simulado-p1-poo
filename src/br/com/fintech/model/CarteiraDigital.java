package br.com.fintech.model;

import java.util.ArrayList;
import java.util.List;

public class CarteiraDigital {
    private String codigoCarteira;
    private int capacidadeMaximaTransacoes;
    private List<Transacao> transacoes = new ArrayList<>();

    public CarteiraDigital(String codigoCarteira, int capacidadeMaximaTransacoes, List<Transacao> transacoes) {
        this.codigoCarteira = codigoCarteira;
        this.capacidadeMaximaTransacoes = capacidadeMaximaTransacoes;
        this.transacoes = transacoes;
    }

    public String getCodigoCarteira() {
        return codigoCarteira;
    }

    public int getCapacidadeMaximaTransacoes() {
        return capacidadeMaximaTransacoes;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public void adicionarTransacao(Transacao transacao) throws LimiteTransacoesExcedidoException{

    }

    public double calcularTarifaTotal(){
        return
    }

    public long contarPorTipo(String tipo){
        return
    }
}
