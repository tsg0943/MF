package com.company;

import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class MyList<T> implements Collection<T> { //наследуем класс коллекций

    class Node<T> {
        private T value;
        private Node next;

        public Node(T value) {
            this.value = value;
            this.next = null;
        }

        public T getValue(){
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getNext(){
            return next;
        }

        public void setNext(Node<T> next){
            this.next = next;
        }

        public boolean hasNext(){
            return (this.next != null ? true : false); //тернарная операция
        }
    }

    Node<T> begin;//указывает на 1 элемент
    long length;
    private Comparable comparable;

    public MyList(Comparable compare) {
        this.begin = null;
        this.length = 0;
        this.comparable = compare;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        if (this.begin == null) {
            this.begin = new Node(t); // заводим новый Нод
        }
        else {
            this.end().setNext(new Node(t));//Нод переходит в конец
        }
        this.length++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    public Node<T> end() {
        if (this.begin == null)
            return null;

        Node<T> iter = this.begin; //с помощью iter идем по ссылкам
        while (iter.hasNext()) {
            iter = iter.getNext();//возвращает ссылку
        }
        return iter;
    }

    public String tostring() {
        String result = "[ ";
        if (this.begin != null) {
            Node iter = this.begin;
            while (iter.hasNext()) {
                result += iter.getValue().toString() + ", ";
                iter = iter.getNext();
            }
            result += iter.getValue().toString() + " ";
        }
        result += "]";
        return result;
    }
    public void swap(int firstPost,int secondPost){
        Node<T> a = indexAt(firstPost -1);
        Node<T> b = indexAt(firstPost);
        Node<T> c = indexAt(firstPost +1);
        Node<T> d = indexAt(secondPost -1);
        Node<T> e = indexAt(secondPost);
        Node<T> f = indexAt(secondPost + 1);

        if ( a != null){
            a.setNext(e);
        }
        else{
            this.begin = e;
        }
        b.setNext(f);
        if(d == b){
            b.setNext(b);
        }
        else{
            e.setNext(c);
            d.setNext(b);
        }
    }


    public Node indexAt ( int index){ //Возвращает Ноду
        if ((index <= this.length - 1) & (index >= 0)) {
            Node p = this.begin;
            for (; index > 0; --index) {
                p = p.getNext();
            }
            System.out.println(p);
            return p;
        } else
            return null;
    }

    public void sort(){
        long count=this.length;
        int x;
        int y;
        Node temp1;
        Node temp2;
        while(count >0){
            x = 0;
            y = 1;
            temp1 = indexAt(x);
            temp2 = indexAt(y);
            while (y <count){
                if (this.comparable.compare(temp1, temp2)<0) {
                    if (this.comparable.compare(temp1,temp2)>0) {
                        continue;
                    }
                    ++x;
                    ++y;
                    temp1= temp1.getNext();
                    temp2 = temp2.getNext();
                } else {
                    swap(x,y);
                    x += 1;
                    y += 1;
                    temp1 = indexAt(x);
                    temp2 = indexAt(y);
                }
            }
            --count;
        }

    }
}

