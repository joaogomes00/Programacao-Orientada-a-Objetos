import java.util.Scanner;

public class TesterAluno {
    
    public static void main(String[] args) {
     
        Aluno aluno = new Aluno();

        Scanner teclado = new Scanner (System.in);

        System.out.printf("Digite sua nome: ");
        aluno.setNome( teclado.next() );
        
        System.out.printf("Digite sua matricula: ");
        aluno.setMatricula( teclado.next() );
        
        System.out.printf("Digite sua curso: ");
        aluno.setCurso( teclado.next() );

        aluno.Listar();

     teclado.close();
    }
}
