import java.util.List;
import java.util.Scanner;

public final class UtilFormas {
    
   

    public static void  imprimir(List<Forma>formas){
        // percorrer 
        System.out.println("-----Área das Formas geométricas-----");
        for (Forma i : formas){

            if(i instanceof Circulo)
                System.out.println("Area do Circulo = " + i.getArea());

            else if(i instanceof Quadrado){
                System.out.println("Area do Quadrado = " + i.getArea());
            }
        }
    }

    public static void imprimir(Circulo circulo) {
        System.out.println("-----Circulo----- ");
        System.out.println("Área = " + circulo.getArea());
    }

    public static void imprimir(Quadrado quadrado) {
        System.out.println("-----Quadrado----- ");
        System.out.println("Área = " + quadrado.getArea());
    }

    public static void ler(Circulo circulo) {
        Double raio;
        Scanner in = new Scanner (System.in);
        System.out.println("Entre com o valor do raio: ");
        raio = in.nextDouble();

        circulo.setRaio(raio);
    }

    public static void ler(Quadrado quadrado) {
        Double lado;
        Scanner in = new Scanner (System.in);
        System.out.println("Entre com o valor do lado:");
        lado = in.nextDouble();

        quadrado.setLado(lado);

        in.close();
    }


}

