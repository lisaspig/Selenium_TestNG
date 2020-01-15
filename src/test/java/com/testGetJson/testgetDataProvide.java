
package com.testGetJson;

import mockit.Expectations;

import mockit.Injectable;
import mockit.Mocked;

import mockit.Verifications;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;


public class testgetDataProvide {


    @Test
    public void test (@Mocked getDataProvider Dp){
        Map<String,Object> map = new HashMap<>();
        map.put("test","test");
        Object[][]array = new Object[][]{{"test"},{"test"}};
        new Expectations(){
            {
                Dp.myDataProvider(map);
                result =array;
            }
        };

        System.out.println("test");
    new Verifications(){
        {
            Dp.myDataProvider(map);
            times = 1;
        }
    };
    }

}
