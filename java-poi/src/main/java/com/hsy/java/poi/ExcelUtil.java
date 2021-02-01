package com.hsy.java.poi;

import com.hsy.java.poi.bean.Student;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class ExcelUtil {


    /**
     * @param fileName   文件名
     * @param headerList 列标题值
     * @param dataList   表格数据
     * @param response
     * @throws IOException
     * @Description: excel下载
     * @author jaler
     * @date 2017年10月17日 上午10:19:05
     */
    public void exportExcel(String fileName, List<String> headerList, List<List<Object>> dataList, HttpServletResponse response) throws IOException {

        HSSFWorkbook wb = new HSSFWorkbook();
        Map<String, CellStyle> createStyles = createStyles(wb);

        // 新建sheet
        HSSFSheet sheet1 = wb.createSheet("sheet1");
        // 生成sheet1内容
        Row rowFirst = sheet1.createRow(0);// 第一个sheet的第一行为标题

        //设置excel第一行标题单元格
        for (int i = 0; i < headerList.size(); i++) {

            Cell cell = rowFirst.createCell(i); // 获取第一行的每个单元格
            int colWidth = sheet1.getColumnWidth(i) * 2;
            sheet1.setColumnWidth(i, colWidth < 3000 ? 3000 : colWidth);
            //sheet1.setColumnWidth(i,4500); // 设置每列的列宽
            cell.setCellStyle(createStyles.get("header")); // 加样式
            cell.setCellValue(headerList.get(i)); // 往单元格里写数据
        }

        //设置数据
        for (int i = 0; i < dataList.size(); i++) {
            Row row = sheet1.createRow(i + 1);
            List<Object> cellList = dataList.get(i);
            for (int j = 0; j < headerList.size(); j++) {
                setCellValue(row, j, cellList.get(j), createStyles.get("data2"));
            }
        }

        // 弹出下载提示框的设置
        String finalName = new String(fileName.getBytes("gb2312"), "ISO8859-1");
        response.reset();
        response.setContentType("application/x-download; charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + finalName + ".xls");
        response.setCharacterEncoding("utf-8");
        wb.write(response.getOutputStream());
        response.getOutputStream().flush();
        response.getOutputStream().close();
    }

    public void exportExcelTemplate(String fileName, List<String> headerList, HttpServletResponse response) throws IOException {

        HSSFWorkbook wb = new HSSFWorkbook();
        Map<String, CellStyle> createStyles = createStyles(wb);

        // 新建sheet
        HSSFSheet sheet1 = wb.createSheet("sheet1");
        // 生成sheet1内容
        Row rowFirst = sheet1.createRow(0);// 第一个sheet的第一行为标题

        //设置excel第一行标题单元格
        for (int i = 0; i < headerList.size(); i++) {

            Cell cell = rowFirst.createCell(i); // 获取第一行的每个单元格
            int colWidth = sheet1.getColumnWidth(i) * 2;
            sheet1.setColumnWidth(i, colWidth < 3000 ? 3000 : colWidth);
            //sheet1.setColumnWidth(i,4500); // 设置每列的列宽
            cell.setCellStyle(createStyles.get("header")); // 加样式
            cell.setCellValue(headerList.get(i)); // 往单元格里写数据
        }


        // 弹出下载提示框的设置
        String finalName = new String(fileName.getBytes(), "utf-8");
        response.reset();
        response.setContentType("application/x-download; charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + finalName + ".xls");
        response.setCharacterEncoding("utf-8");
        wb.write(response.getOutputStream());
        response.getOutputStream().flush();
        response.getOutputStream().close();
    }

    public Cell setCellValue(Row row, int column, Object val, CellStyle cellStyle) {
        Cell cell = row.createCell(column);
        try {
            if (val == null) {
                cell.setCellValue("");
            } else if (val instanceof String) {
                cell.setCellValue((String) val);
            } else if (val instanceof Integer) {
                cell.setCellValue((Integer) val);
            } else if (val instanceof Long) {
                cell.setCellValue((Long) val);
            } else if (val instanceof Double) {
                cell.setCellValue((Double) val);
            } else if (val instanceof Float) {
                cell.setCellValue((Float) val);
            } else if (val instanceof Date) {
//                cell.setCellValue((String) DateUtils.format((Date) val));
            } else if (val instanceof BigDecimal) {
                cell.setCellValue(((BigDecimal) val).doubleValue());
            } else {
                cell.setCellValue((String) val);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            cell.setCellValue(val.toString());
        }
        cell.setCellStyle(cellStyle);
        return cell;
    }

    /**
     * @param cls       实体类名
     * @param fileName  文件名
     * @param is        文件输入流
     * @throws IOException
     * @Description: excel导入转成实体列表
     */
    public static <E> List<E> importExcel(Class<E> cls, String fileName, InputStream is) throws Exception {

        List<E> returnList = new ArrayList<>();
        Workbook wb = null;
        if (StringUtils.isBlank(fileName)) {
            throw new RuntimeException("文件名为空！");
        } else if (fileName.toLowerCase().endsWith("xls")) {
            wb = new HSSFWorkbook(is);
        } else if (fileName.toLowerCase().endsWith("xlsx")) {
            wb = new XSSFWorkbook(is);
        } else {
            throw new RuntimeException("文件格式不正确!");
        }
        // 读sheet
        for (int i = 0; i < wb.getNumberOfSheets(); i++) {
            Sheet sheet = wb.getSheetAt(i);
            if (sheet == null) {
                continue;
            }
            // 读row
            for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
                Row row = sheet.getRow(rowNum);
                // 如果主键列为空则执行下一行
                if(row.getCell(rowNum) == null) {
                    continue;
                }
                returnList.add(generateObj(row, cls));
            }
        }
        return returnList;
    }

    /**
     * 生成单条对象
     * @param row
     * @param cls
     * @param <E>
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws ParseException
     */
    private static <E> E generateObj(Row row, Class<E> cls) throws IllegalAccessException, InstantiationException, ParseException {
        /**
         * 此行代码请注意
         * excel中的列明顺序必须跟 E中对象的属性顺序一致，否则对应不上
         */
        Field[] fields = cls.getDeclaredFields();
        E object = cls.newInstance();
        int lastCellNum = row.getLastCellNum();
        // 读取单元格
        for (int j = 0; j < lastCellNum; j++) {
            Cell cell = row.getCell(j);
            //获取实体bean中字段对应的数据类型
            Class<?> clazz = fields[j].getType();
            String type = clazz.getName();
            if (null != cell) {
                if ("java.lang.String".equals(type)) {
                    String cellValue = cell.getStringCellValue();
                    Reflections.invokeSetter(object, fields[j].getName(), cellValue);
                } else if ("java.util.Date".equals(type)) {
                    Date cellValue = null;
                    DecimalFormat df = new DecimalFormat("#");
                    switch (cell.getCellType()) {
                        case NUMERIC:
                            if (HSSFDateUtil.isCellDateFormatted(cell)) {
                                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                                String date = sdf.format(HSSFDateUtil.getJavaDate(cell.getNumericCellValue()));
                                cellValue = DateUtils.parse(date);
                            }
                            break;
                        case STRING:
                            cellValue = DateUtils.parse(cell.getStringCellValue());
                            break;
                        default:
                            cellValue = null;
                            break;
                    }
                    Reflections.invokeSetter(object, fields[j].getName(), cellValue);
                } else if ("java.lang.Integer".equals(type) || "int".equals(type)) {
                    cell.setCellType(CellType.NUMERIC);
                    Integer cellValue = (int) cell.getNumericCellValue();
                    Reflections.invokeSetter(object, fields[j].getName(), cellValue);
                } else if ("java.lang.Long".equals(type) || "long".equals(type)) {
                    cell.setCellType(CellType.NUMERIC);
                    Long cellValue = (long) cell.getNumericCellValue();
                    Reflections.invokeSetter(object, fields[j].getName(), cellValue);
                } else if ("java.lang.Short".equals(type) || "short".equals(type)) {
                    cell.setCellType(CellType.NUMERIC);
                    Short cellValue = (short) cell.getNumericCellValue();
                    Reflections.invokeSetter(object, fields[j].getName(), cellValue);
                } else if ("java.lang.Boolean".equals(type) || "boolean".equals(type)) {
                    Boolean cellValue = cell.getBooleanCellValue();
                    Reflections.invokeSetter(object, fields[j].getName(), cellValue);
                }
            }
        }
        return object;
    }

    /**
     * 获取单元格值
     *
     * @param row    获取的行
     * @param column 获取单元格列号
     * @return 单元格值
     */
    @SuppressWarnings("deprecation")
    public Object getCellValue(Row row, int column) {
        Object val = "";
        try {
            Cell cell = row.getCell(column);
            if (cell != null) {
                if (cell.getCellType() == CellType.NUMERIC) {
                    val = cell.getNumericCellValue();
                } else if (cell.getCellType() == CellType.STRING) {
                    val = cell.getStringCellValue();
                } else if (cell.getCellType() == CellType.FORMULA) {
                    val = cell.getCellFormula();
                } else if (cell.getCellType() == CellType.BOOLEAN) {
                    val = cell.getBooleanCellValue();
                } else if (cell.getCellType() == CellType.ERROR) {
                    val = cell.getErrorCellValue();
                }
            }
        } catch (Exception e) {
            return val;
        }
        return val;
    }

    /**
     * @param @param  strFormula
     * @param @param  firstRow   起始行
     * @param @param  endRow     终止行
     * @param @param  firstCol   起始列
     * @param @param  endCol     终止列
     * @param @return
     * @return HSSFDataValidation
     * @throws
     * @Title: SetDataValidation
     * @Description: 下拉列表元素很多的情况 (255以上的下拉)
     */
    private static HSSFDataValidation SetDataValidation(String strFormula,
                                                        int firstRow, int endRow, int firstCol, int endCol) {

        // 设置数据有效性加载在哪个单元格上。四个参数分别是：起始行、终止行、起始列、终止列
        CellRangeAddressList regions = new CellRangeAddressList(firstRow, endRow, firstCol, endCol);
        DVConstraint constraint = DVConstraint.createFormulaListConstraint(strFormula);
        HSSFDataValidation dataValidation = new HSSFDataValidation(regions, constraint);

        dataValidation.createErrorBox("Error", "Error");
        dataValidation.createPromptBox("", null);

        return dataValidation;
    }


    /**
     * @param @param  sheet
     * @param @param  textList
     * @param @param  firstRow
     * @param @param  endRow
     * @param @param  firstCol
     * @param @param  endCol
     * @param @return
     * @return DataValidation
     * @throws
     * @Title: setDataValidation
     * @Description: 下拉列表元素不多的情况(255以内的下拉)
     */
    private static DataValidation setDataValidation(Sheet sheet, String[] textList, int firstRow, int endRow, int firstCol, int endCol) {

        DataValidationHelper helper = sheet.getDataValidationHelper();
        //加载下拉列表内容
        DataValidationConstraint constraint = helper.createExplicitListConstraint(textList);
        //DVConstraint constraint = new DVConstraint();
        constraint.setExplicitListValues(textList);

        //设置数据有效性加载在哪个单元格上。四个参数分别是：起始行、终止行、起始列、终止列
        CellRangeAddressList regions = new CellRangeAddressList((short) firstRow, (short) endRow, (short) firstCol, (short) endCol);

        //数据有效性对象
        DataValidation data_validation = helper.createValidation(constraint, regions);
        //DataValidation data_validation = new DataValidation(regions, constraint);

        return data_validation;
    }

    /**
     * @param @param filePath  文件路径
     * @return void
     * @throws
     * @Title: delFile
     * @Description: 删除文件
     */
    public void delFile(String filePath) {
        java.io.File delFile = new java.io.File(filePath);
        delFile.delete();
    }

    /**
     * 创建表格样式
     *
     * @param wb 工作薄对象
     * @return 样式列表
     */
    private Map<String, CellStyle> createStyles(Workbook wb) {
        Map<String, CellStyle> styles = new HashMap<String, CellStyle>();

        CellStyle style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        Font titleFont = wb.createFont();
        titleFont.setFontName("Arial");
        titleFont.setFontHeightInPoints((short) 16);
        titleFont.setBold(true);
        style.setFont(titleFont);
        styles.put("title", style);

        style = wb.createCellStyle();
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setBorderRight(BorderStyle.THIN);
        style.setRightBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
        style.setBorderLeft(BorderStyle.THIN);
        style.setLeftBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
        style.setBorderTop(BorderStyle.THIN);
        style.setTopBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
        style.setBorderBottom(BorderStyle.THIN);
        style.setBottomBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
        Font dataFont = wb.createFont();
        dataFont.setFontName("Arial");
        dataFont.setFontHeightInPoints((short) 10);
        style.setFont(dataFont);
        styles.put("data", style);

        style = wb.createCellStyle();
        style.cloneStyleFrom(styles.get("data"));
        style.setAlignment(HorizontalAlignment.LEFT);
        styles.put("data1", style);
        //居中，设置单元格为文本格式
        style = wb.createCellStyle();
        style.cloneStyleFrom(styles.get("data"));
        style.setAlignment(HorizontalAlignment.CENTER);
        DataFormat format = wb.createDataFormat();
        style.setDataFormat(format.getFormat("@"));
        styles.put("data2", style);

        style = wb.createCellStyle();
        style.cloneStyleFrom(styles.get("data"));
        style.setAlignment(HorizontalAlignment.RIGHT);
        styles.put("data3", style);

        style = wb.createCellStyle();
        style.cloneStyleFrom(styles.get("data"));
//			style.setWrapText(true);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        Font headerFont = wb.createFont();
        headerFont.setFontName("Arial");
        headerFont.setFontHeightInPoints((short) 10);
        headerFont.setBold(true);
        headerFont.setColor(IndexedColors.WHITE.getIndex());
        style.setFont(headerFont);
        styles.put("header", style);

        return styles;
    }

    /**
     * @param @param  uuid
     * @param @param  request
     * @param @param  response
     * @param @return
     * @return Data
     * @throws
     * @Title: main
     * @Description: 测试生成Excel模板并导出
     */

    public static void main(String[] args) throws Exception {
        String fileName = "D:\\devTools\\work\\doc\\开放平台\\测试读取excel.xlsx";
        InputStream is = new FileInputStream(fileName);
        List<Student> studentList = importExcel(Student.class, "测试读取excel.xlsx", is);
        studentList.stream().forEach(student -> System.out.println(student.toString()));
    }

}
