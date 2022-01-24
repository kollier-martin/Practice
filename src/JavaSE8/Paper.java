package JavaSE8;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Paper extends PaperComparator {
    private String spacing;
    private Float margin;

    public void print() {
        System.out.println(this);
    }

    @Override
    public String toString(){
        return spacing + ": Margin - " + margin;
    }
}
