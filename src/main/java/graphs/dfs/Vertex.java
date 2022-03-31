package graphs.dfs;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
public class Vertex {
    int val;

    @Override
    public String toString() {
        return "Vertex{" +
                "val=" + val +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vertex)) return false;
        Vertex vertex = (Vertex) o;
        return val == vertex.val;
    }

    @Override
    public int hashCode() {
        return Objects.hash(val);
    }
}
