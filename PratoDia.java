package Cantina;

public class PratoDia {

    public String descricao;
    public double preco;
    int unidIniciais;
    int unidDisponiveis;
    int unidVendidas;

    //Construtor da classe
    public PratoDia(String descricao, double preco, int unidIniciais) {
        this.descricao = descricao;
        this.preco = preco;
        this.unidIniciais = unidIniciais;
        this.unidDisponiveis = unidIniciais;
        this.unidVendidas = 0;
    }

    //Painel com a informação do prato do dia
    public String toString()
    {
        return descricao + ": " + preco;
    }

    //método para fazer a comprar de um prato do dia com condições impostas. Recebe pagamento como parâmetro
    //pagamento --> valor dado pra pagar o prato

    public int compraPrato(double pagamento) {
        // Retorno da funcao inteiro
        // 0 significa falta de stock
        // -1 significa quantidade de dinheiro insuficiente
        // -2 significa que tentou comprar um prato que ja nao tinha stock

        // se o valor for menor que o preço então não é possível efetuar a compra
        if(pagamento<preco)
            return -1;

        // se as unidades disponíveis forem maior que 0 então decrementa as unidades disponiveis e incrementa as unidades vendidas
        if(unidDisponiveis>0) {
            unidDisponiveis--;
            unidVendidas++;
            return unidDisponiveis;
        } else {
            return -2;
        }
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    public int getUnidDisponiveis() {
        return unidDisponiveis;
    }

    public int getUnidVendidas() {
        return unidVendidas;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setUnidDisponiveis(int unidDisponiveis) {
        this.unidDisponiveis = unidDisponiveis;
    }

    public void setUnidVendidas(int unidVendidas) {
        this.unidVendidas = unidVendidas;
    }
}
