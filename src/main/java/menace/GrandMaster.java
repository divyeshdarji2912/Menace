package menace;

import java.util.HashMap;
import java.util.HashSet;

public class GrandMaster {

    private final HashMap<Integer, HashSet<String>> states;
    private final HashMap<String, Game> gameMap;

    public GrandMaster(HashMap<Integer, HashSet<String>> states) {
        this.states = states;
        this.gameMap = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            for (String state: this.states.get(i)) {
                Game game = new Game(state);
                this.gameMap.put(state, game);
            }
        }

        train();
    }

    private void train() {
        for (int level = 8; level >= 0; level--) {
            for (String state : this.states.get(level)) {
                Game game = gameMap.get(state);
                if (!game.getState().equals(State.RUNNING)) {
                    continue;
                }

                for (int pos = 0; pos < 9; pos++) {
                    char[] board = game.getBoard().toCharArray();
                    if (board[pos] != '-') {
                        continue;
                    }

                    board[pos] = nextMove(level);
                    for (String nextState : this.states.get(level + 1)) {
                        Integer[] mapping = SymmetryUtil.getMappingIfEqual(String.valueOf(board), nextState);
                        if (mapping == null) {
                            continue;
                        }

                        Game nextGame = gameMap.get(nextState);
                        if (nextGame.getState().equals(State.WIN)) {
                            game.setMoveState(pos, State.LOSE);
                        } else if (nextGame.getState().equals(State.LOSE)) {
                            game.setMoveState(pos, State.WIN);
                        } else if (nextGame.getState().equals(State.DRAW)) {
                            game.setMoveState(pos, State.DRAW);
                        }
                    }
                }
            }
        }
    }

    public int nextMove(String state, int level) {
        for (String originalState : this.states.get(level)) {
            Integer[] mapping = SymmetryUtil.getMappingIfEqual(originalState, state);
            if (mapping == null) {
                continue;
            }

            Game game = this.gameMap.get(originalState);
            int move = game.nextMove();
            return mapping[move];
        }

        return -1;
    }

    private static char nextMove(int level) {
        return level % 2 == 0 ? 'X' : 'O';
    }

}
