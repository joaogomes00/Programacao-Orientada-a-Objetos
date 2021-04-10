import java.util.ArrayList;
import java.util.List;



public class Programa {
    
    public static void main(String[] args) {
   
       
        Quadrado quadrado = new Quadrado();
        Circulo circulo = new Circulo();
        


        UtilFormas.ler(circulo);
        UtilFormas.ler(quadrado);


        // lista
        List<Forma> formas = new ArrayList<>();

        formas.add(circulo);
        formas.add(quadrado);

        // percorrer a lista 
       UtilFormas.imprimir(formas);
       UtilFormas.imprimir(circulo);
       UtilFormas.imprimir(quadrado);

    }

}
