package ro.teamnet.zth.web;

import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;
import ro.teamnet.zth.appl.controller.DepartmentController;
import ro.teamnet.zth.appl.controller.EmployeeController;
import ro.teamnet.zth.fmk.AnnotationScanUtils;
import ro.teamnet.zth.fmk.MethodAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * Created by user on 7/14/2016.
 */
public class DispatcherServlet extends HttpServlet {
    //registru
    //key: urlPath
    //value: informatii despre metode
    HashMap<String, MethodAttributes> allowedMethods=new HashMap<>();

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            Iterable<Class> controllers= AnnotationScanUtils.getClasses("ro.teamnet.zth.appl.controller");
            for(Class controller:controllers){
                if(controller.isAnnotationPresent(MyController.class)){
                    MyController myCtrlAnnotation= (MyController) controller.getAnnotation(MyController.class);
                    String controllerPath=myCtrlAnnotation.urlPath();
                    Method[] methods=controller.getMethods();
                    for(Method method:methods){
                        if(method.isAnnotationPresent(MyRequestMethod.class)){
                            MyRequestMethod mrm=method.getAnnotation(MyRequestMethod.class);
                            String methodUrl=mrm.urlPath();
                            //key for hashmap
                            String urlPath=controllerPath+methodUrl;
                            MethodAttributes methodAttributes=new MethodAttributes();
                            methodAttributes.setControllerClass(controller.getName());
                            methodAttributes.setMethodType(mrm.methodType());
                            methodAttributes.setMethodName(method.getName());

                            allowedMethods.put(urlPath,methodAttributes);
                        }
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dispatchReply("POST",req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dispatchReply("GET",req,resp);
    }

    private  void dispatchReply(String method,HttpServletRequest req, HttpServletResponse resp){
        try {
            Object result = dispatch(req, resp);
            reply(result, req, resp);
        }catch(Exception e){
            sendExceptionError(e, req, resp);
        }

    }

    private void sendExceptionError(Exception e, HttpServletRequest req, HttpServletResponse resp) {
    }

    private void reply(Object result, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().write(result.toString());
    }

    private Object dispatch(HttpServletRequest req, HttpServletResponse resp) {
        String pathinfo=req.getPathInfo();


        try {
            MethodAttributes ms=allowedMethods.get(pathinfo);
            if(ms==null){return "hello";}

            Class controllerClass=Class.forName(ms.getControllerClass());
            Object controllerInstance=controllerClass.newInstance();
            Method theMethod=controllerClass.getMethod(ms.getMethodName());
            return theMethod.invoke(controllerInstance).toString();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        /*if(pathinfo.startsWith("/employees")){
            EmployeeController employeeController=new EmployeeController();
            String result=employeeController.getAllEmployees();
            return  result;
        }
        if(pathinfo.startsWith("/departments")){
            DepartmentController departmentController=new DepartmentController();
            return departmentController.getAllDepartments();
        }*/
        return "Hello";
    }
}
