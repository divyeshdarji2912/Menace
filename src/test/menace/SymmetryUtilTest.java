package menace;

import static org.junit.jupiter.api.Assertions.*;

class SymmetryUtilTest {
    SymmetryUtil su = new SymmetryUtil();

    @org.junit.jupiter.api.Test
    void rotate90Board1() {
        assertEquals("630741852",su.rotate90("012345678"));
    }

    @org.junit.jupiter.api.Test
    void rotate90Board2() {
        assertEquals("X-X-X-X-X",su.rotate90("X-X-X-X-X"));
    }

    @org.junit.jupiter.api.Test
    void rotate180Board1() {
        assertEquals("876543210",su.rotate180("012345678"));
    }

    @org.junit.jupiter.api.Test
    void rotate270() {
        assertEquals("258147036",su.rotate270("012345678"));
    }

    @org.junit.jupiter.api.Test
    void flipHorizontal() {
        assertEquals("678345012",su.flipHorizontal("012345678"));
    }

    @org.junit.jupiter.api.Test
    void flipVertical() {
        assertEquals("210543876",su.flipVertical("012345678"));
    }

    @org.junit.jupiter.api.Test
    void diagonalFlip() {
        assertEquals("036147258",su.diagonalFlip("012345678"));
    }

    @org.junit.jupiter.api.Test
    void antiDiagonalFlip() {
        assertEquals("036147258",su.diagonalFlip("012345678"));
    }

}