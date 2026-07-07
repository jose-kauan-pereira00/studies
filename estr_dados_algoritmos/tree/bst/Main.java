public class Main {

    public static void main(String[] args) {
        BST bst = new BST();

        bst.add(10);
        bst.add(5);
        bst.add(15);
        bst.add(3);
        bst.add(7);
        bst.add(12);
        bst.add(18);

        System.out.println("BST created successfully!");


        bst.recursiveAdd(20);
        bst.recursiveAdd(2);
        bst.recursiveAdd(8);
        bst.recursiveAdd(13);
        bst.search(0);
        bst.search(10);
        System.out.println(bst.search(10) != null ? "Value 10 found in BST." : "Value 10 not found in BST.");
        System.out.println(bst.search(20) != null ? "Value 20 found in BST." : "Value 20 not found in BST.");
        System.out.println(bst.search(5) != null ? "Value 5 found in BST." : "Value 5 not found in BST.");
    
        System.out.println("BST operations completed successfully!");
        
        System.out.println("Height of the BST: " + bst.altura());


        System.out.println("Maximum value in the BST: " + (bst.max() != null ? bst.max().value : "BST is empty."));

        System.out.println("Minimum value in the BST: " + (bst.mim() != null ? bst.mim().value : "BST is empty."));

        System.out.println("Size of the BST: " + bst.size());

        System.out.println("Pre-order traversal of the BST:");
        bst.preOrder();
    }


    

}
