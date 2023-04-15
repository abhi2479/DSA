/* You start at the cell (rStart, cStart) of an rows x cols grid facing east. The northwest corner is at the first row and column in the grid, and the southeast corner is at the last row and column.

You will walk in a clockwise spiral shape to visit every position in this grid. Whenever you move outside the grid's boundary, we continue our walk outside the grid (but may return to the grid boundary later.). Eventually, we reach all rows * cols spaces of the grid.

Return an array of coordinates representing the positions of the grid in the order you visited them.

 

Example 1:

Input: rows = 1, cols = 4, rStart = 0, cStart = 0
Output: [[0,0],[0,1],[0,2],[0,3]]

Example 2:

Input: rows = 5, cols = 6, rStart = 1, cStart = 4
Output: [[1,4],[1,5],[2,5],[2,4],[2,3],[1,3],[0,3],[0,4],[0,5],[3,5],[3,4],[3,3],[3,2],[2,2],[1,2],[0,2],[4,5],[4,4],[4,3],[4,2],[4,1],[3,1],[2,1],[1,1],[0,1],[4,0],[3,0],[2,0],[1,0],[0,0]]

 

Constraints:

    1 <= rows, cols <= 100
    0 <= rStart < rows
    0 <= cStart < cols

 */
 
 /* Intuition:

Take steps one by one.
If the location is inside of grid, add it to res.
But how to simulate the path?

It seems to be annoying, but if we observer the path:

move right 1 step, turn right
move down 1 step, turn right
move left 2 steps, turn right
move top 2 steps, turn right,
move right 3 steps, turn right
move down 3 steps, turn right
move left 4 steps, turn right
move top 4 steps, turn right,

we can find the sequence of steps: 1,1,2,2,3,3,4,4,5,5....

So there are two thing to figure out:

    how to generate sequence 1,1,2,2,3,3,4,4,5,5
    how to turn right?

Generate sequence 1,1,2,2,3,3,4,4,5,5

Let n be index of this sequence.
Then A0 = 1, A1 = 1, A2 = 2 ......
We can find that An = n / 2 + 1

How to turn right?

By cross product:
Assume current direction is (x, y) in plane, which is (x, y, 0) in space.
Then the direction after turn right (x, y, 0) × (0, 0, 1) = (y, -x, 0)
Translate to code: tmp = x; x = y; y = -tmp;

By arrays of arrays:
The directions order is (0,1),(1,0),(0,-1),(-1,0), then repeat.
Just define a variable.

Time Complexity:

Time O(max(R,C)^2)
Space O(R*C) for output

Java: */

    public int[][] spiralMatrixIII(int R, int C, int x, int y) {
        int[][] res = new int[R * C][2];
        int dx = 0, dy = 1, n = 0, tmp;
        for (int j = 0; j < R * C; ++n) {
            for (int i = 0; i < n / 2 + 1; ++i) {
                if (0 <= x && x < R && 0 <= y && y < C)
                    res[j++] = new int[] {x, y};
                x += dx;
                y += dy;
            }
            tmp = dx;
            dx = dy;
            dy = -tmp;
        }
        return res;
	}
	
//===================================================================================

class Solution {
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        final int totalCellsToVisit = R * C;
        final int[][] cells = new int[totalCellsToVisit][2];
        int cellsVisited = 0;
        int stepLength = 1;
        int stepsTaken = 0;
        int direction = 0;
        int row = r0, column = c0;
        
        while (cellsVisited < totalCellsToVisit) {
            // If we are inside the matrix, record the position
            if (row >= 0 && row < R && column >= 0 && column < C) {
                cells[cellsVisited][0] = row;
                cells[cellsVisited][1] = column;
                cellsVisited++;
            }
            
            // Move a step to correct direction (0=E, 1=S, 2=W, 3=N)
            if (direction == 0) { column++; }
            else if (direction == 1) { row++; }
            else if (direction == 2) { column--; }
            else if (direction == 3) { row--; }
            stepsTaken++;
            
            // If we are taken the correct amount of steps to the current direction,
            // change direction
            if (stepsTaken == stepLength) {
                stepsTaken = 0;
                direction++;
                // When going east or west increase the steps we take for each direction
                if (direction == 2) {
                    stepLength++;
                    stepsTaken = 0;
                } else if (direction == 4) {
                    direction = 0;
                    stepLength++;
                    stepsTaken = 0;
                }
            }
        }
        return cells;
    }
}

//====================================================================================================

class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] result = new int[rows * cols][2];
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int index = 0;
        int steps = 1;
        int directionIndex = 0;
        result[index++] = new int[]{rStart, cStart};
        
        while (index < rows * cols) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < steps; j++) {
                    rStart += directions[directionIndex][0];
                    cStart += directions[directionIndex][1];
                    if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                        result[index++] = new int[]{rStart, cStart};
                    }
                }
                directionIndex = (directionIndex + 1) % 4;
            }
            steps++;
        }
        
        return result;
    }
}


//==================================================================================================================

class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int up = rStart;
        int bottum = rStart;
        int left = cStart;
        int right = cStart;
        int[][] res = new int[rows * cols][2];
        res[0][0] = rStart;
        res[0][1] = cStart;
        int index = 1;
        while (up >= 0 || bottum < rows || left >= 0 || right < cols) {
            for (int i = up + 1; i <= bottum && right < cols; i++) {
                if (i >= 0 && i < rows) {
                    res[index][0] = i;
                    res[index][1] = right;
                    index++;
                }
            }
            for (int i = right - 1; i >= left && bottum < rows; i--) {
                if (i >= 0 && i <= cols) {
                    res[index][0] = bottum;
                    res[index][1] = i;
                    index++;
                }
            }
            for (int i = bottum - 1; i >= up && left > -1; i--) {
                if (i >= 0 && i < rows) {
                    res[index][0] = i;
                    res[index][1] = left;
                    index++;
                }
            }
            for (int i = left + 1; i <= right && up > -1; i++) {
                if (i >= 0 && i < cols) {
                    res[index][0] = up;
                    res[index][1] = i;
                    index++;
                }
            }
            up = (up > -1) ? up - 1 : -1;
            bottum = (bottum < rows) ? bottum + 1 : bottum;
            left = (left > -1) ? left - 1 : -1;
            right = (right < cols) ? right + 1 : right;
        }
        return res;
    }
}