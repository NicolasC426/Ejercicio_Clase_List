package co.edu.uptc.Structures;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyList<T> implements List<T> {

    private Node<T> head;
     
    public MyList(){
        head = null;
    }

    @Override
    public int size() {
        int size = 0;
        Node aux = head;
        while(aux != null){
            size++;
            aux = aux.getNext();
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (head==null);
    }

    @Override
    public boolean contains(Object o) {
        T object = (T)o;
        Node<T> aux = head;
        while(aux != null){
            if(aux.getData()==object)
            return true;
            aux = aux.getNext();
        }
        return false;
    }

    @Override
    public boolean add(T e) {
        if(this.isEmpty()){
            head = new Node<T>(e);
        }else{
            Node<T> aux = head;
            while(aux.getNext() != null){
                aux = aux.getNext();
            }
            aux.setNext(new Node<T>(e));
        }
        return true;
    }

    @Override
    public void clear() {
        head = null;
    }

    @Override
    public void add(int index, T element) {
        if(index<0 || index> size()){
            throw new IndexOutOfBoundsException();
        }
        else{
            Node<T> aux = new Node<T>(element);
            if(index == 0){
                aux.setNext(head);
                head = aux;
            }
            else{
                Node<T> temp = head;
                for (int i = 0; i < index-1; i++) {
                    temp = temp.getNext();
                }
                Node<T> aux2 = temp.getNext();
                temp.setNext(new Node<T>(element));
                temp.getNext().setNext(aux2);;
            }
        }
    }

    @Override
    public T remove(int index) {
        T t = null;
        if(index<0 || index> size()){
            return t;
        }
        else{
            if(index == 0){
                t = head.getData();
                head = head.getNext();
            }
            else{
                Node<T> temp = head;
                for (int i = 0; i < index-1; i++) {
                    temp = temp.getNext();
                }
                t = temp.getNext().getData();
                temp.setNext(temp.getNext().getNext());
            }
        }
        return t;
    }

    @Override
    public boolean remove(Object o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }

    @Override
    public Object[] toArray() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toArray'");
    }

    @Override
    public <T> T[] toArray(T[] a) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toArray'");
    }

   
    

    @Override
    public boolean containsAll(Collection<?> c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'containsAll'");
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addAll'");
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addAll'");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeAll'");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'retainAll'");
    }

    

    @Override
    public T get(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public T set(int index, T element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'set'");
    }

    

    @Override
    public int indexOf(Object o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'indexOf'");
    }

    @Override
    public int lastIndexOf(Object o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'lastIndexOf'");
    }

    @Override
    public ListIterator<T> listIterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listIterator'");
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listIterator'");
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'subList'");
    }
    
}
