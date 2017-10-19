package cn.yearcon.shop.entity;



import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity //标识这是一个实体类
public class User implements Serializable {
    @Id
    private String id;
    private String userName;
    private String passWord;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
