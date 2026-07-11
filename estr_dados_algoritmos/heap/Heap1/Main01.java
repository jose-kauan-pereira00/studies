public class Main01 {
    public static void main(String[] args) {
        heap01 heap = new heap01(10);
        heap.add(5);
        heap.add(3);
        heap.add(8);
        heap.add(1);
        heap.add(6);
        System.out.println("Heap elements after adding: ");
        heap.paraTexto();

        System.out.println("Removing elements from the heap: ");
        System.out.println("Removed: " + heap.remove());
        System.out.println("Heap elements after removing: ");
        heap.paraTexto();
    }
}