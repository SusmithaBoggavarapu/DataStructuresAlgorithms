package CrackingCodingInterview.TreesAndGraphs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
class Index {
    int i, j;

    @Override
    public String toString() {
        return "Index{" +
                "i=" + i +
                ", j=" + j +
                '}';
    }
}
