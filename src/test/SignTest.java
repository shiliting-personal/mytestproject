package test;

import com.sj.ilaoshi.service.SecurityService;
import com.sj.ilaoshi.service.impl.SecurityServiceImpl;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/28.
 */
public class SignTest {
    private SecurityService securityService=new SecurityServiceImpl();

    @Test
    public void signTest() throws Exception{
        String key="123456";
        Map<String,String> map=new HashMap<String, String>();
        map.put("aa","11");
        map.put("bb","22");
        map.put("ba","33");
        map.put("ab","44");
        String sgin=securityService.getSign(map,key);


    };

}
