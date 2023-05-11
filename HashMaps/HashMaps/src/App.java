public class App {
    public static void main(String[] args) throws Exception {
        System.out.println( 0 % 20);
        int[] x = {41, 28, 11, 82, 40, 75, 21, 0,  90, 52, 96, 70, 83, 98, 1, 43, 4, 85, 79, 87};
        int size = x.length;
        
        for (int i = 0; i < size; i++){
            int mul = (x[i] * 13) + 5;
            int mulTwo = mul % 23;
            int value = mulTwo % size;
            System.out.println("Number: " + x[i] + " Belongs in Bucket : " + value );
        }

    }
}
