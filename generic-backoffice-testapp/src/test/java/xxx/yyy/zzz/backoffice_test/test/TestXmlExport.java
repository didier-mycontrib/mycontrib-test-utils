
package xxx.yyy.zzz.backoffice_test.test;
//Start of user code java_imports
	import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mycontrib.generic.import_export.xml.XmlDbImportExport;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

	
//End of user code
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/dataSourceForTestSpringConf.xml"})
public class TestXmlExport { 
	
	@Inject
	private DataSource dataSource;
	
	@Test
	public void testExport(){
		try {
			XmlDbImportExport xmlDbImportExport = new XmlDbImportExport();
			xmlDbImportExport.setDataSource(dataSource);
			xmlDbImportExport.extractActualDataSetInDatabase();
			xmlDbImportExport.displayDatabaseDataSet();
			xmlDbImportExport.exportDatabaseDataSet("myDbExport.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//@Test
	public void testImport(){
		//Attention aux odres des lignes dans le fichier xml a importer
		//potentiel probleme d'integrite (foreign key) 
		try {
			XmlDbImportExport xmlDbImportExport = new XmlDbImportExport();
			xmlDbImportExport.setDataSource(dataSource);
			xmlDbImportExport.importDatabaseDataSet("myDbImport.xml");
			xmlDbImportExport.injectDataSetInDatabase();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
