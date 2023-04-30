import edu.du.dudraw.DUDraw;

public class App {
    public static void main(String[] args) {
        DUDraw.enableDoubleBuffering();
        Maze m = new Maze(500, 500);
        m.generateMaze(79, 79);
        m.draw();
    }
}
