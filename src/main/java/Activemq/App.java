package Activemq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @classDesc： 功能描述：（启动类）
 * @author：王武
 * @createTime 2018/1/18
 * @verson: v1.0
 * @copyright: 上海苹果教育科技有限公司
 */
@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class App {
     public static void main(String[] args){
         SpringApplication.run(App.class,args);
      }
}
