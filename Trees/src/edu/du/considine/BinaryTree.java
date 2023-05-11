package edu.du.considine;
/**
 * Created by Ryan on 5/9/2023
 * Binary Tree
 *      This is a tree structure where each node has 
 *          at most two children nodes
 */
public class BinaryTree<T>{
    //Create a private node class
    private Node myRoot;
    private int size;
    public BinaryTree(){
        this.myRoot = null;
        this.size = 0;
    }
    public int size(){
        return this.size;
    }
    public void printTree(){
        if (myRoot == null){
            return;
        }
        printTree(myRoot, 0);
    }
    private void printTree(Node n, int depth){
        if(n != null){
            String indent = "   ";
            for (int i = 0; i < depth; i++){
                System.out.print( indent );
            }
            System.out.println( n.getValue() );
            printTree(n.getLeftChild(), depth + 1);
            printTree(n.getRightChild(), depth + 1);
        }
    }
    public String toString(){
        return toString( myRoot );
    }
    private String toString(Node n){
        String treeString = "";
        if (n != null){
            treeString += "[" + n.getValue() + " ";
            treeString += toString( n.getLeftChild() );
            treeString += toString( n.getRightChild() ) + "]";
        }
        return treeString;
    }
    public boolean isEmpty(){
        return this.size == 0;
    }
    public Position<T> addRoot(T val){
        if (myRoot != null){
            throw new IllegalStateException("BinaryTree: addRoot was called when a root already exists");
        }
        this.myRoot = new Node(val, null,null,null);
        this.size++;
        return this.myRoot;
    }
    public Position<T> getRoot(){
        return this.myRoot;
    }
    //Checks if the position p exists, if it does it returns the position p as a node
    public Node validatePosition(Position<T> p){
        if(p == null){
            throw new IllegalStateException("BinaryTree: Position is null and not valid");
        }
        else if (!(p instanceof BinaryTree.Node)){
            throw new IllegalStateException("BinaryTree: Position is not an instance of a BinaryTree");
        }
        return (Node) p;
    }
    //Addleft adds a value to the left child of a position
    public Position<T> addLeft(Position<T> parent, T value){
        Node p = validatePosition(parent);
        if (p.getLeftChild() != null){
            throw new IllegalStateException("BinaryTree: Addleft called when left child already exists");
        }
        p.setLeftChild(new Node(value,p,null,null));
        this.size++;
        return p.getLeftChild();
    }
    //addRight adds a value to the right child of a position
    public Position<T> addRight(Position<T> parent, T value){
        Node p = validatePosition(parent);
        if (p.getRightChild() != null){
            throw new IllegalStateException("BinaryTree: Addright called when right child already exists");
        }
        p.setRightChild(new Node(value,p,null,null));
        this.size++;
        return p.getRightChild();
    }
    //Adds a value to the top of the tree
    public void addToTop(T value){
        if(myRoot == null){
            this.myRoot = new Node(value);
        }
        else if(myRoot.getLeftChild() == null){
            myRoot.setLeftChild(new Node(value));
        }
        else if(myRoot.getRightChild() == null){
            myRoot.setRightChild(new Node(value));
        }
        else{
            Node theNode = new Node(value, null, myRoot, null);
            myRoot.setParent(theNode);
            myRoot = theNode;
        }
        size++;
    }
    public Position<T> getParent(Position<T> location){
        Node n = validatePosition(location);
        return n.getParent();
    }
    

    private class Node implements Position<T>{
        //Node constructor
        T myValue;

        Node parent;
        Node leftChild;
        Node rightChild;
        
        public Node(T value){
            this(value, null, null, null);
        }

        public Node(T value, Node prnt){
            this(value, prnt, null, null);
        }

        public Node(T value, Node prnt, Node lChild, Node rChild){
            this.parent = prnt;
            this.myValue = value;
            this.leftChild = lChild;
            this.rightChild = rChild;
        }
        //Getter Methods
        public T getValue(){
            return this.myValue;
        }
        public Node getParent(){
            return this.parent;
        }
        public Node getLeftChild(){
            return this.leftChild;
        }
        public Node getRightChild(){
            return this.rightChild;
        }
        //Setter Methods
        public void setParent(Node parent){
            this.parent = parent;
        }
        public void setLeftChild(Node leftChild){
            this.leftChild = leftChild;
        }
        public void setRightChild(Node rightChild){
            this.rightChild = rightChild;
        }
        public void setValue(T value){
            this.myValue = value;
        }
        public String toString(){
            return this.myValue.toString();
        }
    }
}
