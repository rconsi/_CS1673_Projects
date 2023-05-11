package edu.du.considine;
public class App {
    public static void main(String[] args) throws Exception {
        BinaryTree<Integer> tree = new BinaryTree<Integer>();
        Position<Integer> root = tree.addRoot(5);
        Position<Integer> left = tree.addLeft(root, 10);
        Position<Integer> leftOfLeft = tree.addLeft(left, 15);
        Position<Integer> right = tree.addRight(root,8);
        Position<Integer> leftOfRight = tree.addLeft(right, 9);
        Position<Integer> rightOfRight = tree.addRight(right, 12);
        tree.addLeft(leftOfLeft, 20);
        tree.printTree();
        //Output the values of the ancestors of a node
        Position<Integer> temp = rightOfRight;
        while ( temp  != null ){
            System.out.println( temp.getValue() );
            temp = tree.getParent(temp);
        }
    }
}
