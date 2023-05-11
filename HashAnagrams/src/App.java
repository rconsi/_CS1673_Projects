public class App {
    public static void main(String[] args) throws Exception {
        Anagram myAnagram = new Anagram();
        myAnagram.initialize("Dictionary.txt");
        myAnagram.maxAnagram();
    }
}
