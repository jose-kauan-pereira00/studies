public class MainBst {
    public static void main(String[] args) {
        BST0 bst = new BST0();

        bst.add(10);
        bst.add(5);
        bst.add(15);
        bst.add(3);
        bst.add(7);
        bst.add(18);

        System.out.println("Contagem de menores que 10: " + bst.contaMenores(10));
        System.out.println("Contagem de maiores que 10: " + bst.contaMaiores(10));
    }
    
}
