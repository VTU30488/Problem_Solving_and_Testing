public static void matrixRotation(List<List<Integer>> matrix, int r) {
    int rows = matrix.size();
    int cols = matrix.get(0).size();

    int[][] result = new int[rows][cols];

    for (int layer = 0; layer < Math.min(rows, cols) / 2; layer++) {
        List<Integer> elements = new ArrayList<>();

        int top = layer;
        int bottom = rows - 1 - layer;
        int left = layer;
        int right = cols - 1 - layer;

        for (int j = left; j <= right; j++) {
            elements.add(matrix.get(top).get(j));
        }

        for (int i = top + 1; i <= bottom; i++) {
            elements.add(matrix.get(i).get(right));
        }

        for (int j = right - 1; j >= left; j--) {
            elements.add(matrix.get(bottom).get(j));
        }

        for (int i = bottom - 1; i > top; i--) {
            elements.add(matrix.get(i).get(left));
        }

        int rotation = r % elements.size();
        int index = rotation;

        for (int j = left; j <= right; j++) {
            result[top][j] = elements.get(index % elements.size());
            index++;
        }

        for (int i = top + 1; i <= bottom; i++) {
            result[i][right] = elements.get(index % elements.size());
            index++;
        }

        for (int j = right - 1; j >= left; j--) {
            result[bottom][j] = elements.get(index % elements.size());
            index++;
        }

        for (int i = bottom - 1; i > top; i--) {
            result[i][left] = elements.get(index % elements.size());
            index++;
        }
    }

    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            System.out.print(result[i][j]);

            if (j < cols - 1) {
                System.out.print(" ");
            }
        }

        System.out.println();
    }
}