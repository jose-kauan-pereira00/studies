public class Main {
    public static void main(String[] args) {
        Heap heap = new Heap(10);
        heap.add(5);
        heap.add(10);
        heap.add(3);
        heap.add(8);
        heap.add(15);
        heap.add(1);
        heap.add(12);
        System.out.println(heap.remove()); // Output: 15
        System.out.println(heap.remove()); // Output: 12
    }
}