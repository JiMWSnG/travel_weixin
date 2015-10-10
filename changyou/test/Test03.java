import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.peanutbox.service.D_SmartBoxCellService;

public class Test03 {
	public static void main(String[] args) {
		BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext-smartbox-all.xml");
		D_SmartBoxCellService sbsService = (D_SmartBoxCellService)factory.getBean("smartBoxCellService");
		String sbs = sbsService.querySmartBoxCellsBySmartBoxId("{\"smartBoxId\":2}");
		System.out.println(sbs);
	}
}
