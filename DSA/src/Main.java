//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*LinkedList ll = new LinkedList(1);
        ll.append(5);
        ll.append(4);*/

        //ll.append(10);
        //ll.append(2);
        //ll.append(1);
       //ll.append(2);
       // ll.append(3);
        //ll.append(4);
        //ll.printList();
        //System.out.println("Removed last element: "+(ll.removelast()).value);
        //System.out.println("Removed last element: "+(ll.removelast()).value);
        //ll.prepend(0);
        //ll.printList();
        //ll.getHead();
        //ll.getTail();
        //ll.getLength();
        //System.out.println("Removed "+(ll.removeFirst()).value);
        //System.out.println("Removed "+(ll.removeFirst()).value);
        //ll.getHead();
        //ll.getTail();
        //ll.getLength();
        //ll.printList();
        //System.out.println((ll.get(1)).value);
        //System.out.println(ll.set(2,3));
        //System.out.println(ll.insert(2,3));
        //ll.getLength();
        //ll.printList();
        //System.out.println("Removed "+(ll.remove(2)) +" at index 2");
        //ll.getLength();
        //ll.printList();
        //ll.reverse();
        //System.out.println("Reversed");
        //ll.printList();
        //ll.partitionList(5);
        //ll.removeDuplicates();
        //ll.printList();
        //System.out.println("Binary to decimal: "+ll.binaryToDecimal());

        // ---------------
        // Convert 1011 to 11
        // ---------------
        /*LinkedList list1 = new LinkedList(1);
        list1.append(0);
        list1.append(1);
        list1.append(1);
        System.out.println("Convert 1011 to 11:");
        System.out.println("Input: 1 -> 0 -> 1 -> 1");
        System.out.println("Output: " + list1.binaryToDecimal());
        System.out.println("---------------");

        // ---------------
        // Convert 1100 to 12
        // ---------------
        LinkedList list2 = new LinkedList(1);
        list2.append(1);
        list2.append(0);
        list2.append(0);
        System.out.println("Convert 1100 to 12:");
        System.out.println("Input: 1 -> 1 -> 0 -> 0");
        System.out.println("Output: " + list2.binaryToDecimal());
        System.out.println("---------------");

        // ---------------
        // Convert 1 to 1
        // ---------------
        LinkedList list3 = new LinkedList(1);
        System.out.println("Convert 1 to 1:");
        System.out.println("Input: 1");
        System.out.println("Output: " + list3.binaryToDecimal());
        System.out.println("---------------");

        // ---------------
        // Convert empty list to 0
        // ---------------
        LinkedList list4 = new LinkedList(0);
        list4.makeEmpty();
        System.out.println("Convert empty list to 0:");
        System.out.println("Input: empty");
        System.out.println("Output: " + list4.binaryToDecimal());
        System.out.println("---------------");*/

        // Create a linked list with values 1, 2, 3, 4, and 5
        LinkedList myLinkedList = new LinkedList(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(4);
        myLinkedList.append(5);

        System.out.println("Original linked list: ");
        myLinkedList.printList();

        // Reverse a sublist within the linked list
        myLinkedList.reverseBetween(1, 3);
        System.out.println("\nReversed sublist (1, 3): ");
        myLinkedList.printList();
    }
}