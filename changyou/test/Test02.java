import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.peanutbox.bean.SmartBox;
import com.peanutbox.dao.SmartBoxDao;
import com.peanutbox.service.D_SmartBoxService;

public class Test02 {
	public static void main(String[] args) {
		BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext-smartbox-all.xml");
		D_SmartBoxService sbService = (D_SmartBoxService)factory.getBean("smartBoxService");
		String sbs = sbService.queryAllSmartBox("");
//		System.out.println(sbs.size());
//		SmartBox sb = new SmartBox();
//		sb.setSmartBoxCode("0001");
//		sb.setSmartBoxName("test");
//		sb.setSmartBoxAddr("test");
//		sb.setSmartBoxVersion("01");
//		sb.setSmartBoxStatus("-1");
//		sb.setUpdateTime(new Date());
//		sb.setDescription("test");
//		sbDao.addSmartBox(sb);
//		System.out.println(sb.getSmartBoxId());
	}
}
