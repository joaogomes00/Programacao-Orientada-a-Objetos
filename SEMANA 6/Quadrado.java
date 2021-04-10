public class Quadrado extends Forma{
    
    private Double lado;

    public Quadrado(Double plado) {
        this.lado = plado;
    }

    public Quadrado() {
        lado = 0.0;
    }

    @Override
    public Double getArea(){
     return this.lado * this.lado;
    }

    public Double getLado() {
        return lado;
    }

    public void setLado(Double plado) {
        this.lado = plado;
    }


}
