package menace;

import java.util.HashSet;

public class SymmetryUtil {
    private static final Integer[] selfMapping = {0, 1, 2, 3, 4, 5, 6, 7, 8};
    private static final Integer[] rotate90Mapping = {2, 5, 8, 1, 4, 7, 0, 3, 6};
    private static final Integer[] rotate180Mapping = {8, 7, 6, 5, 4, 3, 2, 1, 0};
    private static final Integer[] rotate270Mapping = {6, 3, 0, 7, 4, 1, 8, 5, 2};
    private static final Integer[] flipHorizontalMapping = {6, 7, 8, 3, 4, 5, 0, 1, 2};
    private static final Integer[] flipVerticalMapping = {2, 1, 0, 5, 4, 3, 8, 7, 6};
    private static final Integer[] diagonalFlipMapping = {0, 3, 6, 1, 4, 7, 2, 5, 8};
    private static final Integer[] antiDiagonalFlipMapping = {8, 5, 2, 7, 4, 1, 6, 3, 0};

    public static String[] getCombinations(String state) {
        String[] states = new String[8];
        states[0] = state;
        states[1] = rotate90(state);
        states[2] = rotate180(state);
        states[3] = rotate270(state);
        states[4] = flipHorizontal(state);
        states[5] = flipVertical(state);
        states[6] = diagonalFlip(state);
        states[7] = antiDiagonalFlip(state);
        return states;
    }

    public static Integer[] getMappingIfEqual(String original, String state) {
        if (state.equals(original)) {
            return selfMapping;
        } else if (state.equals(rotate90(original))) {
            return rotate90Mapping;
        }
        else if(state.equals(rotate180(original))) {
            return rotate180Mapping;
        }
        else if(state.equals(rotate270(original))) {
            return rotate270Mapping;
        }
        else if(state.equals(flipHorizontal(original))) {
            return flipHorizontalMapping;
        }
        else if(state.equals(flipVertical(original))) {
            return flipVerticalMapping;
        }
        else if(state.equals(diagonalFlip(original))) {
            return diagonalFlipMapping;
        }
        else if(state.equals(antiDiagonalFlip(original))) {
            return antiDiagonalFlipMapping;
        }
        else {
            return null;
        }
    }

    public static boolean contains(HashSet<String> set, String state) {
        return set.contains(state)
                || set.contains(rotate90(state))
                || set.contains(rotate180(state))
                || set.contains(rotate270(state))
                || set.contains(flipHorizontal(state))
                || set.contains(flipVertical(state))
                || set.contains(diagonalFlip(state))
                || set.contains(antiDiagonalFlip(state));
    }

    public static String rotate90(String board) {
        String transformedBoard = transform(board, rotate90Mapping);
        return transformedBoard;
    }

    public static String rotate180(String board) {
        String transformedBoard = transform(board, rotate180Mapping);
        return transformedBoard;
    }

    public static String rotate270(String board) {
        String transformedBoard = transform(board, rotate270Mapping);
        return transformedBoard;
    }

    public static String flipHorizontal(String board) {
        String transformedBoard = transform(board, flipHorizontalMapping);
        return transformedBoard;
    }

    public static String flipVertical(String board) {
        String transformedBoard = transform(board, flipVerticalMapping);
        return transformedBoard;
    }

    public static String diagonalFlip(String board) {
        String transformedBoard = transform(board, diagonalFlipMapping);
        return transformedBoard;
    }

    public static String antiDiagonalFlip(String board) {
        String transformedBoard = transform(board, antiDiagonalFlipMapping);
        return transformedBoard;
    }

    private static String transform(String board, Integer[] map) {
        char[] response = new char[9];
        for (int i = 0; i < board.length(); i++) {
            response[map[i]] = board.charAt(i);
        }
        return String.valueOf(response);
    }
}
