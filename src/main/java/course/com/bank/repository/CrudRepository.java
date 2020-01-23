package course.com.bank.repository;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<E> {
    //creat
    void save(E entity);

    //read
   Optional <E> findById(Integer id);

    List<E> findAll(int page, int itemsPerPage);

    //update

    void update(E entity);

    //
    void deleteById(Integer id);

    long count();
}
