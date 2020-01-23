package course.com.bank.repository;

import java.util.List;

public class Pageable<T> {
    private final List<T> items;
    private final Page page;
    private final int maxPageNumber;

    public Pageable(List<T> items, Page page, int maxPageNumber) {
        this.items = items;
        this.page = page;
        this.maxPageNumber = maxPageNumber;
    }

    public List<T> getItems() {
        return items;
    }

    public Page getPage() {
        return page;
    }

    public int getMaxPageNumber() {
        return maxPageNumber;
    }
}
