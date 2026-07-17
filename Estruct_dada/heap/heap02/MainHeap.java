public class MainHeap {
    public static void main(String[] args) {
        Heap02 heap = new Heap02(10);

        heap.add(10);
        heap.add(5);
        heap.add(15);
        heap.add(3);
        heap.add(7);
        heap.add(18);

        System.out.println("Heap criado com sucesso!");
    }
    
}
