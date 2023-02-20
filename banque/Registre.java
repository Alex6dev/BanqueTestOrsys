package banque;

import java.util.ArrayList;
import java.util.List;

public final class Registre {
    private final List<Operation> listOperation= new ArrayList<Operation>();
    public void addOperation(Operation operation){
        this.listOperation.add(operation);
    }

    @Override
    public String toString() {
        return "Registre{" +"\n"+
                "listOperation=" +listOperation+
                "\n"+'}';
    }
}
