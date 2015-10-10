import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.peanutbox.service.B_BuyerOperationService;
import com.peanutbox.util.ClientUtil;
import com.peanutbox.util.JsonUtil;

public class TestHttpClient {
	public static void main(String[] args) {
		String respMessage = ClientUtil.exchange("0","http://192.168.0.2:8088/agentNodeServer/heartBeatDetect");
		System.out.println(respMessage);
	}
}
