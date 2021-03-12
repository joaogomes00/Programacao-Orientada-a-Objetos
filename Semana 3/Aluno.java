public class Aluno{

    private String matricula;
    private String nome;
    private String curso;

 
    public void setMatricula(String pmatricula) {
        this.matricula = pmatricula;
    }

    public void setNome(String pnome) {
        this.nome = pnome;
    }

    public void setCurso(String pcurso) {
        this.curso = pcurso;

        if (curso.equalsIgnoreCase("si") ){/*ignora o case sensitive*/
            this.curso = "Sistemas de informação";
        }
      
    }


    public void Listar(){
        System.out.println( toString() );
    }

    @Override
    public String toString() {
        return "Aluno [curso =" + curso + ", matricula =" + matricula + ", nome =" + nome + "]";
    }


}