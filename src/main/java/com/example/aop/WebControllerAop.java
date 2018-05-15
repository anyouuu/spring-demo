package com.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import java.util.Arrays;
import java.util.logging.Logger;
//import java.util.logging.

@Aspect
@Component
public class WebControllerAop {

//    private final static Logger LOGGER = LoggerFactory.getLogger(WebControllerAop.class);

    @Pointcut("execution(* com.example.controller..*.*(..))")
    public void executeService(){
        System.out.println(1);
    }

    /**
     * 前置通知，方法调用前被调用
     * @param joinPoint
     */
    @Before("executeService()")
    public void doBeforeAdvice(JoinPoint joinPoint) throws Throwable {
        System.out.println("我是前置通知!!!");
        //获取目标方法的参数信息
        Object[] obj = joinPoint.getArgs();
        //AOP代理类的信息
        joinPoint.getThis();
        //代理的目标对象
        joinPoint.getTarget();


        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        HttpServletRequest request =  attributes.getRequest();
        System.out.println("URL : " + request.getRequestURL().toString());
        System.out.println("HTTP_METHOD : " + request.getMethod());
        System.out.println("IP : " + request.getRemoteAddr());
        System.out.println("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        System.out.println("ARGS : " + Arrays.toString(joinPoint.getArgs()));

//        //用的最多 通知的签名
//        Signature signature = joinPoint.getSignature();
//        //代理的是哪一个方法
//        System.out.println(signature.getName());
//        //AOP代理类的名字
//        System.out.println(signature.getDeclaringTypeName());
//        //AOP代理类的类（class）信息
//        signature.getDeclaringType();
//        //获取RequestAttributes
//        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
//        //从获取RequestAttributes中获取HttpServletRequest的信息
//        HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
//        //如果要获取Session信息的话，可以这样写：
//        //HttpSession session = (HttpSession) requestAttributes.resolveReference(RequestAttributes.REFERENCE_SESSION);
//        Enumeration<String> enumeration = request.getParameterNames();
//        Map<String,String> parameterMap = Maps.newHashMap();
//        while (enumeration.hasMoreElements()){
//            String parameter = enumeration.nextElement();
//            parameterMap.put(parameter,request.getParameter(parameter));
//        }
//        String str = JSON.toJSONString(parameterMap);
//        if(obj.length > 0) {
//            System.out.println("请求的参数信息为："+str);
//        }
    }

    @AfterReturning(value = "execution(* com.example.controller..*.*(..))", returning = "keys")
    public void doAfterReturning(JoinPoint joinPoint, Object keys) {

        System.out.println("do after string: "+keys);
    }

    @AfterReturning(value = "execution(* com.example.controller..*.*(..))", returning = "keys", argNames = "keys")
    public void doAfterReturning1(int keys) {
        System.out.println("do after int: "+keys);
    }



    @AfterThrowing(throwing = "ex", pointcut = "execution(* com.example.controller..*.*(..))")
    public void throwws(JoinPoint jp, Exception ex) {

        System.out.println("方法异常时执行....." + jp.toString());
        System.out.println("方法异常时执行....." + ex.getMessage());
    }

    @After("executeService()")
    public void after(JoinPoint jp){
        System.out.println("方法最后执行.....");
    }

    @Around("executeService()")
    public Object aaround(ProceedingJoinPoint pjp){
        System.out.println("方法环绕start.....");
        try {
            Object o = pjp.proceed();
            System.out.println("方法环绕proceed，结果是 :" + o);
            return o;
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
    }



}
