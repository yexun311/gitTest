package com.ye;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.fill.FillConfig;
import com.ye.common.util.AesCBCUtil;
import com.ye.model.entity.UserEntity;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.System.*;

@SpringBootTest
class SpringbootApplicationTests {

    @Test
    void contextLoads() {
    }

    /**
     *
     * 获取当前时间
     */
    @Test
    void myTest2(){
        System.out.println("-----System-----");
        System.out.println(System.currentTimeMillis());

        System.out.println("-----Date-----");
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(date));

        System.out.println("-----Calendar-----");
        Date calendar = Calendar.getInstance().getTime();
        System.out.println(calendar);

        System.out.println("-----LocalDate-----");
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        System.out.println("-----LocalTime-----");
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);

        System.out.println("-----LocalDateTime-----");
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

    }

    @Test
    void myTest1(){

    }

    @Test
    void myTest3(){
        String version = "1.2.3";
        StringBuilder str = new StringBuilder();
        for (String s : version.split("\\."))
            str.append(s);
        Integer i = Integer.parseInt(str.toString());
        System.out.println(i.getClass() + "\n" + i);
    }

    @Test
    void myTest4(){
        Date date = new Date();
        System.out.println(date);
    }

    @Test
    void easyExcelTest() throws IOException {
        /*
         * easyExcel 导出 excel 表， 模板实现导出指定对象或 map 和对象列表
         * 也可以导出为返回流
         * easyExcel文档: https://easyexcel.opensource.alibaba.com/docs/current/quickstart/fill
         * 导出参考: https://blog.csdn.net/qq_53804496/article/details/126159181
         */
        String templateFileName = new ClassPathResource("excel/template/excelTemplate.xlsx").getFile().getPath();
        String fileName = "output.xlsx";

        ClassPathResource classPathResource = new ClassPathResource("excel/template/excelTemplate.xlsx");
        InputStream inputStream = null;

        ExcelWriter excelWriter = null;

        Map<String, Object> map = new HashMap<>();
        map.put("name", "张三");
        map.put("password", "111");

        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            User user = new User();
            user.sethobby(i + "");
            user.setName("456");
            userList.add(user);
        }

        //EasyExcel.write(fileName).withTemplate(templateFileName).sheet().doFill(map);
        try{
            inputStream = classPathResource.getInputStream();

            excelWriter = EasyExcel.write(fileName).withTemplate(inputStream).build();
            WriteSheet writeSheet = EasyExcel.writerSheet().build();
            FillConfig fillConfig = FillConfig.builder().forceNewRow(Boolean.TRUE).build();
            excelWriter.fill(userList, fillConfig, writeSheet);
            excelWriter.fill(map, writeSheet);
            excelWriter.finish();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (excelWriter != null)
                excelWriter.finish();
            if (inputStream != null)
                inputStream.close();
        }


    }
    static class User{
        private String hobby;
        private String name;
        User(){}
        public void sethobby(String hobby){
            this.hobby = hobby;
        }
        public String getHobby(){
            return hobby;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }

    @Test
    public void test05(){
        String code = "1.0.1";
        System.out.println(code.replace(".", ""));
        System.out.println(StringUtils.isNumeric(code));
    }

    Logger logger = LoggerFactory.getLogger(SpringbootApplicationTests.class);

    @Test
    public void logTest(){
        List<String> strList = new ArrayList<>();
        strList.add("huhuhu${AUCTION_PRICE}lolo");
        strList.add("${AUCTION_PRICE}lplp${AUCTION_PRICE}");
        strList.add("kokokko${AUCTION_PRICE}");

        String paramName = "${AUCTION_PRICE}";
        String paramValue = "123";

        if (!CollectionUtils.isEmpty(strList)){
            List<String> resultList = strList.stream().map(item -> {
                int index = item.indexOf(paramName);
                if (index != -1){
                    item = item.substring(0, index) + paramValue + item.substring(index + paramName.length());
                }
                return item;
            }).collect(Collectors.toList());
            resultList.forEach(System.out::println);
        }
        System.out.println("--------------------");
        for (String str : strList){
            System.out.println(str.replace("${AUCTION_PRICE}", "123"));
        }
    }

    @Test
    public void encryptTest() throws Exception{
        List<String> strList = Lists.newArrayList("opop__win_price__opop", "__win_price__lplp", "kpkp__win_price__");

        // 加密价格宏替换
        String cSrc = "0101";
        System.out.println("原数据：" + cSrc);
        // 加密密钥
        String sKey = "6213FC1A2C51C632";
        String encode = AesCBCUtil.encrypt(cSrc, sKey);
        System.out.println("加密后：" + encode);
        // 加密价格替换 "__win_price__" 宏
        List<String> resultList = strList.stream().map(item -> item.replace("__win_price__", encode)).collect(Collectors.toList());
        System.out.println("解密后：" + AesCBCUtil.decrypt(encode, sKey));
        System.out.println("替换宏：__win_price__");
        System.out.println("原列表：");
        strList.forEach(System.out::println);
        System.out.println("替换加密列表：");
        resultList.forEach(System.out::println);

    }

    @Test
    public void test(){
        String str= "JkL";
        str = str.toLowerCase();
        System.out.println(str);

        String reqid = UUID.randomUUID().toString();//获取UUID
        out.println(reqid);
        reqid = reqid.replace("-","");
        System.out.println(reqid);

        List<String> list = Lists.newArrayList("1","2","3");
        out.println(String.join(",", list));
    }

    @Test
    public void test01(){
        Calendar calendar = Calendar.getInstance();
        for (int i = 0; i < 6; i++){
            int minute = calendar.get(Calendar.MINUTE);
            int start = (minute / 5) * 5;
            calendar.set(Calendar.MINUTE, start);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            System.out.println(calendar.getTime());
            calendar.add(Calendar.MINUTE, 6);
        }

        calendar.setTime(new Date());
        for (int i = 0; i < 6; i++){
            if (calendar.get(Calendar.MINUTE) < 55){
                int minute = calendar.get(Calendar.MINUTE);
                int start = (minute / 5 + 1) * 5;
                calendar.set(Calendar.MINUTE, start);
                calendar.set(Calendar.SECOND, 0);
                calendar.set(Calendar.MILLISECOND, 0);
                System.out.println(calendar.getTime());
                calendar.add(Calendar.MINUTE, 6);
            } else{
                calendar.set(Calendar.MINUTE, 0);
                calendar.set(Calendar.MILLISECOND, 0);
                calendar.add(Calendar.HOUR, 1);
                calendar.add(Calendar.MINUTE, 6);
            }

        }
    }

    @Test
    public void test02(){
        List<UserEntity> users = null;

    }

}

