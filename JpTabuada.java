
/*
*Nome: João Pedro Gomes de Lemos
*Matrícula: 0050016060
*/ 



import java.util.Scanner;

class JpTabuada {


	public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        System.out.printf("Digite seu nome: ");
        String nome = input.next();

        System.out.printf("Seu nome: %s \n",nome);
        
        /*
        int mat = 16060;
        System.out.println("Digite sua matrícula:");
        System.out.printf("Matrícula: %d",mat);
        */

        System.out.printf("\nOlá, %s, entre com um número:",nome);
        int num = input.nextInt();

        System.out.printf("\nTabuada de somar do: %d",num);

        for(int i=0;i<=10;i++){
            System.out.printf("\n %d + %d = %d",num,i,num+i);
        }

    }
}