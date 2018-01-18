package Activemq.springboot.mq.entity;

/**
 * @classDesc： 功能描述：（实体类）
 * @author：王武
 * @createTime 2018/1/18
 * @verson: v1.0
 * @copyright: 上海苹果教育科技有限公司
 */
public class UserEntity {
    private Long id;
    private String name;
    private Integer age;

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public UserEntity(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
