public class TestePilha{

    public static void main(String[] args){

        long inicio = System.currentTimeMillis();
        //criando pilha com capacidade 10 e crescimento 10
        Pilha pilha = new PilhaArray(10,0); //capacidade, crescimento

        for(int i = 0; i < 1000000; i++){

            pilha.push(i);
        }

        long fim = System.currentTimeMillis();
        long tempo = (fim - inicio);
        System.out.println(tempo);
        




    }
}