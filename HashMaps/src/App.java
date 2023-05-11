public class App {
    public static void main(String[] args) throws Exception {
        //Create Each Set
        HashSet<Integer> setA = new HashSet<Integer>();
        HashSet<Integer> setB = new HashSet<Integer>();
        HashSet<Integer> setC = new HashSet<Integer>();
        HashSet<Integer> setD = new HashSet<Integer>();
        //Add elements to each set
        setA.add(0);
        setA.add(1);
        setA.add(2);

        setB.add(2);
        setB.add(3);
        setB.add(4);

        setC.add(4);
        setC.add(5);
        setC.add(6);

        setD.add(6);
        setD.add(7);
        setD.add(8);

        //Find the union of setA and setB, 
        //storing the result in setA. 
        //Output the values to confirm it worked correctly.
        System.out.println("Original Set A: " + setA);
        setA.addAll(setB);
        System.out.print("Union of Set A and Set B: " + setA.toString() + "\n \n \n");
        //Find the set difference of the updated setA and setB, 
        //storing the new values in set A (in other words, setA becomes setA-setB). 
        //Output the values to confirm it worked correctly.
        setA.removeAll(setB);
        System.out.print("Set difference of Set A and Set B: " + setA.toString() + "\n \n \n");
        //Find the intersection of setC and setB, 
        //storing the result in setB.
        setB.retainAll(setC);
        System.out.print("Intersection of Set C and Set B: " + setB.toString() + "\n \n \n");


    }
}
