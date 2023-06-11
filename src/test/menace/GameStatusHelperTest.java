package menace;

import static org.junit.jupiter.api.Assertions.*;

public class GameStatusHelperTest {
    GameStatusHelper gsh = new GameStatusHelper();

    @org.junit.jupiter.api.Test
    void getStatusTest(){
        assertEquals("X_WINNER",gsh.getStatus("XXXXXXXX").toString());
    }
}
