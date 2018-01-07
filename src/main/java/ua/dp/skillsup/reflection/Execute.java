package ua.dp.skillsup.reflection;
import java.lang.annotation.*;

@Target(value=ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Execute {

}
