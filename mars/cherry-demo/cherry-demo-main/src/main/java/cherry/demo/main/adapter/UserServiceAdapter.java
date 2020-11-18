//package cherry.demo.main.adapter;
//
//import cherry.demo.api.UserService;
//import cherry.demo.api.model.User;
//import cherry.demo.main.annotation.MutiTenantMethod;
//import cherry.demo.main.annotation.MutiTenantType;
//import org.springframework.context.annotation.Primary;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import java.util.List;
//
///**
// * @Author Mars
// * @Date 2020/11/18 9:57
// * @Version 1.0
// */
//
//@Component
//@Primary
//@MutiTenantType(value = "userService")
//public class UserServiceAdapter implements UserService {
//
//    @PostConstruct
//    public void initBean(){
//        System.out.println("initBean");
//    }
//
//    @Override
////    @MutiTenantMethod
//    public User getUser(String name) {
//        System.out.println();
//        return new User();
//    }
//
//    @Override
//    public List<User> getUsers() {
//        return null;
//    }
//
//    @Override
//    public int insert(User user) {
//        return 0;
//    }
//
////    @Override
////    public void init(PluginConfig config) {
////
////    }
////
////    @Override
////    public void destroy() {
////
////    }
//}
