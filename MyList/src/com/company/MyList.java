package com.company;

public class MyList
{
    class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }

        public int getValue(){
            return value;
        }

        public Node getNext(){
            return next;
        }

        public void setNext(Node next){
            this.next = next;
        }

        public String toString() {
            return Integer.toString(this.value);
        }

        public boolean hasNext(){
            return (this.next != null ? true : false); //тернарная операция
        }
    }

    Node begin;//указывает на 1 элемент
    long length;
}
