package br.com.fintech.main;


import br.com.fintech.model.CarteiraDigital;
import br.com.fintech.model.GatewayPagamentos;
import br.com.fintech.model.LimiteTransacoesExcedidoException;
import br.com.fintech.model.Transacao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Main {
    public static void main (String[] args){
      Transacao t1 = new Transacao("TX-101-BR", "PIX", 500.00, 2.50);
      Transacao t2 = new Transacao("TX-102-BR", "CARTAO", 1200.00, 36.00);
      Transacao t3 = new Transacao("TX-103-BR", "PIX", 350.00, 1.75);
      Transacao t4 = new Transacao("TX-104-BR", "BOLETO", 800.00, 4.50);

        System.out.println(t1);
        System.out.println(t4);

        CarteiraDigital carteira = new CarteiraDigital("WALLET-CORP-01", 3, new ArrayList<>());

        GatewayPagamentos gateway = new GatewayPagamentos();

        gateway.cadastrarCarteira(carteira);
        System.out.println("Carteira cadastrada com sucesso!");
        try {
            carteira.adicionarTransacao(t1);
            carteira.adicionarTransacao(t2);
            carteira.adicionarTransacao(t3);

            //perigoso ein cuidado animal
            carteira.adicionarTransacao(t4);
        } catch (LimiteTransacoesExcedidoException e) {
            System.out.println("ERRO: " + e.getMessage());
        }

        Optional<CarteiraDigital> carteiraBuscada = gateway.buscarCarteira("WALLET-CORP-01");

        if(carteiraBuscada.isPresent()){
            CarteiraDigital encontrada = carteiraBuscada.get();
            System.out.println("\n--- RESULTADO DA BUSCA ---");
            System.out.println("Carteira encontrada: " + encontrada.getCodigoCarteira());
        } else {
            System.out.println("Achei nada");
        }

        System.out.println("Tarifal total da carteira: " + carteira.calcularTarifaTotal());

        System.out.println("Transacoes PIX: " + carteira.contarPorTipo("PIX"));

        Set<Transacao> set = new HashSet<>();

        Transacao t1dupe = new Transacao("TX-101-BR", "PIX", 500.00, 2.50);

        set.add(t1);
        set.add(t1dupe);
        set.add(t2);

        //se printar 2 é pq ele n considera a dupe ent ta otimo ta ligado
        System.out.println("Tamanho do HashSet: " + set.size());

        try{
            new Transacao("", "PIX", 100.00, 1.00);
        } catch (IllegalArgumentException exc){
            System.out.println("Construtor validado: ID de transacao nao pode ser nulo ou vazio");
        }
    }
}
