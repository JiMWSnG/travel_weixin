import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.peanutbox.bean.SysUser;
import com.peanutbox.service.D_SysUserService;

public class Test05 {
	public static void main(String[] args) {
		BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext-smartbox-all.xml");
		D_SysUserService service = (D_SysUserService)factory.getBean("sysUserService");
		SysUser sysUser = service.querySysUserByUserAccount("18010181009");	
		System.out.println(sysUser.getPassword());
	}
}
