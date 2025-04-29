public class PilhaLinkedList {

    

        public class No{
            int valor;
            No next;
    
            No(int valor){
                this.valor = valor;
        }
    }
    
        private No tail;
    
        public void push(int valor){
    
            No novo = new No(valor);
            tail.next = novo;
            tail = novo; // [10] → [20] → [30] → topo

            // novo.next = tail;
            // tail = novo; topo → [10] → [20] → [30] → null
    
            
        }
        
        
    
    
    
}
// class No {
//     int valor;
//     No next;
//     No prev;
    
//     public No(int valor) {
//         this.valor = valor;
//         this.next = null;
//         this.prev = null;
//     }
// }

// class Pilha {
//     No topo;
//     No tail;
    
//     public Pilha() {
//         topo = null;
//         tail = null;
//     }
    
//   
//     public void push(int valor) {
//         No novo = new No(valor);
        
//         if (tail == null) { // vazia
//             topo = novo;
//             tail = novo;
//         } else {
//             tail.next = novo;  
//             novo.prev = tail;  
//             tail = novo;       
//         }
//     }