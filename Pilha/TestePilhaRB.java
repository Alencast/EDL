import java.util.Scanner;


public class TestePilhaRB {

   public static void main(String[] args){

    Scanner sc = new Scanner(System.in);

    PilhaRubroNegra PRB = new PilhaRubroNegra(4, 0);

    System.out.println("Valor do TV: " + PRB.TopoVermelho);
    System.out.println("Valor do TP: " + PRB.TopoPreto);
    
    for(int i = 0; i < 5; i++){
        PRB.pushVermelho(sc.next());
    }
    
    System.out.println("Valor novo do TV: " + PRB.TopoVermelho);
    System.out.println("Valor novo do TP: " + PRB.TopoPreto);
    
    for(int i = 0; i < 5; i++){
        PRB.pushPreto(sc.next());
    }
    
    System.out.println("Valor novo do TV: " + PRB.TopoVermelho);
    System.out.println("Valor novo do TP: " + PRB.TopoPreto);
    

    System.out.println("Estado final do array:");
for (int i = 0; i < 4; i++) {
    System.out.println("a[" + i + "] = " + PRB.a[i]);
}

    Object top = PRB.top();
    System.out.println(top);
    sc.close();
    
   }

    
}
