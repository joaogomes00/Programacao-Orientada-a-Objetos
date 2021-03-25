public class BMW extends Carros {

    private int velocidade;

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int pvelocidade) {
        this.velocidade = pvelocidade;
    }

    public void imprimir(){
        System.out.printf("sua velocidade", this.velocidade);
    }
}
