package orm;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

/**
 * @classDesc： 功能描述：（类反射实现读取注解实现自动生成sql查询语句）
 * @author：王武
 * @createTime 2018/2/28
 * @verson: v1.0
 * @copyright: 上海江豚教育科技有限公司
 * @qq:834667820
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Table{
    String value();
}
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Property{
    int length()  default 0;
    String name();
}

@Table("student")
class Student{
    @Property(name = "student_name")
    String name;
    @Property(name = "student_age")
    String age;
    @Property(name ="student_id",length = 10)
    int id;
}
public class TestORM {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> forName = Class.forName("orm.Student");
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT ");
        Field[] declaredFields = forName.getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            Field field = declaredFields[i];
            //读取属性上的注解
            Property property = field.getDeclaredAnnotation(Property.class);
            sb.append(property.name());
            if (i <declaredFields.length-1) {
                sb.append(",");
            }
        }
        sb.append(" from ");
        Table table = forName.getDeclaredAnnotation(Table.class);
         sb.append(table.value());
        System.out.println(sb.toString());
    }

}
