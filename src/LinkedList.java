public class LinkedList {
    private Node head = new Node();
    private Node tail = new Node();

    public LinkedList() {
        head.next = tail;
        tail.prev = head;
    }
    public void printAll() {
        Node currentElement = head.next;
        while ((currentElement) != null) {
            System.out.print(currentElement.value + " ");
            currentElement = currentElement.next;
        }
        System.out.println();
    }

    public void reverse(){
        Node temp = head;
        head = tail;
        tail = temp;
        Node current = head;

        while(current != null){
            temp = current.next;
            current.next = current.prev;
            current.prev = temp;
            current = current.next;
        }
    }
    public void add(String value) {
        Node node = new Node();
        node.value = value;
        Node lastNode = tail.prev;
        lastNode.next = node;
        node.prev = lastNode;
        tail.prev = node;
    }

    public static class Node {
        private Node prev;
        private String value;
        private Node next;
    }
}
