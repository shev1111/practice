package course.com.bank.utility;

import java.util.Collections;
import java.util.List;


import static java.util.Collections.unmodifiableList;

public final class CollectionUtility {

    private CollectionUtility() {

    }

    public static <T> List<T> nullSafeListInitialize(List<T> items) {
        return items == null ? Collections.<T>emptyList() : unmodifiableList(items);
    }
}
