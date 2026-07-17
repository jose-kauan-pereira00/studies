public class Main01 {
    public static void main(String[] args) {
        Bst01 bst = new Bst01();
        bst.add(10);
        bst.add(5);
        bst.add(15);
        bst.add(3);
        bst.add(7);
        bst.add(12);
        bst.add(17);
        bst.add(1);
        bst.add(4);
        bst.add(6);
        bst.add(-5);


        System.out.println("\nNumber of nodes with values less than 4: " + bst.contaMenores(4));

    }
    
}
