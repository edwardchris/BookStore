package cn.les.entity;

/**
 * @author hx
 * @description TUser
 * @create 2017-11-10 10:10
 **/
public class TUser {
    private String uName;
    private String pwd;
    private int role;

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
