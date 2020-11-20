import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperty {
    //    static {
//        Properties prob;
//    }
    static void Readpropertydata(String fileName) {

        File file = new File("/Users/priyaramoji/IdeaProjects/Selenium/src/test/java/datafile.properties/");

        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties prop = new Properties();

        //load properties file
        try {
            prop.load(fileInput);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String args[]) throws IOException {
//        File xlFile = new File(System.getProperty("user.dir")+"\\src\\Testdata\\login_properties.xls");
        File xlFile = new File("/Users/priyaramoji/IdeaProjects/Selenium/src/Testdata/login_properties.xls");
        FileInputStream fis = new FileInputStream(xlFile);
        HSSFWorkbook workbook = new HSSFWorkbook(fis);
        HSSFSheet sheet = workbook.getSheet("Sheet1");
        int row = sheet.getLastRowNum();
        int column = sheet.getRow(row).getLastCellNum();
        String value = sheet.getRow(0).getCell(0).toString();
        System.out.println(value);
    }
}