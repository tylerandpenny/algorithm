package service.Proxy;

import java.lang.reflect.Proxy;

/**
 * 动态代理类
 *
 */
public class ProxyClass {

    /**
     * 获取真实代理类
     * @param target
     * @return
     */
    public static Object getProxy(Object target){
        Object proxy = Proxy.newProxyInstance(
                target.getClass().getClassLoader(), // 目标类的类加载器
                target.getClass().getInterfaces(), // 代理要实现的接口，可多个，数组
                new TargetInvoker(target) // 代理对象处理器
        );
        return proxy;
    }
}
