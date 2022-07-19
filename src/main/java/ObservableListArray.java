import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class ObservableListArray {
    public static void main(String[] args) {
        ArrayList<Integer> alNumbers=new ArrayList<>();
        ObservableList<Integer> olNumbers = FXCollections.observableArrayList();


        olNumbers.addListener(new ListChangeListener<Integer>() {
            @Override
            public void onChanged(Change<? extends Integer> change) {
                System.out.println("Subscriber 1"+change);
            }
        });
        olNumbers.addListener(new ListChangeListener<Integer>() {
            @Override
            public void onChanged(Change<? extends Integer> change) {
                System.out.println("Subscriber 2"+change);
            }
        });
        olNumbers.add(10);
        olNumbers.add(20);
        olNumbers.add(30);
        olNumbers.add(40);
    }
}
