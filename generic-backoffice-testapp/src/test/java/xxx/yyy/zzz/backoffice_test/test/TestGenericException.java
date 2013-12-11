package xxx.yyy.zzz.backoffice_test.test;

import org.junit.Assert;
import org.junit.Test;
import org.mycontrib.generic.exception.GenericException;
import org.mycontrib.generic.exception.type.GenericExceptionType;
import org.mycontrib.generic.exception.util.BasicGenericExceptionUtil;
import org.mycontrib.generic.exception.util.GenericExceptionUtil;

import xxx.yyy.zzz.backoffice_test.error.ConvertedErrors;

public class TestGenericException {
	
	private ConvertedErrors convertedErrors;
	private GenericExceptionUtil genericExceptionUtil;
	
	public TestGenericException(){
		convertedErrors = new ConvertedErrors();
		genericExceptionUtil = new BasicGenericExceptionUtil();
		//genericExceptionUtil = new SwingGenericExceptionUtil();
	}
	
	@Test
	public void testDivByZero(){
		try {
			convertedErrors.divByZero();
		} catch (GenericException e) {
			//genericExceptionUtil.show(e);
			genericExceptionUtil.showWithDetails(e);
			Assert.assertTrue(e.getExceptionType()==GenericExceptionType.TECHNICAL);
		}
	}
	
	@Test
	public void testNullPointerEx(){
		try {
			convertedErrors.nullPointerEx();
		} catch (GenericException e) {
			//genericExceptionUtil.show(e);
			genericExceptionUtil.showWithDetails(e);
			Assert.assertTrue(e.getExceptionType()==GenericExceptionType.INTERNAL);
		}
	}
	
	@Test
	public void testFileNotFound(){
		try {
			convertedErrors.fileNotFound();
		} catch (GenericException e) {
			//genericExceptionUtil.show(e);
			genericExceptionUtil.showWithDetails(e);
			Assert.assertTrue(e.getExceptionType()==GenericExceptionType.NO_ACCESS);
		}
	}
	
	@Test
	public void testClassNotFound(){
		try {
			convertedErrors.classNotFound();
		} catch (GenericException e) {
			//genericExceptionUtil.show(e);
			genericExceptionUtil.showWithDetails(e);
			Assert.assertTrue(e.getExceptionType()==GenericExceptionType.TECHNICAL);
		}
	}
	
	@Test
	public void NoDataBaseConnection(){
		try {
			convertedErrors.noDataBaseConnection();
		} catch (GenericException e) {
			//genericExceptionUtil.show(e);
			genericExceptionUtil.showWithDetails(e);
			Assert.assertTrue(e.getExceptionType()==GenericExceptionType.NO_ACCESS);
		}
	}
	
	@Test
	public void wrongPasswordForDataBaseConnection(){
		try {
			convertedErrors.wrongPassordForDataBaseConnection();
		} catch (GenericException e) {
			//genericExceptionUtil.show(e);
			genericExceptionUtil.showWithDetails(e);
			Assert.assertTrue(e.getExceptionType()==GenericExceptionType.DENIED);
		}
	}
	
	@Test
	public void jndiLookupException(){
		try {
			convertedErrors.jndiLookupException();
		} catch (GenericException e) {
			//genericExceptionUtil.show(e);
			genericExceptionUtil.showWithDetails(e);
			Assert.assertTrue(e.getExceptionType()==GenericExceptionType.TECHNICAL);
		}
	}


}
