import java.util.HashSet;
import java.util.Set;
public class LinkedList {

    Node head;
    Node tail;
    int length = 0;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value) {
        Node node = new Node(value);
        this.head = node;
        this.tail = node;
        this.length = 1;
    }

    public void append(int value) {
        Node node = new Node(value);
        if (this.length == 0) {
            this.head = node;
            this.tail = node;
            this.length = 1;
        } else {
            this.tail.next = node;
            this.tail = node;
            length++;
        }

    }

    public void makeEmpty() {
        head = null;
        length = 0;
    }
    public boolean set(int index, int value) {
        /*Node temp = this.head;
        if(index<0 || index >= length) return false;
        for(int i =0;i<index;i++){
            temp = temp.next;
        }
        temp.value= value;
        return true;*/

        Node temp = get(index);
        if (temp == null) return false;
        temp.value = value;
        return true;
    }

    public boolean insert(int index, int value) {

        Node newNode = new Node(value);
        Node temp = this.head;
        Node pre = null;
        //if(index<0 || index >= length) return false;
        if (index == 0) {
            prepend(value);
            return true;
        } else if (index == length) {
            append(value);
            return true;
        }
        //if(length==0) System.out.println("incorrect index"); return false;
        Node node = get(index - 1);
        newNode.next = node.next;
        node.next = newNode;
        length++;
        /*for(int i =0;i<index;i++){
            pre=temp;
            temp = temp.next;
        }
        pre.next = newNode;
        newNode.next = temp;*/
        return true;
    }

    public Node remove(int index) {
        Node removeNode = null;
        if (index < 0 || index >= length) return null;
        if (index == 0) return removeFirst();
        if (index == length - 1) return removelast();

        Node preNode = get(index - 1);
        removeNode = preNode.next; //get(index);
        preNode.next = removeNode.next;
        removeNode.next = null;
        length--;
        return removeNode;
    }

    public void reverse(){
/*        Node tempHead = this.head;
        Node tempTail = this.tail;
        for(int i=length-1;i>=0;i--) {
            System.out.println("Reverse :"+tempTail.value);
            tempTail.next=get(i-1);
            tempTail = tempTail.next;
            //System.out.println(tempTail);
        }*/

        /*Node temp = head;
        head = tail;
        tail = temp;

        Node after = temp.next;
        Node before = null;

        for(int i =0;i<length;i++){
            after = temp.next;
            temp.next=before;
            before=temp;
            temp=after;

        }*/



        Node prev = null;
        Node current = head;

        while(current!=null){
            Node next = current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        head = prev;

    }
    public Node removelast() {
        Node temp = this.head;
        Node pre = this.head;

        if (length == 0) return null;

        if (length == 1) {
            this.head = null;
            this.tail = null;
            length--;
        } else {
            while (temp.next != null) {
                pre = temp;
                temp = temp.next;
                //System.out.println("***"+pre.value);
            }
            this.tail = pre;
            this.tail.next = null;
            length--;
            /*Node node = head;
            for (int i = 0; i < length - 1; i++) {
                //System.out.println(i+"******"+node.value);
                this.tail = node;
                node = node.next;
            }
            //System.out.println("Tail ******"+tail.value);
            this.tail.next = null;*/
        }
        return temp;
    }

    public void prepend(int value) {
        Node node = new Node(value);
        if (length == 0) {
            this.head = node;
            this.tail = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
        length++;
    }

    public Node get(int index) {

        Node node = this.head;
        if (index < 0 || index >= length) return null;
            //else if (length == 0) return null;
        else {
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        }
    }

    public Node removeFirst() {
        Node oldHeadNode = this.head;
        if (length == 0) return null;
        Node newHeadNode = oldHeadNode.next;
        this.head = newHeadNode;
        oldHeadNode.next = null;
        length--;
        if (length == 0) this.tail = null;
        return oldHeadNode;
    }

    public void printList() {
        Node temp = this.head;
        while (temp != null) {
            System.out.println("List element :" + temp.value);
            temp = temp.next;
        }
    }

    public void getHead() {
        if (this.head == null) {
            System.out.println(this.head);
        } else System.out.println(this.head.value);

    }

    public void getTail() {
        if (this.tail == null) {
            System.out.println(this.tail);
        } else System.out.println(this.tail.value);

    }

    public void getLength() {
        System.out.println("Length :" + this.length);
    }


    public void partitionList(int x){
        Node dummy1 = new Node(0);
        Node dummy2 = new Node(0);
        Node prev1 = dummy1;
        Node prev2 = dummy2;
        Node current = head;

        while(current != null){
            if(current.value<x){
                prev1.next=current;
                prev1=current;

            }else{
                prev2.next=current;
                prev2=current;
            }
            current=current.next;
        }
        prev2.next=null;
        prev1.next=dummy2.next;
        head=dummy1.next;

    }

    public void removeDuplicates() {

        Set<Integer> visited = new HashSet<>();
        Node current = head;
        Node prev=head;
        if(current==null) return;
        while(current!=null){
            if(visited.contains(current.value)){
                prev.next=current.next;

            }else{
                visited.add(current.value);
                prev=current;
            }
            current = current.next;
        }

    }

    public int binaryToDecimal(){

        if (length < 1) return 0;
        Node current = head;
        /*int start = length-1;
        int decimal = 0;
        while (current!=null){
            decimal = decimal + ( (current.value) * (int) (Math.pow(2,start)));
            current = current.next;
            start--;
        }*/

        int num = 0;

         while(current!=null){
             num = (num * 2) + current.value;
             current = current.next;
         }
        return num;
    }

    public void reverseBetween(int m, int n) {
        Node splice1=head;
        Node previous = null;
        Node current = null;
        Node next = null;
        Node Splice = null;
        Node start = null;

        for(int i=0;i<length;i++){
            if(i<m){

                start = splice1;
                current=splice1;
                splice1 = splice1.next;
            }
            if(i>=m && i<n){

                next=current.next;
                current.next=previous;
                previous=current;
                current=next;
            }
            if(i==n){
                splice1.next=previous;
                start.next=current;
            }
        }


    }
}
