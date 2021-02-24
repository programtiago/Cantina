package Cantina;


public class Main {
    public static void main(String[] args) {

        GestorCantina gest = new GestorCantina();

        int opcao;

        do {
            gest.afixaPratos();
            System.out.println("4 - Fecho refeicao");
            System.out.println("5 - Alterar Preco");
            System.out.println("6 - sair");
            opcao=Menu.lerIntMsg("Escolha uma opção: ");
            switch (opcao)
            {
                case 0:
                case 1:
                case 2:
                case 3 :
                    double valor = Menu.lerDoubleMsg("Qual o valor do pagamento?");
                    gest.comprarPrato(opcao, valor);
                    break;
                case 4 :
                    gest.fechoRefeicao();
                    break;
                case 5 :

                    //Será assim feito esta parte ??? Falta passar por parametro o valor

                    //int pratoescolhido = Menu.lerIntMsg("Qual o prato que seja atualizar ?");
                    gest.atualizaPreco();
                    break;
                default:
                    System.out.println("Opção inválida !!!");
                    System.exit(0);
                    break;
            }
        }while (opcao != 6);
    }
}
