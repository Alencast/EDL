import java.util.ArrayList;

public class Vetor {
    
    private ArrayList<Object> a = new ArrayList<>();
    

    public Object elemAtRank(int r){

        if(r < 0 || r > a.size()){
            throw new IndexOutOfBoundsException();
        }
        return a.get(r);
    }

    public Object replaceAtRank(int r, Object o){

        if(r < 0 || r > a.size()){
            throw new IndexOutOfBoundsException();
        }
        return a.set(r,o);
    }

    public void insertAtRank(int r, Object o){
        if(r < 0 || r > a.size()){
            throw new IndexOutOfBoundsException();
        }
        a.add(r, o);
    }

    public Object removeAtRank(int r){
        if(r < 0 || r > a.size()){            
            throw new IndexOutOfBoundsException();
        }
        
        return a.remove(r);
    }

    public int size(){

        return a.size();
    }

    public boolean isEmpty(){
        return a.isEmpty();
    }

}
