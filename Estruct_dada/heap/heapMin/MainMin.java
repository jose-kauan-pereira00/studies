public class MainMin {
    public static void main(String[] args) {
        HeapMin heap = new HeapMin(10);

        heap.add(5);
        heap.add(3);
        heap.add(8);
        heap.add(1);
        heap.add(6);

        heap.paraString();
        int[] array = {7, 2, 9, 4, 1, -1, -5, 0};
        heap = heap.builHeapMin(array);
        heap.paraString();
    }
    
}
