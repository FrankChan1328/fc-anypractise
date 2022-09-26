package lot.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.collect.Lists;

import lot.entity.Lot;

public class LotUtil {
    public static List<Lot> convert(String filepath) throws Exception {
        List<Lot> list = Lists.newArrayList();
        
        InputStream is = new FileInputStream(filepath);
        Workbook wb = new XSSFWorkbook(is);
        Sheet sheet = wb.getSheetAt(0);
        // 得到总行数
        int rowNum = sheet.getLastRowNum();
        
        Row row = sheet.getRow(0);
        
        // 正文内容应该从第二行开始,第一行为表头的标题
        for (int i = 1; i <= rowNum; i++) {
            Lot lot = new Lot();
            row = sheet.getRow(i);
            
            // 设置期数
            String termObj = getCellFormatValue(row.getCell(0));
            lot.setTerm(getNumber(termObj));
            // 设置f01
            String f01Obj = getCellFormatValue(row.getCell(1));
            lot.setF01(getNumber(f01Obj));
            // 设置f02
            String f02Obj = getCellFormatValue(row.getCell(2));
            lot.setF02(getNumber(f02Obj));
            // 设置f03
            String f03Obj = getCellFormatValue(row.getCell(3));
            lot.setF03(getNumber(f03Obj));
            // 设置f04
            String f04Obj = getCellFormatValue(row.getCell(4));
            lot.setF04(getNumber(f04Obj));
            // 设置f05
            String f05Obj = getCellFormatValue(row.getCell(5));
            lot.setF05(getNumber(f05Obj));
            // 设置e01
            String e01Obj = getCellFormatValue(row.getCell(6));
            lot.setE01(getNumber(e01Obj));
            // 设置e02
            String e02Obj = getCellFormatValue(row.getCell(7));
            lot.setE02(getNumber(e02Obj));
            // 设置total
            lot.setTotal(getTotal(lot));
            
            list.add(lot);
        }
        wb.close();
        is.close();
        
        return list;
    }
    
    public static String getTotal(Lot lot) {
        StringBuilder sb = new StringBuilder();
        sb.append(str(lot.getF01()));
        sb.append(str(lot.getF02()));
        sb.append(str(lot.getF03()));
        sb.append(str(lot.getF04()));
        sb.append(str(lot.getF05()));
        sb.append(str(lot.getE01()));
        sb.append(str(lot.getE02()));
        return sb.toString();
    }
    
    private static String str(int num) {
        return num >= 10 ? String.valueOf(num) : "0" + num;
    }
    
    private static int getNumber(String str) {
        Double tmp = Double.valueOf(str);
        return tmp.intValue();
    }

    private static String getCellFormatValue(Cell cell) {
        Object cellvalue = "";
        if (cell != null) {
            // 判断当前Cell的Type
            switch (cell.getCellType()) {
            case Cell.CELL_TYPE_NUMERIC:// 如果当前Cell的Type为NUMERIC
            case Cell.CELL_TYPE_FORMULA: {
                // 判断当前的cell是否为Date
                if (DateUtil.isCellDateFormatted(cell)) {
                    // 如果是Date类型则，转化为Data格式
                    // data格式是带时分秒的：2013-7-10 0:00:00
                    // cellvalue = cell.getDateCellValue().toLocaleString();
                    // data格式是不带带时分秒的：2013-7-10
                    Date date = cell.getDateCellValue();
                    cellvalue = date;
                } else {// 如果是纯数字
 
                    // 取得当前Cell的数值
                    cellvalue = String.valueOf(cell.getNumericCellValue());
                }
                break;
            }
            case Cell.CELL_TYPE_STRING:// 如果当前Cell的Type为STRING
                // 取得当前的Cell字符串
                cellvalue = cell.getRichStringCellValue().getString();
                break;
            default:// 默认的Cell值
                cellvalue = "";
            }
        } else {
            cellvalue = "";
        }
        return String.valueOf(cellvalue);
    }
}
