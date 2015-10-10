import java.io.IOException;
import java.io.Reader;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.peanutbox.bean.SmartBox;

public class TestDB {
	public static void main(String[] args) {
		// 创建SqlSession的工厂！
		SqlSessionFactory factory = null;
		try {
			// 通过配置文件，创建工厂对象
			Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		// 打开一个session
		SqlSession session = factory.openSession();

		try {
			SmartBox sb = new SmartBox();
			sb.setSmartBoxCode("0001");
			sb.setSmartBoxName("test");
			sb.setSmartBoxAddr("test");
			sb.setSmartBoxVersion("01");
			sb.setSmartBoxStatus("-1");
			sb.setUpdateTime(new Date());
			sb.setDescription("test");
			// 插入
			session.insert("com.peanutbox.bean.SmartBox.insert", sb);

			// 提交事务
			session.commit();

		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			// 关闭session
			session.close();
		}
	}
}
