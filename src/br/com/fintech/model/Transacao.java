package br.com.fintech.model;

public class Transacao {
    private String idTransacao;
    private String tipo;
    private double valor;
    private double tarifa;

    public Transacao(String idTransacao, String tipo, double valor, double tarifa){
        if(idTransacao == null || idTransacao.trim().isEmpty()){
            //ao colocar no topo do construtor, é impossível criar um objeto transacao
            //no sistema com id invalido. e sem setter ele se torna imutavel.
            throw new IllegalArgumentException("ID de transacao nao pode ser nulo ou vazio");
        }

        this.idTransacao = idTransacao;
        this.tipo = tipo;
        this.valor = valor;
        this.tarifa = tarifa;
    }

    public String getIdTransacao() {
        return idTransacao;
    }

    public String getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    @Override
    public String toString(){
        return "Transacao[ " +
                "id = " + idTransacao + '\'' +
                ", tipo = " + tipo +
                ", valor = " + valor +
                ", tarifa = " + tarifa +
                ']';
    }


}
