package menace;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

enum State {
    RUNNING,
    WIN,
    LOSE,
    DRAW
}

public class Game {
    private final String board;
    private final State[] moves;
    private State state;
    private final GameStatus gameStatus;

    public Game(String board) {
        this.board = board;
        this.moves = new State[9];
        for (int i = 0; i < 9; i++) {
            this.moves[i] = State.RUNNING;
        }

        this.state = State.RUNNING;

        this.gameStatus = GameStatusHelper.getStatus(board);
    }

    /**
     * @param position position in the matchbox you want to place the bead
     * @param newState state after playing one's turn
     */
    public void setMoveState(int position, State newState) {
        moves[position] = newState;
        if (newState.equals(State.WIN)) {
            this.state = State.WIN;
        } else if (!this.state.equals(State.WIN) && newState.equals(State.DRAW)) {
            this.state = State.DRAW;
        } else if (this.state.equals(State.RUNNING) && newState.equals(State.LOSE)) {
            this.state = State.LOSE;
        }
    }

    public State getState() {
        if (this.getGameStatus().equals(GameStatus.X_WINNER) || this.getGameStatus().equals(GameStatus.O_WINNER)) {
            return State.LOSE;
        }
        if (this.getGameStatus().equals(GameStatus.DRAW)) {
            return State.DRAW;
        }

        return state;
    }

    public String getBoard() {
        return board;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public int nextMove() {
        if (getGameStatus() != GameStatus.RUNNING) return -1;

        List<Integer> possibleMoves = new ArrayList<>();
        for (int i = 0; i < moves.length; i++) {
            if (moves[i].equals(this.state)) {
                possibleMoves.add(i);
            }
        }

        if (possibleMoves.size() == 0) return -1;
        int randomPossibleMoveIndex = new Random().nextInt(possibleMoves.size());
        return possibleMoves.get(randomPossibleMoveIndex);
    }
}
