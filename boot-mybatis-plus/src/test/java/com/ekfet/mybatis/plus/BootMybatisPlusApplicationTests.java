package com.ekfet.mybatis.plus;

import com.ekfet.mybatis.plus.mapper.UserMapper;
import com.ekfet.mybatis.plus.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootMybatisPlusApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }
    @Test
    public  void testPageList(){
        System.out.println(("----- selectAll method test ------"));
        User user=new User();
        user.setAge(11);
        user.setEmail("lxfeif1234@1234.com");
        user.setName("luobo");
        userMapper.insert(user);

        Map<String,Object> paramsMap=new HashMap<>();
        paramsMap.put("name","luobo");
        List<User> list= userMapper.selectByMap(paramsMap);
        System.out.println(list.get(0).getName());
        Assert.assertEquals(list.get(0).getName(),"luobo");


    }
}
