public class Circulo extends Forma {
    
    private Double raio;

    public Circulo(Double praio) {
        this.raio = praio;
    }

    public Circulo() {
        raio = 0.0;
    }


    @Override
    public Double getArea(){
     return Math.PI * this.raio * this.raio;
    }

    public Double getRaio() {
        return raio;
    }

    public void setRaio(Double praio) {
        this.raio = praio;
    }

    
}
