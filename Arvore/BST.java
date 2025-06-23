import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class BST { 
    
    public class No { 
        private No pai;
        private No filhoEsquerdo;
        private No filhoDireito;
        private Object value;
        
        public No(No pai, Object value) { 
            this.pai = pai;
            this.value = value;
            this.filhoEsquerdo = null;
            this.filhoDireito = null;
        }
        
        public No getPai() { 
            return pai;
        } 
        public No getFilhoEsquerdo() { 
            return filhoEsquerdo;
        }
        public No getFilhoDireito() { 
            return filhoDireito;
        }
        public Object getValue() { 
            return value;
        } 
        
        public void setPai(No pai) { 
            this.pai = pai;
        }
        public void setFilhoEsquerdo(No filhoEsquerdo) {
            this.filhoEsquerdo = filhoEsquerdo;
        }
        public void setFilhoDireito(No filhoDireito) { 
            this.filhoDireito = filhoDireito;
        }
        public void setValue(Object value) { 
            this.value = value;
        }
    }
    
    private No raiz;
    private int tamanho;
    
    public BST(Object value) { 
        this.raiz = new No(null, value);
        this.tamanho = 1;
    }
    
    public int size() { 
        return tamanho;
    }
    
    public boolean isEmpty() { 
        return tamanho == 0;
    } 
    
    public int height(No v) { 
       if(v == null) { 
           return 0;
       }
       
       int alturaEsquerda = height(v.getFilhoEsquerdo());
       int alturaDireita = height(v.getFilhoDireito());
       
       return 1 + Math.max(alturaEsquerda, alturaDireita);
    }
    
      public void insert(Object value) {
        if (raiz == null) {
            raiz = new No(null, value);
            tamanho++;
            return;
        }

        No no_atual = raiz;
        No pai = null;

        while (no_atual != null) {
            pai = no_atual;
            int cmp = ((Comparable) value).compareTo(no_atual.getValue());
            
            if (cmp < 0) {
                no_atual = no_atual.getFilhoEsquerdo();
            } else { // cmp > 0 (valores iguais não existem)
                no_atual = no_atual.getFilhoDireito();
            }
        }

        // Insere o novo nó como filho do 'pai'
        No novoNo = new No(pai, value);
        int cmpFinal = ((Comparable) value).compareTo(pai.getValue());
        
        if (cmpFinal < 0) {
            pai.setFilhoEsquerdo(novoNo);
        } else {
            pai.setFilhoDireito(novoNo);
        }
        
        tamanho++;
}
    
    public int depth(No v) { 
       if(v == null) { 
           return -1;
       } 
       
       int profundidade = 0;
       
       while(v != raiz) { 
           v = v.getPai();
           profundidade++;
       }
       return profundidade;
    }
    
    public No root() { 
       return raiz;
    }
    
    public No parent(No v) { 
       return v.getPai();
    }
    
    public boolean hasLeft(No v) { 
       return v.getFilhoEsquerdo() != null;
    }
    
    public boolean hasRight(No v) { 
       return v.getFilhoDireito() != null;
    }
    
    public Object replace(No v, Object o) { 
        Object replaced = v.getValue();
        v.setValue(o);
        return replaced;
    }
    
    public No addRoot(Object o) { 
        raiz = new No(null, o);
        tamanho = 1;
        return raiz;
    }
    
    public Object remove(No v) { 
        if(v == null) { 
            throw new IllegalArgumentException("Nó nulo");
        }

        if(v.getPai() == null && v != raiz) { 
            throw new IllegalArgumentException("Nó não pertence à árvore");
        }
        
        Object removed = v.getValue();
        
        // Caso 1: Nó é folha (sem filhos)
        if(isExternal(v)) {
            if(v == raiz) { 
                raiz = null; //Árvore vazia
                tamanho = 0; 
            }
            else { 
                No pai = v.getPai();
                if(pai.getFilhoEsquerdo() == v) { 
                    pai.setFilhoEsquerdo(null);
                }
                else { 
                    pai.setFilhoDireito(null);
                }
            }
        }
        // Caso 2: Nó tem apenas um filho
        else if(v.getFilhoEsquerdo() == null ^ v.getFilhoDireito() == null) {
            No filho = (v.getFilhoEsquerdo() != null) ? v.getFilhoEsquerdo() : v.getFilhoDireito();
        
            if(v == raiz) { 
                raiz = filho;
                filho.setPai(null);
            }
            else {
                No pai = v.getPai();
                if(pai.getFilhoEsquerdo() == v) { 
                    pai.setFilhoEsquerdo(filho);
                }
                else { 
                    pai.setFilhoDireito(filho);
                }
                filho.setPai(pai);
            }
        }
        // Caso 3: Nó tem dois filhos
        else { 
            No sucessor = v.getFilhoDireito();
            while(sucessor.getFilhoEsquerdo() != null) { 
                sucessor = sucessor.getFilhoEsquerdo();
            }
            
            remove(sucessor);
            v.setValue(sucessor.getValue());
            return removed;
        }
        
        tamanho--;
        return removed;
    }
    
    public Iterator<Object> elementsPreOrdem() { 
        List<Object> elementos = new ArrayList<>();
        preOrdemRecursivo(raiz, elementos);
        return elementos.iterator();
    }
    
    private void preOrdemRecursivo(No no, List<Object> resultado) { 
        if(no != null) { 
            resultado.add(no.getValue());
            preOrdemRecursivo(no.getFilhoEsquerdo(), resultado);
            preOrdemRecursivo(no.getFilhoDireito(), resultado);
        }
    }
    
    public Iterator<Object> elementsInOrdem() { 
        List<Object> elementos = new ArrayList<>();
        inOrdemRecursivo(raiz, elementos);
        return elementos.iterator();
    }
    
    public void inOrdemRecursivo(No no, List<Object> resultado) { 
        if(no != null) { 
            inOrdemRecursivo(no.getFilhoEsquerdo(), resultado);
            resultado.add(no.getValue());
            inOrdemRecursivo(no.getFilhoDireito(), resultado);
        }
    }
    
    public Iterator<Object> elementsPosOrdem() { 
        List<Object> elements = new ArrayList<>();
        posOrdemRecursivo(raiz, elements);
        return elements.iterator();
    }
    
    public void posOrdemRecursivo(No no, List<Object> resultado) { 
        if(no != null) { 
            posOrdemRecursivo(no.getFilhoEsquerdo(), resultado);
            posOrdemRecursivo(no.getFilhoDireito(), resultado);
            resultado.add(no.getValue());
        }
    }
    
    public Iterator<No> nos() { 
        List<No> listaNos = new ArrayList<>();
        preOrdemNos(raiz, listaNos);
        return listaNos.iterator();
    }
    
    public void preOrdemNos(No no, List<No> resultado) { 
        if(no != null) { 
            resultado.add(no);
            preOrdemNos(no.getFilhoEsquerdo(), resultado);
            preOrdemNos(no.getFilhoDireito(), resultado);
        }
    }
    
    public No search(Object value) {
        No atual = raiz;
        while (atual != null) {
            int cmp = ((Comparable)value).compareTo(atual.getValue());
            if (cmp == 0) return atual;
            else if (cmp < 0) atual = atual.getFilhoEsquerdo();
            else atual = atual.getFilhoDireito();
        }
        return null;
    }
    
    private boolean isExternal(No v) {
        return v.getFilhoEsquerdo() == null && v.getFilhoDireito() == null;
    }
}
