import java.util.Date;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.peanutbox.bean.SysUser;
import com.peanutbox.service.D_SysUserService;

public class Test06 {
	public static void main(String[] args) {
		BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext-smartbox-all.xml");
		D_SysUserService service = (D_SysUserService)factory.getBean("sysUserService");
		SysUser sysUser = new SysUser();
		sysUser.setUserAccount("15652276785");
		sysUser.setPassword("123456");
		sysUser.setPhoneNumber("15652276785");
		sysUser.setUserType("01");
		sysUser.setUserStatus("01");
		sysUser.setCreateTime(new Date());
		service.addSysUser(sysUser);
	}
}
