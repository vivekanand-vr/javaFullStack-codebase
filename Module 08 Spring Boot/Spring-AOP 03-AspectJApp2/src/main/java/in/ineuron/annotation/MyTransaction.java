package in.ineuron.annotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/*
 *  Our Custom Annotation
 */

@Retention(RUNTIME) //It indicates where the effect of annotation should be available.
@Target(METHOD) 	//It indicates where this annotation can be used in code[class/Field/Method].
public @interface MyTransaction {
	
}
