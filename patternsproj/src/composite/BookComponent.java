package composite;

import java.util.ArrayList;
import java.util.List;

public interface BookComponent {
    void displayInfo();

    void addItem(BookComponent singleBook);
}

