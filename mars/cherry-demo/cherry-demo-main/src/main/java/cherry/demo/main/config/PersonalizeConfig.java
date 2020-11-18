package cherry.demo.main.config;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Mars
 * @Date 2020/11/18 15:56
 * @Version 1.0
 */
public class PersonalizeConfig {

    private Integer tenantCode = 100000;

    private Map<String,String> interfaceMap = new HashMap<>();


    public Integer getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(Integer tenantCode) {
        this.tenantCode = tenantCode;
    }

    public Map<String, String> getInterfaceMap() {
        return interfaceMap;
    }

    public void setInterfaceMap(Map<String, String> interfaceMap) {
        this.interfaceMap = interfaceMap;
    }
}

