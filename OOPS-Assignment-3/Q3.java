
class ComplexNum {

    private double real;
    private double img;

    public ComplexNum(double real, double img) {
        this.real = real;
        this.img = img;
    }

    public ComplexNum() {
        this(0, 0);
    }

    public void display() {
        if (img < 0) {
            System.out.println(real + " - " + Math.abs(img) + "i");
        } else {
            System.out.println(real + " + " + img + "i");
        }
    }
}

class ComplexNumQueue {

    private ComplexNum[] queue;
    private int front;
    private int back;
    private int size;

    public ComplexNumQueue(int size) {
        this.size = size;
        queue = new ComplexNum[size];
        front = 0;
        back = -1;
    }

    private boolean isFull() {
        return back >= size - 1;
    }

    private boolean isEmpty() {
        return back < front;
    }

    public void enqueue(ComplexNum num) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        queue[++back] = num;
    }

    public ComplexNum dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        return queue[front++];
    }
}

class Q3 {

    public static void main(String[] args) {
        ComplexNumQueue queue = new ComplexNumQueue(5);
        queue.enqueue(new ComplexNum(1, 2));
        queue.enqueue(new ComplexNum(3, 4));
        queue.enqueue(new ComplexNum(5, 6));
        queue.enqueue(new ComplexNum(7, 8));
        queue.enqueue(new ComplexNum(9, 10));
        queue.enqueue(new ComplexNum(11, 12)); // full

        queue.dequeue().display();
        queue.dequeue().display();
        queue.dequeue().display();
        queue.dequeue().display();
        queue.dequeue().display(); // empty
        queue.dequeue().display(); // error return null
    }
}
