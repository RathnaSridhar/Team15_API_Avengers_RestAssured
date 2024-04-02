package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;



public class ExcelReaderData2 {

	//static ConfigReader readconfig=new ConfigReader();
	public static FileInputStream fi;
	public FileOutputStream fo;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public XSSFRow row;
	public static XSSFCell cell;
	public CellStyle style;   
	public File jsonFile;
    public static int totalRow;
	public static String xl_path="C:/Users/sumal/eclipse-workspace/LMS_RestAssuredBDD/src/test/resources/TestData/LMSTestData.xlsx";
    private static HashMap<String, List<Map<String, String>>> excelRows = new HashMap<>();

    private static ExcelReaderData2 xlData;
    
    private ExcelReaderData2() {
    	
    }
    
	@Test
	public HashMap<String,String> loginCred() throws IOException {
		
		//String path="/Users/anushakarthick/NumpyNinja/Anusha_Team8_APIArchitects_RestAssured/src/test/resources/TestData/Team_08_API Architects_LMSTestData.xlsx";
		//Users/sumal/eclipse-workspace/LMS_RestAssuredBDD/src/test/resourcesTestData
		File excel=new File(xl_path);
		FileInputStream fis=new FileInputStream(excel);
		XSSFWorkbook work=new XSSFWorkbook(fis);
		XSSFSheet sht=work.getSheet("Login");
		Cell c1 = sht.getRow(1).getCell(0);
		Cell c2=sht.getRow(1).getCell(1);
		Cell c3=sht.getRow(1).getCell(2);
		Cell c4=sht.getRow(1).getCell(3);
		
		HashMap<String,String> hm=new HashMap();
		hm.put("username", c1.getStringCellValue());
		hm.put("password", c2.getStringCellValue());
		hm.put("invalidusername", c3.getStringCellValue());
		hm.put("invalidpassword", c4.getStringCellValue());
		
		
		work.close();
		return hm;
	}
	
	


	//data driven through feature file
	private static int getDataRow(String dataKey, int dataColumn) {
		int rowCount = sheet.getLastRowNum();
	
		for(int row=0; row<= rowCount; row++){
			String excelKey = ExcelReaderData2.getCellData(row, dataColumn);
			
			if(ExcelReaderData2.getCellData(row, dataColumn).equalsIgnoreCase(dataKey)){
				return row;
			}
		}
		return 0;		
	}

	private static String getCellData(int rowNumb, int colNumb) {
		cell = sheet.getRow(rowNumb).getCell(colNumb);
		if(cell == null) {
			return "";
		}
		if(cell.getCellType() == CellType.NUMERIC) {
			cell.setCellType(CellType.STRING);
		}
		String cellData = cell.getStringCellValue();
		return cellData;
	}

	public static Map<String, String> getData(String dataKey, String sheetName) throws Exception {

		Map<String, String> dataMap = new HashMap<String, String>();
		fi=new FileInputStream(xl_path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);

		int dataRow = getDataRow(dataKey.trim(), 0);

		if (dataRow == 0) {
			throw new Exception("NO DATA FOUND for dataKey: "+dataKey);
		}

		int columnCount = sheet.getRow(dataRow).getLastCellNum();

		for(int i=0;i<columnCount;i++) {
			cell = sheet.getRow(dataRow).getCell(i);
			String cellData = null; 
			if (cell != null) {
				if(cell.getCellType() == CellType.NUMERIC) {
					cell.setCellType(CellType.STRING);
				}
				cellData = cell.getStringCellValue();
			}
			dataMap.put(sheet.getRow(0).getCell(i).getStringCellValue(), cellData);
		}
		return dataMap;
	}
	
	
	 private static List<Hashtable<String, String>> readAllRowsBySheet(Sheet sheet) {
	        Row row;
	        Cell cell;
	        totalRow = sheet.getLastRowNum();
	        List<Hashtable<String, String>> excelRowsZ = new ArrayList<>();
	        for (int currentRow = 1; currentRow <= totalRow; currentRow++) {
	            row = sheet.getRow(currentRow);
	            int totalColumn = row.getLastCellNum();
	            Hashtable<String, String> columnMapData = new Hashtable<String, String>();
	            for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {
	                cell = row.getCell(currentColumn);
	                String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn).getStringCellValue();
	                if (null != cell) {
	    				if(cell.getCellType() == CellType.NUMERIC) {
	    					cell.setCellType(CellType.STRING);
	    				}
	                		columnMapData.put(columnHeaderName, cell.getStringCellValue());
	                }else
	                    columnMapData.put(columnHeaderName, "");
	            }
	            excelRowsZ.add(columnMapData);
	        }
	        return excelRowsZ;
	    }

//private static Map<String, List<Map<String, String>>> readSheetListMap(Sheet sheet) {
	 private static void readSheetListMap(Sheet sheet) {
	        Row row;
	        Cell cell;
	        totalRow = sheet.getLastRowNum();
	        for (int currentRow = 1; currentRow <= totalRow; currentRow++) {
	            row = sheet.getRow(currentRow);
	            int totalColumn = row.getLastCellNum();
	            LinkedHashMap<String, String> columnMapData = new LinkedHashMap<>();
	            for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {
	                cell = row.getCell(currentColumn);
	                String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn).getStringCellValue();
	               
	                if (null != cell) {
	    				if(cell.getCellType() == CellType.NUMERIC) {
	    					cell.setCellType(CellType.STRING);
	    				}
	                		columnMapData.put(columnHeaderName, cell.getStringCellValue());
	                }else
	                    columnMapData.put(columnHeaderName, "");
	            }
	            String keyFeature = columnMapData.get("Features");
	            if(excelRows.get(keyFeature) == null) {
	            	excelRows.put(keyFeature, new ArrayList<Map<String,String>>());
	            }
	            List featureRows = excelRows.get(keyFeature);
	            featureRows.add(columnMapData);
	            //excelRows.put("Features", columnMapData);
	        }
	        //return excelRows;
	    }

	
	 private static List<Map<String, String>> readSheet(Sheet sheet) {
	        Row row;
	        Cell cell;
	        totalRow = sheet.getLastRowNum();
	        List<Map<String, String>> excelRows = new ArrayList<>();
	        for (int currentRow = 1; currentRow <= totalRow; currentRow++) {
	            row = sheet.getRow(currentRow);
	            int totalColumn = row.getLastCellNum();
	            LinkedHashMap<String, String> columnMapData = new LinkedHashMap<>();
	            for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {
	                cell = row.getCell(currentColumn);
	                String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn).getStringCellValue();
	                if (null != cell) {
	    				if(cell.getCellType() == CellType.NUMERIC) {
	    					cell.setCellType(CellType.STRING);
	    				}
	                		columnMapData.put(columnHeaderName, cell.getStringCellValue());
	                }else
	                    columnMapData.put(columnHeaderName, "");
	            }
	            excelRows.add(columnMapData);
	        }
	        return excelRows;
	    }


	    public int countRow() {
	        return totalRow;
	    }
	    
	    public static List<Map<String, String>> getSheetDataMaps(String sheetName) throws IOException {
	    	
			fi=new FileInputStream(xl_path);
			workbook=new XSSFWorkbook(fi);
			sheet=workbook.getSheet(sheetName);
//	        Workbook workbook = WorkbookFactory.create(new File(excelFilePath));
//	        Sheet sheet = workbook.getSheet(sheetName);
	        workbook.close();
	        return readSheet(sheet);
	    }
	    
	    public static void getSheetDataForFeature(String feature, String sheetName) throws IOException {
	    	
			fi=new FileInputStream(xl_path);
			workbook=new XSSFWorkbook(fi);
			sheet=workbook.getSheet(sheetName);
//	        Workbook workbook = WorkbookFactory.create(new File(excelFilePath));
//	        Sheet sheet = workbook.getSheet(sheetName);
	        workbook.close();
	        readSheetListMap(sheet);
	    }
	    
	    public static List<Hashtable<String, String>> getSheetDataByHT(String sheetName) throws IOException {
	    	
	 			fi=new FileInputStream(xl_path);
	 			workbook=new XSSFWorkbook(fi);
	 			sheet=workbook.getSheet(sheetName);
//	 	        Workbook workbook = WorkbookFactory.create(new File(excelFilePath));
//	 	        Sheet sheet = workbook.getSheet(sheetName);
	 	        workbook.close();
	 	        return readAllRowsBySheet(sheet);
	 	    }
	
	    public static synchronized ExcelReaderData2 getInstance() throws IOException {
	    	if (xlData == null) {
	    		xlData = new ExcelReaderData2();
		    	getSheetDataForFeature("GET All Batches","batches");
	    	}
	    	return xlData;
	    }
	    public List<Map<String, String>> getRowsListByFeatureKey(String featureKey){
	    	return xlData.excelRows.get(featureKey);
	    }
	    
public static void main(String args[]) {
	try {
		System.out.println("Reading Excel Data ");
		List<Map<String, String>> featureRows =   ExcelReaderData2.getInstance().getRowsListByFeatureKey("Create New Batch");
		System.out.println("Feature list size "+featureRows.size());
		System.out.println("Feature list "+featureRows);
		System.out.println("Complete Reading Excel Data ");
		
	}catch(Exception e) {
		e.printStackTrace();
	}
}
}
