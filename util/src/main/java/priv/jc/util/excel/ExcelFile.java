/**
 * 
 */
package priv.jc.util.excel;

import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import priv.jc.util.date.DateTime;

/**
 * @author Jacky
 *
 */
public class ExcelFile {
	public static final String excel_fileType_9703 = "d0cf11e0";
	public static final String excel_fileType_2007 = "504b0304";

	public static final String excel_suffix_9703 = ".xls";
	public static final String excel_suffix_2007 = ".xlsx";

	public static <T> List<T> read(Class<T> clazz, FileItem item) throws Exception {
		List<T> result = null;
		if (item != null) {
			File file = new File(new String(item.getName().getBytes()));
			if (validate(file, item.getInputStream())) {
				result = toWorkbook(clazz, item.getInputStream());
			}
		}
		return result;
	}

	/*
	 * 将文件流转换成工作簿
	 */
	public static <T> List<T> toWorkbook(Class<T> clazz, InputStream stream)
			throws IllegalArgumentException, Exception {
		List<T> result = null;
		Workbook wb = WorkbookFactory.create(stream);
		if (wb instanceof HSSFWorkbook) {
			result = parse_9703(clazz, wb);
		} else if (wb instanceof XSSFWorkbook) {
			result = parse_2007(clazz, wb);
		}
		return result;
	}

	/*
	 * 将文件流转换成工作簿
	 */
	public static <T> List<T> toWorkbook(Class<T> clazz, File file) throws IllegalArgumentException, Exception {
		List<T> result = null;
		Workbook wb = WorkbookFactory.create(file);
		if (wb instanceof HSSFWorkbook) {
			result = parse_9703(clazz, wb);
		} else if (wb instanceof XSSFWorkbook) {
			result = parse_2007(clazz, wb);
		}
		return result;
	}

	/*
	 * 使用poi实现的EXCEL2007解析
	 */
	private static <T> List<T> parse_2007(Class<T> clazz, Workbook wb) throws Exception {
		List<T> result = new ArrayList<T>();
		T t = null;
		// Read the Sheet
		for (int numSheet = 0; numSheet < wb.getNumberOfSheets(); numSheet++) {
			XSSFSheet sheet = (XSSFSheet) wb.getSheetAt(numSheet);
			if (sheet == null) {
				continue;
			}
			// Read the Row
			for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
				XSSFRow row = sheet.getRow(rowNum);
				if (row != null) {
					t = clazz.newInstance();
					Class<?> c = t.getClass();
					Field[] fields = c.getDeclaredFields();
					for (Field f : fields) {
						ExcelMeta meta = f.getAnnotation(ExcelMeta.class);
						if (meta != null) {
							f.setAccessible(true);
							try {
								f.set(t, convert(f.getType().getName(), getValue(row.getCell(meta.index()))));
							} catch (Exception e) {
								throw new Exception(String.format("行：%d 列：%d，%s", row.getRowNum() + 1,
										row.getCell(meta.index()).getColumnIndex() + 1, e.getMessage()));
							}
						}
					}
					result.add(t);
				}
			}
		}
		return result;
	}

	/*
	 * 使用poi实现的EXCEL2003解析
	 */
	private static <T> List<T> parse_9703(Class<T> clazz, Workbook wb) throws IllegalArgumentException, Exception {
		List<T> result = new ArrayList<T>();
		T t = null;
		// Read the Sheet
		for (int numSheet = 0; numSheet < wb.getNumberOfSheets(); numSheet++) {
			HSSFSheet sheet = (HSSFSheet) wb.getSheetAt(numSheet);
			if (sheet == null) {
				continue;
			}
			// Read the Row
			for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
				HSSFRow row = sheet.getRow(rowNum);
				if (row != null) {
					t = clazz.newInstance();
					Class<?> c = t.getClass();
					Field[] fields = c.getDeclaredFields();
					for (Field f : fields) {
						ExcelMeta meta = f.getAnnotation(ExcelMeta.class);
						if (meta != null) {
							f.setAccessible(true);
							try {
								f.set(t, convert(f.getType().getName(), getValue(row.getCell(meta.index()))));
							} catch (Exception e) {
								throw new Exception(String.format("行：%d 列：%d，%s", row.getRowNum() + 1,
										row.getCell(meta.index()).getColumnIndex() + 1, e.getMessage()));
							}
						}
					}
					result.add(t);
				}
			}
		}
		return result;
	}

	@SuppressWarnings("static-access")
	private static String getValue(Cell cell) {
		if (cell == null) {
			return null;
		}
		if (cell.getCellType() == cell.CELL_TYPE_BOOLEAN) {
			return String.valueOf(cell.getBooleanCellValue());
		} else if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
			if (DateUtil.isCellDateFormatted(cell)){
				return String.valueOf(DateTime.ToDate(cell.getDateCellValue(), "yyyy/MM/dd"));
			}
			return String.valueOf(cell.getNumericCellValue());
		} else if (cell.getCellType() == cell.CELL_TYPE_STRING) {
			return String.valueOf(cell.getStringCellValue());
		} else {
			return String.valueOf(cell.getDateCellValue());
		}
	}

	public static boolean validate(File file, InputStream stream) throws Exception {
		boolean result = false;
		if (file != null && stream != null) {
			byte[] b = new byte[4];
			stream.read(b, 0, b.length);
			String head = bytesToHexString(b);
			if ((file.getName().endsWith(excel_suffix_9703) || file.getName().endsWith(excel_suffix_2007))
					&& (head.contains(excel_fileType_9703) || head.contains(excel_fileType_2007))) {
				result = true;
			} else {
				throw new Exception("上传的文件格式存在异常，请上传Excel文件！");
			}
		}
		return result;
	}

	/**
	 * byte数组转换成16进制字符串
	 * 
	 * @param src
	 * @return
	 */
	public static String bytesToHexString(byte[] src) {
		StringBuilder stringBuilder = new StringBuilder();
		if (src == null || src.length <= 0) {
			return null;
		}
		for (int i = 0; i < src.length; i++) {
			int v = src[i] & 0xFF;
			String hv = Integer.toHexString(v);
			if (hv.length() < 2) {
				stringBuilder.append(0);
			}
			stringBuilder.append(hv);
		}
		return stringBuilder.toString();
	}

	private static Object convert(String type, String s) throws Exception {
		Object result = s;
		if (type.equals("long")) {
			result = Long.valueOf(s);
		}
		if (type.equals("java.lang.Integer") || type.equals("int")) {
			float f = Float.valueOf(s);
			if (f % 1 != 0) {
				throw new Exception(String.format("数值%s不是一个整数，请输入整数！", s));
			}
			result = (int) f;
		}
		return result;
	}
}
