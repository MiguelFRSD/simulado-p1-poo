package br.com.fintech.model;

import java.util.Objects;

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
    public boolean equals(Object o) {
        //verifica se é exatamente o mesmo objeto na memória
        if(this == o) return true;
        //verifica se o objeto recebido é nulo ou de outra classe, sendo o objeto
        if(!(o instanceof Transacao)) return false;
        //agora com instanceof, verifica se o é uma transacao, senao false.
        Transacao outraTransacao = (Transacao) o;
        //comparar IDs de forma segura
        //pq ja foi validado q nunca pode ser nulo
        return Objects.equals(this.idTransacao, outraTransacao.idTransacao);
        //ai da pra ver ne, compara equals, se esse idTransacao é igual da outra tlgd
        //hashSet não se põe no bagui, é meio que um ocasional.
    }

    @Override
    public int hashCode(){
        //o Objects.hash pega o idTransacao e faz a matematica automaticamente
        //gerando um numero inteiro baseado no texto do ID
        //basicamente sobrescrevemos o hashCode pra ele dar hashcodes baseados no idTransacao
        return Objects.hash(idTransacao);
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
