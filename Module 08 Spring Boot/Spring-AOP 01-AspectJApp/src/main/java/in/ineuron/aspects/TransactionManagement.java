package in.ineuron.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionManagement {

	// Syntax:: Access_specifier ReturType packageName.ClassName.methodName(parameter)
	// * means it can be any
	@Pointcut("execution(public * in.ineuron.dao.*.saveEmployee())")
	public void saveOperation() {}
	
	// Syntax:: AS RT packageName.ClassName.methodName(parameter)
	@Pointcut("execution(public * in.ineuron.dao.*.deleteEmployee())")
	public void deleteOperation() {}
	
	/*
	 *  above two point cuts are linked with this pointcut seperated by or operator,
	 *  means any one point cut is called then execute this method
	 */
	@Pointcut("saveOperation() || deleteOperation()")
	public void operation() {}

	@Before("operation()") // JoinPoint
	public void beginTransaction() {
		System.out.println("Transaction begin");
	}

	@After("operation()") // JoinPoint
	public void commitTransaction() {
		System.out.println("Transaction commited...");
	}

}
