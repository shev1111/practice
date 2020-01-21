package course.com.bank.service.validator;

public interface Validator<T> {
    boolean validate(T entity);
}
