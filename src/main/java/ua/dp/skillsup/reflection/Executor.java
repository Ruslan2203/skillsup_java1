package ua.dp.skillsup.reflection;

import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;
import static com.google.common.base.StandardSystemProperty.JAVA_HOME;

public class Executor {
    public static void  execute (String packageName){
        Reflections reflections = new Reflections(packageName,new MethodAnnotationsScanner());
        Set <Method> execute = reflections.getMethodsAnnotatedWith(Execute.class);
        for (Method method:execute){
            try {
                method.invoke(method.getDeclaringClass().newInstance(),JAVA_HOME.toString());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

    }
}
