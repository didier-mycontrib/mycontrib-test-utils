package xxx.yyy.zzz.backoffice_test.error;

import org.mycontrib.generic.exception.GenericException;
import org.mycontrib.generic.exception.factory.GenericExceptionFactory;
import org.mycontrib.generic.exception.factory.WithLogGenericExceptionFactory;

public class ConvertedErrors {
	
	private ErrorExamples errorExamples;
	private GenericExceptionFactory genExceptionFactory;
	
	public ConvertedErrors(){
		errorExamples = new ErrorExamples();
		genExceptionFactory = new WithLogGenericExceptionFactory();
	}
	
	public void divByZero() throws GenericException{
		try {
			errorExamples.divByZero();
		} catch (Exception e) {
			//throw genExceptionFactory.newTechnicalException("div by zero",e);
			throw genExceptionFactory.convertToGenericException(e);
		} 
	}
	
	public void nullPointerEx() throws GenericException{
		try {
			errorExamples.nullPointerEx();
		} catch (Exception e) {
			//throw genExceptionFactory.newInternalException("null pointer ex",e);
			throw genExceptionFactory.convertToGenericException(e);
		} 
	}
	
	public void fileNotFound() throws GenericException{
		try {
			errorExamples.fileNotFound();
		} catch (Exception e) {
			//throw genExceptionFactory.newNoAccessException("file not found",e);
			throw genExceptionFactory.convertToGenericException(e);
		} 
	}
	
	public void classNotFound() throws GenericException{
		try {
			errorExamples.classNotFound();
		} catch (Exception e) {
			//throw genExceptionFactory.newTechnicalException("class not found",e);
			throw genExceptionFactory.convertToGenericException(e);
		} 
	}
	
	
	
	public void noDataBaseConnection() throws GenericException{
		try {
			errorExamples.noDataBaseConnection();
		} catch (Exception e) {
			//throw genExceptionFactory.newNoAccessException("no database connexion",e);
			throw genExceptionFactory.convertToGenericException(e);
		} 
	}
	
	public void wrongPassordForDataBaseConnection() throws GenericException{
		try {
			errorExamples.wrongPassordForDataBaseConnection();
		} catch (Exception e) {
			//throw genExceptionFactory.newDeniedException("wrong password or username",e);
			throw genExceptionFactory.convertToGenericException(e);
		} 
	}


	public void jndiLookupException() throws GenericException{
		try {
			errorExamples.jndiLookupException();
		} catch (Exception e) {
			//throw genExceptionFactory.newTechnicalException("Naming / jndiLookup exception",e);
			throw genExceptionFactory.convertToGenericException(e);
		} 
	}
	
}
