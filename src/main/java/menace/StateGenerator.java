package menace;

import java.util.HashMap;
import java.util.HashSet;

public class StateGenerator {
    public static HashMap<Integer, HashSet<String>> getStates() {
        char[] board = {'-', '-','-','-','-','-','-','-','-'};
        char nextTurn = 'X';
        HashMap<Integer, HashSet<String>> states = new HashMap<>();
        backTrack(board, nextTurn, states, 0);

        HashMap<Integer, HashSet<String>> symmetricStates = new HashMap<>();
        int count = 0;
        for (int i = 0; i <= 9; i++) {
            HashSet<String> set = new HashSet<>();
            for (String state: states.get(i)) {
                if (!SymmetryUtil.contains(set, state)) {
                    set.add(state);
                }
            }
            symmetricStates.put(i, set);
            count += set.size();
        }
        return symmetricStates;
    }

    private static void backTrack(char[] board, char nextTurn, HashMap<Integer, HashSet<String>> states, int level) {
        if (!states.containsKey(level)) {
            states.put(level, new HashSet<>());
        }

        if (states.get(level).contains(String.valueOf(board))) {
            return;
        }

        states.get(level).add(String.valueOf(board));

        for(int i = 0 ; i < 9 ; i++) {
            if (board[i] == '-') {
                board[i] = nextTurn;
                backTrack(board, nextTurn == 'X' ? 'O' : 'X', states, level + 1);
                board[i] = '-';
            }
        }
    }

    public static void getCombinations(
            char[] board, HashMap<Integer, HashSet<String>> states, int level, int pos, int xCount, int oCount) {
        if (pos >= 9) return;

        if (!states.containsKey(level)) {
            states.put(level, new HashSet<>());
        }

        states.get(level).add(String.valueOf(board));
        char[] possibilities = {'-', 'X', 'O'};

        for (char possibility: possibilities) {
            if (possibility == 'X') {
                if (xCount >= 5) continue;
                board[pos] = 'X';
                getCombinations(board, states, level + 1, pos + 1, xCount + 1, oCount);
                board[pos] = '-';
            } else if (possibility == 'O') {
                if (oCount >= 4) continue;
                board[pos] = 'O';
                getCombinations(board, states, level + 1, pos + 1, xCount, oCount + 1);
                board[pos] = '-';
            } else {
                getCombinations(board, states, level + 1, pos + 1, xCount, oCount + 1);
            }
        }
    }
}
