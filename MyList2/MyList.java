package com.company;

public class MyList {

    class Node {
        private int value;
        private Node next;

        public Node(int value) { //объявляем параметр, также как и переменную
            this.value = value;// присваем значения параметра переменной
            this.next = null; //пустоту переменной
        }

        public int getValue(){
            return value;
        }//возвращаем

        public Node getNext(){
            return next;
        }

        public void setNext(Node next){
            this.next = next;
        } //присваиваем

        public String toString() {
            return Integer.toString(this.value);
        } //метод стринг преобразует число в строку

        public boolean hasNext(){
            return (this.next != null ? true : false); //тернарная операция
        } //проверяет последний элемент или нет
    }

    Node begin;//указывает на 1(экзаемпляр класса Node - begin) элемент
    long length; //объявляем переменную long с названием lenght

    public MyList() {
        this.begin = null;
        this.length = 0;
    }

    public void add(int value) { //метод add добавляет элемент
        if (this.begin == null) {
            this.begin = new Node(value);
        }
        else {
            this.end().setNext(new Node(value));//?
        }
        this.length++;
    }

    public Node end() { //описываем конец
        if (this.begin == null)
            return null;

        Node iter = this.begin; //с помощью iter идем по ссылкам
        while (iter.hasNext()) { //пока есть последний элемент
            iter = iter.getNext();//возвращает ссылку
        }
        return iter;
    }

    public String toString() {
        String result = "[ ";
        if (this.begin != null) {
            Node iter = this.begin;
            while (iter.hasNext()) {
                result += iter.toString() + ", ";
                iter = iter.getNext();
            }
            result += iter.toString() + " ";
        }
        result += "]";
        return result;
    }
}
