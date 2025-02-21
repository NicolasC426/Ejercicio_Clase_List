package co.edu.uptc.Structures;

import java.util.ArrayList;
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
        if (isEmpty())
            return false;
        Node prev = null;
        Node current = head;
        while (current != null) {
            if (current.getData().equals(o)) {
                if (prev == null) {
                    head = current.getNext();
                } else {
                    prev.setNext(current.getNext());
                }
                return true;
            }
            prev = current;
            current = current.getNext();
        }
        return false;    
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> iterator = new Iterator<T>() {
            Node node = head;
            @Override
            public boolean hasNext() {
                return node != null;
            }
            @Override
            public T next() {
                T value = (T) node.getData();
                node = node.getNext();
                return value;
            }

        };
        return iterator;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size()];
        Node<T> temp = head;
        int aux = 0;

        while(temp != null){
            aux++;
            array[aux] = temp.getData();
            temp = temp.getNext();
        }
        return array;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        int size = size();
        Iterator<T> ite = (Iterator<T>) iterator();
        if (a.length < size) {
            a = (T[])new Object[size];
        }
        for (int i = 0 ; i < size; i++){
            a[i] = ite.next();
        }
        if (a.length > size){
            a[size] = null;
        }
        return a;
    }

   
    

    @Override
    public boolean containsAll(Collection<?> c) {
         for (Object element : c) {
            if (!this.contains(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        if(c==null||c.isEmpty()){
            return false;
        }
        for(T temp : c){
            add(temp);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
          if (isEmpty() == true || index < 0 || index > this.size() || c.isEmpty())
            return false;
        Node<T> auxhead = head;
        Node<T> prev = null;
        int nodePosition = 0;

        while (nodePosition < index) {
            prev = auxhead;
            auxhead = auxhead.getNext();
            nodePosition++;
        }
        Node<T> firstInsertNode = null;
        Node<T> lastInsertNode = null;

        for (T object : c) {
            Node<T> newNode = new Node<>(object);
            if (firstInsertNode == null) {
                firstInsertNode = newNode;
            } else {
                lastInsertNode.setNext(newNode);
            }
            lastInsertNode = newNode;
        }
        if (prev == null) {
            lastInsertNode.setNext(head);
            head = firstInsertNode;
        } else {
            prev.setNext(firstInsertNode);
            lastInsertNode.setNext(auxhead);
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean removed = false;
        Iterator<T> ite = iterator();
        while (ite.hasNext()) {
            if (c.contains(ite.next())) {
                ite.remove();
                removed = true;
            }
        } 
        return removed;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        Iterator<T> ite = iterator();
        while (ite.hasNext()) {
            if (!c.contains(ite.next())) {
                ite.remove();
                modified = true;
            }
        }
        return modified;
    }

    

    @Override
    public T get(int index) {
         if (index > this.size() || index < 0) {
            throw new IndexOutOfBoundsException(
                    "Digitizad index isn't valid for this : " + index + ", Size: " + this.size());
        }
        int count = 0;
        Node<T> aux = head;
        while (count < index) {
            aux = aux.getNext();
            count++;
        }
        return aux.getData();
    }

    @Override
    public T set(int index, T element) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        Node<T> current = head;
        for (int i = 0; i<index ; i++){
            current = current.getNext();
        }

        T data = current.getData();
        current.setData(element);
        return data;
    }

    

    @Override
    public int indexOf(Object o) {
       Node<T> indexNode = head;
        int position = 0;
        while (indexNode != null) {
            if (indexNode.getData().equals(o)) {
                return position;
            }
            indexNode = indexNode.getNext();
            position++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
       int index = 0;
        int lastIndex = -1;
        Node<T> current = head;
        while (current != null) {

            if (o == null) {
                if (current.getData() == null) {
                    lastIndex = index;
                }
            } else {
                if (o.equals(current.getData())) {
                    lastIndex = index;
                }
            }
            current = current.getNext();
            index++;
        }

        return lastIndex;
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
        if (fromIndex < 0 || toIndex > size() || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException("Indexes are out of range");
        }

        List<T> listReturn = new ArrayList<>();
        Node<T> nodeaux = head;
        int index = 0;

        while (index < fromIndex && nodeaux != null) {
            nodeaux = nodeaux.getNext();
            index++;
        }

        while (index < toIndex && nodeaux != null) {
            listReturn.add(nodeaux.getData());
            nodeaux = nodeaux.getNext();
            index++;
        }

        return listReturn;
    }
    
}
