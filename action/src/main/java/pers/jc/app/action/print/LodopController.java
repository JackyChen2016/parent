package pers.jc.app.action.print;

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public class LodopController {
	String lodopPath;

	public void setLodopPath(String lodopPath) {
		this.lodopPath = lodopPath;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<byte[]> lodop() throws IOException {
		ResourceLoader resourceLoader = new PathMatchingResourcePatternResolver();
		Resource resource = resourceLoader.getResource(lodopPath);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", resource.getFilename());
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(resource.getFile()), headers,
				HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Object getLodop() {
		Object result = null;
		result = "LODOP.PRINT_INITA(10,10,762,533,'打印控件功能演示LODOP功能_移动公司发票全样');"
				+ "LODOP.SET_PRINT_STYLE('FontColor','#0000FF');"
				+ "LODOP.ADD_PRINT_SHAPE(2,116,43,655,373,0,1,'#800000');"
				+ "LODOP.ADD_PRINT_SHAPE(1,144,44,653,1,0,1,'#800000');"
				+ "LODOP.ADD_PRINT_SHAPE(1,172,44,653,1,0,1,'#800000');"
				+ "LODOP.ADD_PRINT_SHAPE(0,116,143,1,56,0,1,'#800000');"
				+ "LODOP.ADD_PRINT_SHAPE(0,116,488,1,56,0,1,'#800000');"
				+ "LODOP.ADD_PRINT_SHAPE(0,116,574,1,372,0,1,'#800000');"
				+ "LODOP.ADD_PRINT_SHAPE(0,172,166,1,282,0,1,'#800000');"
				+ "LODOP.ADD_PRINT_SHAPE(0,172,415,1,282,0,1,'#800000');"
				+ "LODOP.ADD_PRINT_SHAPE(1,454,44,653,1,0,1,'#800000');"
				+ "LODOP.ADD_PRINT_SHAPE(0,454,130,1,34,0,1,'#800000');"
				+ "LODOP.ADD_PRINT_SHAPE(0,454,483,1,34,0,1,'#800000');"
				+ "LODOP.ADD_PRINT_SHAPE(0,64,62,120,1,0,1,'#0000FF');"
				+ "LODOP.ADD_PRINT_SHAPE(3,29,62,32,32,0,4,'#0000FF');"
				+ "LODOP.ADD_PRINT_SHAPE(3,21,300,147,75,0,3,'#FF0000');"
				+ "LODOP.ADD_PRINT_SHAPE(3,26,307,132,65,0,1,'#FF0000');"
				+ "LODOP.ADD_PRINT_TEXT(33,192,408,30,'中国移动通信集团北京有限公司专用发票');"
				+ "LODOP.SET_PRINT_STYLEA(0,'FontSize',15);" + "LODOP.SET_PRINT_STYLEA(0,'FontColor','#800000');"
				+ "LODOP.SET_PRINT_STYLEA(0,'Alignment',2);" + "LODOP.ADD_PRINT_TEXT(68,326,100,25,'发 票 联');"
				+ "LODOP.SET_PRINT_STYLEA(0,'FontSize',11);" + "LODOP.SET_PRINT_STYLEA(0,'FontColor','#800000');"
				+ "LODOP.SET_PRINT_STYLEA(0,'Alignment',2);" + "LODOP.ADD_PRINT_TEXT(29,98,84,35,'中国移动通信CHINA MOBILE');"
				+ "LODOP.ADD_PRINT_SHAPE(2,37,69,18,15,0,1,'#0000FF');"
				+ "LODOP.ADD_PRINT_SHAPE(2,40,73,10,9,0,1,'#0000FF');"
				+ "LODOP.ADD_PRINT_TEXT(70,64,117,20,'移 动 信 息 专 家');" + "LODOP.SET_PRINT_STYLEA(0,'FontSize',8);"
				+ "LODOP.SET_PRINT_STYLEA(0,'Alignment',2);" + "LODOP.ADD_PRINT_TEXT(124,58,68,20,'客户名称');"
				+ "LODOP.SET_PRINT_STYLEA(0,'FontColor','#800000');" + "LODOP.SET_PRINT_STYLEA(0,'Alignment',2);"
				+ "LODOP.ADD_PRINT_TEXT(152,58,68,20,'手机号码');" + "LODOP.SET_PRINT_STYLEA(0,'FontColor','#800000');"
				+ "LODOP.SET_PRINT_STYLEA(0,'Alignment',2);" + "LODOP.ADD_PRINT_TEXT(124,497,68,20,'受理类别');"
				+ "LODOP.SET_PRINT_STYLEA(0,'FontColor','#800000');" + "LODOP.SET_PRINT_STYLEA(0,'Alignment',2);"
				+ "LODOP.ADD_PRINT_TEXT(152,497,68,20,'合 同 号');" + "LODOP.SET_PRINT_STYLEA(0,'FontColor','#800000');"
				+ "LODOP.SET_PRINT_STYLEA(0,'Alignment',2);" + "LODOP.ADD_PRINT_TEXT(465,54,68,20,'大写金额');"
				+ "LODOP.SET_PRINT_STYLEA(0,'FontColor','#800000');" + "LODOP.SET_PRINT_STYLEA(0,'Alignment',2);"
				+ "LODOP.ADD_PRINT_TEXT(465,495,104,20,'小写金额    ￥: ');" + "LODOP.NewPage();"
				+ "LODOP.SET_PRINT_STYLEA(0,'FontColor','#800000');" + "LODOP.SET_PRINT_STYLEA(0,'Alignment',3);"
				+ "LODOP.ADD_PRINT_TEXT(98,56,47,20,'编号：');" + "LODOP.SET_PRINT_STYLEA(0,'FontColor','#800000');"
				+ "LODOP.SET_PRINT_STYLEA(0,'Alignment',3);" + "LODOP.ADD_PRINT_TEXT(98,259,48,20,'日期：');"
				+ "LODOP.SET_PRINT_STYLEA(0,'FontColor','#800000');" + "LODOP.SET_PRINT_STYLEA(0,'Alignment',3);"
				+ "LODOP.ADD_PRINT_TEXT(97,500,71,20,'发票号码：');" + "LODOP.SET_PRINT_STYLEA(0,'FontColor','#800000');"
				+ "LODOP.SET_PRINT_STYLEA(0,'Alignment',3);" + "LODOP.ADD_PRINT_TEXT(496,54,83,20,'话费帐期：');"
				+ "LODOP.SET_PRINT_STYLEA(0,'FontColor','#800000');" + "LODOP.SET_PRINT_STYLEA(0,'Alignment',3);"
				+ "LODOP.ADD_PRINT_TEXT(496,321,83,20,'营业员工号：');" + "LODOP.SET_PRINT_STYLEA(0,'FontColor','#800000');"
				+ "LODOP.SET_PRINT_STYLEA(0,'Alignment',3);" + "LODOP.ADD_PRINT_TEXT(496,480,93,20,'收款单位名称：');"
				+ "LODOP.SET_PRINT_STYLEA(0,'FontColor','#800000');" + "LODOP.SET_PRINT_STYLEA(0,'Alignment',3);"
				+ "LODOP.ADD_PRINT_TEXT(226,703,27,121,'第二联发票联');" + "LODOP.SET_PRINT_STYLEA(0,'FontColor','#800000');"
				+ "LODOP.SET_PRINT_STYLEA(0,'Alignment',2);" + "LODOP.ADD_PRINT_TEXT(203,21,17,195,'京地税准印八九号五百万份');"
				+ "LODOP.SET_PRINT_STYLEA(0,'FontSize',8);" + "LODOP.SET_PRINT_STYLEA(0,'FontColor','#800000');"
				+ "LODOP.SET_PRINT_STYLEA(0,'Alignment',2);" + "LODOP.ADD_PRINT_TEXT(126,150,100,20,'郭德强');"
				+ "LODOP.ADD_PRINT_TEXT(151,150,100,20,'13954885188');"
				+ "LODOP.ADD_PRINT_TEXT(125,584,99,20,'发票打印(第1次)');"
				+ "LODOP.ADD_PRINT_TEXT(465,140,198,20,'陆百柒拾捌元叁角零分');" + "LODOP.ADD_PRINT_TEXT(465,599,70,20,'678.30');"
				+ "LODOP.ADD_PRINT_TEXT(496,408,59,20,'H112063');" + "LODOP.ADD_PRINT_TEXT(191,58,100,20,'国内漫游通话');"
				+ "LODOP.ADD_PRINT_TEXT(191,217,100,20,'584.00');" + "LODOP.ADD_PRINT_TEXT(222,58,100,20,'增值业务费');"
				+ "LODOP.ADD_PRINT_TEXT(222,217,100,20,'48.30');" + "LODOP.ADD_PRINT_TEXT(251,58,100,20,'代收费');"
				+ "LODOP.ADD_PRINT_TEXT(251,217,100,20,'50.00');" + "LODOP.ADD_PRINT_TEXT(280,58,100,20,'优惠费');"
				+ "LODOP.ADD_PRINT_TEXT(280,217,100,20,'4.00');"
				+ "LODOP.ADD_PRINT_TEXT(98,101,150,20,'101081005747319387');"
				+ "LODOP.ADD_PRINT_TEXT(97,307,150,20,'2008年10月19日 10:28:38');"
				+ "LODOP.ADD_PRINT_TEXT(152,584,103,20,'138860016786');"
				+ "LODOP.ADD_PRINT_TEXT(95,571,112,20,'06775516');" + "LODOP.SET_PRINT_STYLEA(0,'FontName','System');"
				+ "LODOP.ADD_PRINT_TEXT(76,500,71,20,'发票代码：');" + "LODOP.SET_PRINT_STYLEA(0,'FontColor','#800000');"
				+ "LODOP.SET_PRINT_STYLEA(0,'Alignment',3);" + "LODOP.ADD_PRINT_TEXT(74,571,112,20,'237090742401');"
				+ "LODOP.SET_PRINT_STYLEA(0,'FontName','System');" + "LODOP.SET_PRINT_STYLEA(0,'FontColor','#FF0000');"
				+ "LODOP.ADD_PRINT_TEXT(496,135,183,20,'2008年09月(20080901-20080930)');"
				+ "LODOP.ADD_PRINT_TEXT(496,572,112,20,'-王府井中心店营');" + "LODOP.ADD_PRINT_TEXT(311,217,100,20,'678.30');"
				+ "LODOP.ADD_PRINT_TEXT(311,58,100,20,'费用合计');";
		return result;
	}
}
