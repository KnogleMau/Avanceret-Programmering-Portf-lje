
package app.bigOExamples.entitiy;
import java.util.Objects;
public class CompareClass implements Comparable<CompareClass>  {

    private int value;
    private int id;
    public CompareClass(int id, int value){
        this.value = value;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setValue(int value){this.value = value;}

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CompareClass c = (CompareClass) o;
        return id == c.id && Objects.equals(value, c.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
    @Override
    public int compareTo(CompareClass c) {
        if (this.equals(c)) return 0;
        else if (this.getId() > c.getId()) return 1;
        else return -1;
    }


}


