package course.com.bank.service.validator;

public interface Validator<T> {
    void validate(T entity);
}
