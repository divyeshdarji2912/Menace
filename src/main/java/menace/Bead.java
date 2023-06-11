package menace;

import java.util.Objects;

public class Bead {

    private final int position;

    public Bead(int position) {
        this.position = position;
    }

    public int getPosition(){
        return this.position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bead bead = (Bead) o;
        return position == bead.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public String toString() {
        return "Bead {position=" + position + "}";
    }
}
