package com.mars.k8s.user.utils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @program: k8s-demo
 * @description: cache
 * @author: Mars
 * @create: 2019-09-25 09:22
 **/
public class CacheManager {

    public static HashMap<Long, HttpServletRequest> requestHashMap = new HashMap<>();

}
