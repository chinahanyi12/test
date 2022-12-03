package sousou;

public class Person {
    //手机号
    private String phone;
    //密码
    private String key;
    //套餐
    private String packages;
    //姓名
    private String name;
    //余额
    private int money;

    public double getUse() {
        return use;
    }

    public void setUse(double use) {
        this.use = use;
    }

    //当月消费
    private double use;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getPackages() {
        return packages;
    }

    public void setPackages(String packages) {
        this.packages = packages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Person() {
    }

    public Person(String phone, String key, String packages, String name, int money, double use) {
        this.phone = phone;
        this.key = key;
        this.packages = packages;
        this.name = name;
        this.money = money;
        this.use = use;
    }
}
