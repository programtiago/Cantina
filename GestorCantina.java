package Cantina;

import java.util.ArrayList;
import java.util.List;

public class GestorCantina {


    //Arraylist criado com cada prato do dia
    List<PratoDia> pratosCantina = new ArrayList<>();
    double valor_total;

    void init1() {
        String descricao0 = "Prato do dia"; // Prato dia - posicao 0
        double preco0 = 5.00;  // Diaria
        int unidades0 = 1; // 100un
        PratoDia prato0 = new PratoDia(descricao0, preco0, unidades0);
        pratosCantina.add(prato0);
    }

    void init2() {
        //Valores dados ás variáveis

        String descricao1 = "Prato de carne"; // Prato carne - posicao 1
        double preco1 = 5.00;
        int unidades1 = 1; //100un
        PratoDia prato1 = new PratoDia(descricao1, preco1, unidades1);
        pratosCantina.add(prato1);
        String descricao2 = "Prato de peixe"; // Prato peixe - posicao 2
        double preco2 = 6.00;
        int unidades2 = 1; //60un
        PratoDia prato2 = new PratoDia(descricao2, preco2, unidades2);
        pratosCantina.add(prato2);
        String descricao3 = "Prato de dieta"; // Prato dieta - posicao 3
        double preco3 = 4.00;
        int unidades3 = 40;
        PratoDia prato3 = new PratoDia(descricao3, preco3, unidades3);
        pratosCantina.add(prato3);
    }


    //Método que informa os pratos do dia
    void afixaPratos() {
        System.out.print("Cantina:\n");
        //Ciclo que permite ir informado o utilizador enquanto houver pratos disponiveis no array
        for (int i = 0; i < pratosCantina.size(); i++) {
            PratoDia prato = pratosCantina.get(i);
            if (prato.unidDisponiveis == 0)
                System.out.print(i + " " + prato.descricao + ": esgotado\n");
            else
                System.out.print(i + " " + prato.descricao + ": " + prato.preco + "\n");
        }
    }


    //Método responsável pelo fecho da cantina
    void fechoRefeicao() {
        double valorTotal=0;
        //percorre o array list de pratos da cantina
        for(PratoDia prato: pratosCantina) {

            //incrementação da variável valor total, através da operação das unidades vendidas multiplicando pelo preco dos prato vendidos ate ao momento
            valorTotal+=prato.unidVendidas*prato.preco;
            //dá reset às variáveis, ou seja volta tudo novamente ao ínicio
            prato.unidDisponiveis=prato.unidIniciais;
            prato.unidVendidas=0;
        }
        System.out.println("Foi recebido um total de "+valorTotal+" euros");

    }

    //inicializa o prato do dia, prato de carne, prato de peixe e prato de dieta
    public GestorCantina() {
        //metodo para inicializar as variáveis todas
        init1();
        init2();
    }

    //Método responsável que mostra o prato mais barato
    public PratoDia pratoMaisBarato() {

        PratoDia res=null;

        //percorre o array list
        for (PratoDia prato: pratosCantina) {
            //Começa na primeira posição do array
            if(res==null)
                res=prato;
            else
                //se o prpeco do prato no array for maior que o da primeira posicao então a variável res será o prato mais barato
                if(prato.preco > res.preco)
                    res=prato;
        }

        return res;
    }

    //método responsável pela compra de um prato
    public void comprarPrato(int pratoEscolhido, double valor) { // posicao 0
        //aqui equivale o prato ao prato escolhido pra saber que prato foi escolhido
        PratoDia prato = pratosCantina.get(pratoEscolhido);
        //retorno será igual à compra do prato com o valor passado em paramêtro
        int retorno = prato.compraPrato(valor);
        //switch com a variável retorno.
        switch(retorno) {
            case 0: System.out.println(prato.descricao+" ficou esgotado."); break;
            case -1: System.out.println("Pagamento insuficiente."); break;
            case -2: System.out.println("Selecionou um prato sem stock."); break;
            default:
                if(retorno>0)
                    System.out.println("Ainda tem "+retorno+" "+prato.descricao);
        }
    }

    public void atualizaPreco()
    {
        //declaracao de uma variavel prato para ir buscar o prato escolhido
        int prato = Menu.lerIntMsg("Diga qual o prato a alterar: 0-"+pratosCantina.get(0).descricao+
                " ; 1-"+pratosCantina.get(1).descricao+" ; 2-"+pratosCantina.get(2).descricao+
                " ; 3-"+pratosCantina.get(3).descricao);
        double novopreco = Menu.lerDoubleMsg("Diga o novo preco: ");
        //Vai buscar o prato escolhido e com o metodo set, atualiza o preço do prato escolhido
        pratosCantina.get(prato).setPreco(novopreco);

    }

}
