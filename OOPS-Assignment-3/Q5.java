
class LinkList {

    private class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public LinkList() {
        head = null;
    }

    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public int pop() {
        if (head == null) {
            return -1;
        } else if (head.next == null) {
            int data = head.data;
            head = null;
            return data;
        } else {
            Node temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            int data = temp.next.data;
            temp.next = null;
            return data;
        }
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) {
                System.out.print(" -> ");
            }
            temp = temp.next;
        }
    }

}

class Q5 {

    public static void main(String[] args) {
        LinkList list = new LinkList();
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);
        list.display();
        System.out.println();
        System.out.println("Popped element: " + list.pop());
        list.display();
    }
}
