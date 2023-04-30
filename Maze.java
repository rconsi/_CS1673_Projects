
    import java.util.ArrayList;
    import java.util.Collections;
    import java.util.List;
    import java.util.Random;

    import edu.du.dudraw.DUDraw;

    public class Maze {
        enum CellValue{WALL, OPEN, EXPLORED}
        private class Cell{
            int row;
            int col;
            //CellValue value;
            public Cell(int row, int col){
                this.row = row;
                this.col = col;
                //this.value = CellValue.WALL;
            }
        }
        //Private variables for Maze properties
        private CellValue[][] mazeDimensions;
        private int width;
        private int height;
        public Maze(int wid, int ht){
            //initialize height and width values
            this.width = wid;
            this.height = ht;
            mazeDimensions = new CellValue[height][width];
            //Initialize each of the values in the maze to WALL type
            for (int row = 0; row < height; row++){
                for(int col = 0; col < width; col++){
                    mazeDimensions[row][col] = CellValue.WALL;
                }
            }
        }
        public void draw(){
            //Intialize canvas
            DUDraw.setCanvasSize(width, height);
            DUDraw.setScale(0, height);
            //intialize cellwidth and cellheight values
            double cellWidth = DUDraw.getCanvasWidth() / width;
            double cellHeight = DUDraw.getCanvasHeight() / height;
            //for each loop to loop through each row in the mazeDimensions
            for (int row = 0; row < height; row++){
                for (int col = 0; col < width; col++){

                    double x = col * cellWidth;
                    double y = (height - row - 1) * cellHeight;

                    if(mazeDimensions[row][col] == CellValue.WALL){
                        DUDraw.setPenColor(DUDraw.BLACK);
                        //DUDraw.filledRectangle(x, y, cellWidth, cellHeight);
                    } else if (mazeDimensions[row][col] == CellValue.OPEN){
                        DUDraw.setPenColor(DUDraw.WHITE);
                        //DUDraw.filledRectangle(x, y, cellWidth, cellHeight);
                    } else if (mazeDimensions[row][col] == CellValue.EXPLORED){
                        DUDraw.setPenColor(DUDraw.GREEN);
                        //DUDraw.filledRectangle(x, y, cellWidth, cellHeight);
                    }
                    DUDraw.filledRectangle(x + cellWidth/2, y + cellHeight/2, cellWidth/2, cellHeight/2);
                }
            }
            DUDraw.show();
        }
        public void generateMaze(int x_start, int y_start){
            //Check if start points are odd
            if (x_start % 2 == 0 || y_start % 2 == 0){
                throw new IllegalArgumentException("Starting position must have odd coordinates! ");
            }
            Stack<Cell> cellStack = new DLLStack<>();
            Cell startCell = new Cell(x_start,y_start);
            setCellValue(startCell, CellValue.OPEN);

            cellStack.push(startCell);
            while(!cellStack.isEmpty()){
                Cell currentCell = cellStack.pop();
                List<Cell> neighbors = getNeighbors(currentCell);
                if(!neighbors.isEmpty()){
                    cellStack.push(currentCell);
                    Random rand = new Random();
                    Cell randNeighbor = neighbors.get(rand.nextInt(neighbors.size()));
                    removeWall(currentCell, randNeighbor);
                    setCellValue(randNeighbor, CellValue.OPEN);
                    cellStack.push(randNeighbor);
                }
            }
        }
            private List<Cell> getNeighbors(Cell cell){
                ArrayList<Cell> neighbors = new ArrayList<>();
                int row = cell.row;
                int col = cell.col;
                if((row  - 2 >= 0) && (mazeDimensions[row - 2][col] == CellValue.WALL)){
                    neighbors.add(new Cell( row - 2 ,col ));
                    setCellValue(row - 1, col, CellValue.OPEN);
                }
                if((row  + 2 < height) && (mazeDimensions[row + 2][col] == CellValue.WALL)){
                    neighbors.add(new Cell( row + 2 ,col ));
                    setCellValue(row + 1, col, CellValue.OPEN);
                }
                if((col - 2 >= 0) && (mazeDimensions[row][col - 2] == CellValue.WALL)){
                    neighbors.add(new Cell( row ,col - 2 ));
                    setCellValue(row, col - 2, CellValue.OPEN);
                }
                if((col + 2 < width) && (mazeDimensions[row][col + 2] == CellValue.WALL)){
                    neighbors.add(new Cell( row ,col + 2 ));
                    setCellValue(row, col + 1, CellValue.OPEN);
                }
                Collections.shuffle(neighbors);
                return neighbors;
            }
            
            private void removeWall(Cell current, Cell neighbor){
                int rowDiff = current.row - neighbor.row;
                //int colDiff = current.col - neighbor.col;
                if(rowDiff == 0){
                    int wallRow = current.row;
                    int wallCol = (current.col + neighbor.col) / 2;
                    mazeDimensions[wallRow][wallCol] = CellValue.OPEN;
                } else{
                    int wallRow = ( current.row + neighbor.row ) / 2;
                    int wallCol = current.col;
                    mazeDimensions[wallRow][wallCol] = CellValue.OPEN;
                }
                int currentRow = (current.row + neighbor.row) / 2;
                int currentCol = (current.col + neighbor.col) / 2;
                mazeDimensions[currentRow][currentCol] = CellValue.OPEN;
            }
            private void setCellValue(int row, int col, CellValue val){
                mazeDimensions[row][col] = val;
            }
            private void setCellValue(Cell cell, CellValue val){
                mazeDimensions[cell.row][cell.col] = val;
            }
        }
