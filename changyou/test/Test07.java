import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.peanutbox.service.B_BuyerOperationService;
import com.peanutbox.util.JsonUtil;

public class Test07 {
	public static void main(String[] args) {
		try {
			BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext-smartbox-all.xml");
			B_BuyerOperationService service = (B_BuyerOperationService)factory.getBean("buyerOperationService");
			Map<String,Object> reqMap = new HashMap<String,Object>();
			reqMap.put("useAccount", "18010181009");
			String reqJson = JsonUtil.obj2Json(reqMap);
			String rspJson = service.queryServiceOrderByUserAccount(reqJson);
			System.out.println(rspJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
