package SpringIOC;



import org.aspectj.lang.annotation.Aspect;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.List;

/**
 * @classDesc： 功能描述：（IOC底层实现原理）
 * @author：王武
 * @createTime 2018/1/27
 * @verson: v1.0
 * @copyright: 上海苹果教育科技有限公司
 */
@Aspect
public class ClassPathXmlApplicationContext {
    public String path;
    public ClassPathXmlApplicationContext(String path) {
        this.path=path;
    }

    public Object getBean(String beanId) throws DocumentException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(this.path);
        SAXReader sax = new SAXReader();
        Document read = sax.read(resourceAsStream);
        Element rootElement = read.getRootElement();
        Object o =null;
        List<Element> elements =rootElement.elements();
        for (Element sonEle : elements) {
            String sonBeanId = sonEle.attributeValue("id");
            if (!beanId.equals(sonBeanId)) {
                continue;
            }
            String aClass = sonEle.attributeValue("class");
            Class<?> forName = Class.forName(aClass);
             o = forName.newInstance();
            List<Element> grandSonEle = sonEle.elements();
            for (Element element : grandSonEle) {
                String name = element.attributeValue("name");
                String value = element.attributeValue("value");
                Field field = forName.getDeclaredField(name);
                field.setAccessible(true);
                field.set(o,value);
            }
        }
        return o;


    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, InstantiationException, DocumentException, IllegalAccessException {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("user.xml");
        User user1 = (User) classPathXmlApplicationContext.getBean("user1");
        System.out.println("id:"+user1.getId()
                +"-----"+"name:"+user1.getName());
    }
}
