import com.chenjun.service.UserService;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author chenjun
 * @date 2021/10/11 14:08
 */
public class Test {
	public static void main(String[] args) {
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

		//用代码实现一个BeanDefinition对象
		AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
		beanDefinition.setScope("singleton");
		beanDefinition.setBeanClass(UserService.class);
		beanFactory.registerBeanDefinition("userService",beanDefinition);

		System.out.println(beanFactory.getBean("userService"));

	}
}
