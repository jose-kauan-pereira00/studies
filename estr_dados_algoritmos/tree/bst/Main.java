public class Main {

    public static void main(String[] args) {
        TreeBinary tree = new TreeBinary();
        tree.add(10);
        tree.add(5);
        tree.add(15); 
        tree.add(3);
        tree.add(7);  

        System.out.println("Minimum value in the tree: " + tree.min().value);
        System.out.println("Maximum value in the tree: " + tree.max().value);

        System.out.println("Is the tree empty? " + tree.isEmpty());
        System.out.println(tree.search(7) != null ? "Value 7 found in the tree." : "Value 7 not found in the tree.");
        System.out.println(tree.search(20) != null ? "Value 20 found in the tree." : "Value 20 not found in the tree.");
        System.out.println(tree.search(5) != null ? "Value 5 found in the tree." : "Value 5 not found in the tree.");
        System.out.println(tree.search(15) != null ? "Value 15 found in the tree." : "Value 15 not found in the tree.");
        System.out.println(tree.search(10) != null ? "Value 10 found in the tree." : "Value 10 not found in the tree.");

        
    }

}
