package service.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 调用处理器
 */
public class TargetInvoker implements InvocationHandler {


    // 目标类
    private Object target;

    // 构造器
    public TargetInvoker(Object target) {
        this.target = target;
    }

    /**
     *
     * @param proxy 真实代理对象
     * @param method 目标方法
     * @param args 目标方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理执行前---before");
        // 目标类实例的代理对象
        Object obj = method.invoke(target, args);
        System.out.println("代理执行后---after");
        return obj;
    }
}
