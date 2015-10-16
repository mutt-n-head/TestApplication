/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.ssa.ere.bean.interceptors;

import java.util.ArrayList;
import java.util.List;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class SampleInterceptor {
    @AroundInvoke
    public Object interceptorMethod(InvocationContext _iCtxt) throws Exception {
        Object[] parms = _iCtxt.getParameters();
        List<Object> parmList = new ArrayList<>();

        for (Object parm : parms) {
            if (parm instanceof String) {
                parmList.add(((String) parm).toUpperCase());
            } else {
                parmList.add(parm);
            }
        }

        _iCtxt.setParameters(parmList.toArray(parms));
        return _iCtxt.proceed();
    }
}
