import java.util.Scanner; //importa a classe PrintStream
import java.util.Arrays; //manipular arrays
import java.io.PrintStream;

enum Operacao {
  ADICAO("adição", "+"){ 
    @Override //sobrescreve o metodo
    public double executar(double a, double b){
      return a+b;
    }
  },
  SUBTRACAO("subtração", "-") {
    @Override
    public double executar(double a, double b){
      return a-b;
    }
  }, 
  MULTIPLICACAO("multiplicação", "*"){
    @Override
    public double executar(double a, double b){
      return a*b;
    }
  },
  DIVISAO("divisão", "/"){
    @Override
    public double executar(double a, double b){
      return a/b;
    }
  };

    final String nome;
    final String operador;

    private Operacao(String nome, String operador){ //construtor
      this.nome = nome; 
      this.operador = operador;
    }

  static String[] operadores() {
    
    Operacao[] operacoes = values(); //retorna um array com todos os valores do enum
    
      int qtd = operacoes.length; //quantidade de operacoes
      String[] operadores = new String[qtd]; //cria um array com a quantidade de operacoes
    
        for (int i = 0; i < qtd; i++){
          operadores[i] = operacoes[i].operador; //preenche o array com os operadores
        }
    return operadores;
  }
  static Operacao porOperador(String operador){
    for (Operacao op : values()){
      if (op.operador.equals(operador)){
        return op;
      }
    }
    return null;
  }
  public abstract double executar(double a, double b);
}

  class Calculadora {

  private static final PrintStream saida = System.out; //cria uma constante para printar o texto
  private static final Scanner entrada = new Scanner(System.in); //cria uma constante para ler o texto

  public static void main(String[] args) { //cria o método 

    try { //tenta executar o código
      
      Calculadora progr = new Calculadora(); //cria uma instância da classe Calculadora p manipular exceções (erros) que podem ocorrer durante a execução de um bloco de código
      progr.executar(); //executa o método p lidar com a exceção
      
    } catch (Throwable t) { //armazena na variável t
      
      t.printStackTrace(); //imprime a mensagem de erro
  }
}

  private void executar(){
    Operacao op = null;
      while(op == null){
        saida.print("Digite a operação desejada: " + Arrays.toString(Operacao.operadores()) + ": "); 
        String operador = entrada.nextLine();
        op = Operacao.porOperador(operador);
          if(op == null){
            saida.println("Operação inválida!");
          }
      }
    saida.println("Digite o primeiro número: ");
    double n1 =Double.parseDouble(entrada.nextLine()); //converte o texto para double
    
    saida.println("Digite o segundo número: ");
    double n2 =Double.parseDouble(entrada.nextLine()); 

    double resultado = op.executar(n1, n2);
    saida.println("Resultado da" + op.nome + "é : " + resultado);
  }
}