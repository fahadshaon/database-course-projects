package edu.utd.dspl.tasks.utils;

import edu.utd.dspl.tasks.domain.Task;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author Fahad Shaon
 */
@Service
public class TaskValidator  implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Task.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", null, "Title can't be empty");
    }
}
