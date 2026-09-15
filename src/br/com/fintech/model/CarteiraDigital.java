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

    public void adicionarTransacao(Transacao transacao) throws LimiteTransacoesExcedidoException {
        //.size() pq é uma List e só fazer if transacoes >= da erro
        if(transacoes.size() >= capacidadeMaximaTransacoes){
            throw new LimiteTransacoesExcedidoException("Transacao '" + transacao.getIdTransacao() + "' vai além do limite de " + capacidadeMaximaTransacoes + " transacoes.");
        }

        transacoes.add(transacao);
    }

    public double calcularTarifaTotal() {
        //aqui a gente pega a lista Transacao e transformou na stream de dados
        return transacoes.stream()
                //aqui ele pega cada objeto Transacao e extrai o double valor da Tarifa
                .mapToDouble(Transacao::getTarifa)
                //aí aqui ja sabe ne, soma tudo pae
                .sum();
    }

    public long contarPorTipo(String tipo){
        //pegamos todas as transacoes dnv
        return transacoes.stream()
                //aqui a gente filtra, pega cada transacao e pergunta
                //voce e igual o tipo que a gente ta procurano?
                //se true fica, senao tchau
                //IMPORTANTE: o bagui do t -> é uma expressão lambda
                //é basicamente dizer, dado um item t(Transacao) faz essa pergunta
                .filter(t -> t.getTipo().equalsIgnoreCase(tipo))
                //e aqui ele conta tudo, e se for um numero mt grande ele ja retorna um long
                .count();
    }
}
