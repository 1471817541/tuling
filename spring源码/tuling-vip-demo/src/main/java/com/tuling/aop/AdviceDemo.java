package com.tuling.aop;

import com.tuling.UserService;
import com.tuling.aop.advice.ZhouyuBeforeAdvise;
import org.aopalliance.aop.Advice;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

/**
 * @author 周瑜
 */
public class AdviceDemo {

	public static void main(String[] args) {
		UserService userService = new UserService();
		ProxyFactory proxyFactory = new ProxyFactory(userService);
		proxyFactory.setProxyTargetClass(true);
//		proxyFactory.addAdvice(new ZhouyuBeforeAdvise());
		proxyFactory.addAdvisor(new PointcutAdvisor() {
			@Override
			public Pointcut getPointcut() {
				return new Pointcut() {
					@Override
					public ClassFilter getClassFilter() {
						return new ClassFilter() {
							@Override
							public boolean matches(Class<?> clazz) {
								return true;
							}
						};
					}

					@Override
					public MethodMatcher getMethodMatcher() {
						return new MethodMatcher() {
							@Override
							public boolean matches(Method method, Class<?> targetClass) {
								return true;
							}

							@Override
							public boolean isRuntime() {
								return true;
							}

							@Override
							public boolean matches(Method method, Class<?> targetClass, Object... args) {
								return args[0].equals("zhouyu");
							}
						};
					}
				};
			}

			@Override
			public Advice getAdvice() {
				return new ZhouyuBeforeAdvise();
			}

			@Override
			public boolean isPerInstance() {
				return false;
			}
		});
//		proxyFactory.addAdvice(new ZhouyuAfterReturningAdvise());
//		proxyFactory.addAdvice(new ZhouyuThrowsAdvice());
//		proxyFactory.addAdvice(new ZhouyuAroundAdvise());
		UserService proxy = (UserService) proxyFactory.getProxy();
		proxy.test("zhouyu123");
	}
}
