package ads.lesson1;

public class Main {
    public static void main(String[] args) {
MyStack<Integer> stack = new MyStack<>();
        stack.add(2);
        stack.add(3);
        stack.add(4);
        stack.add(5);
        stack.add(6);
        stack.add(7);
        stack.add(8);
        stack.add(9);
        stack.add(10);
        stack.add(11);
        stack.add(12);
        System.out.println(stack.pop());
        System.out.println(stack.size());
        MyQueue<Integer> queue = new MyQueue<>(10);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        queue.offer(6);
        queue.offer(7);
        queue.offer(8);
        queue.offer(9);
        queue.offer(10);
        System.out.println(queue.toString());
    }
}
