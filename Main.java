public class Main{

    public static void main(String[] args){
        //criando pilha com capacidade 3 e crescimento 2
        Pilha pilha = new PilhaArray(3,2); //capacidade, crescimento


        //add elementos

        System.out.println("Adicionando elementos: ");
        pilha.push("A");
        pilha.push("B");
        pilha.push("C");
      
        System.out.println(pilha.size());
        pilha.push("D");
        System.out.println(pilha.size());
        System.out.println( pilha.top());
        pilha.pop();
        pilha.pop();
        pilha.pop();
        pilha.pop();
        System.out.println(pilha.size());
        System.out.println( pilha.top());



    }
}