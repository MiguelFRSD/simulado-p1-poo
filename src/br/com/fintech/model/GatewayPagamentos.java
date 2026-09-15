package br.com.fintech.model;

import java.util.*;

public class GatewayPagamentos {
    private Map<String, CarteiraDigital> carteiras = new HashMap<>();

    public GatewayPagamentos(){

    }

    public void cadastrarCarteira(CarteiraDigital carteira){
        //a chave é o codigo string, o valor é a propria carteira
        //o que a gente faz é guardar a carteira que chegou no parâmetro
        //ai no map carteiras, a gente put o codigo e a carteira
        carteiras.put(carteira.getCodigoCarteira(), carteira);
    }

    public Optional<CarteiraDigital> buscarCarteira(String codigoCarteira){
        //a gente busca a carteira no Map com o get(codigoCarteira)
        //aí faz meio que se fosse um try catch e envelopa ele no ofNullable
        //se der erro ele retorna um null mas não lança uma exception e arruina o programa
        return Optional.ofNullable(carteiras.get(codigoCarteira));
    }
}
