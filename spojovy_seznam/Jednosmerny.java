/**
 * Created by mejty on 25.2.14.
 */


public class Jednosmerny<T> implements ListIface<T> {
    private Node first;
    private Node last;
    private int size;

    public Jednosmerny(){
        this.first=null;
        this.last=null;
        this.size=0;
    }
    public void add(T value){
        if(size==0){
            this.first=new Node(value);
            this.last=this.first;
            this.size++;
        }
        else{
            this.last.next=new Node(value);
            this.last=this.last.next;
            this.size++;
        }
    }

    public T get(int i) {
        if(i> this.size){throw new IndexOutOfBoundsException("Index je vetsi nex delka seznamu!");}
        if(i<0){throw new IllegalArgumentException("Index nemuze byt zaporne cislo.");}
        if(i==size){return(this.last.value); }

        Node actual=this.first;
        for (int j = 1; j < i; j++) {
            actual=actual.next;
        }
        return(actual.value);
    }
    public int getSize(){
        return (this.size);
    }

    public void remove(int i){
        if(i> this.size){throw new IndexOutOfBoundsException("Index je vetsi nex delka seznamu!");}
        if(i<0){throw new IllegalArgumentException("Index nemuze byt zaporne cislo.");}
        if(i==1){
            first=first.next;
        }else{
            Node actual=this.first;
            for (int j = 1; j < i-1; j++) {
                actual=actual.next;
            }
            actual.next=actual.next.next;
            if(i==size){
                last=actual;
            }
        }
        this.size--;
    }


    private class Node{
         private T value;
         private Node next;
         public Node(T value){
             this.value=value;
         }
     }
}
