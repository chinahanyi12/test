package sousou;

import java.util.ArrayList;
import java.util.Scanner;

//后台，由操作系统选择执行的操作，后台反应相应的结果
public class Background {
    Scanner scanner = new Scanner(System.in);

    //定义一个集合存储用户信息
    ArrayList<Person>arrayList = new ArrayList<>();

    //给集合中先创建几个用户
    public void create(){
        Person person1 = new Person("13912341234","123","话痨套餐","王五",100,68);
        Person person2 = new Person("13912312312","123","网虫套餐","李四",200,78);
        Person person3 = new Person("13912345678","123","超人套餐","张三",300,88);
        arrayList.add(person1);
        arrayList.add(person2);
        arrayList.add(person3);
    }

    //用户登录的方法
    public boolean login(String phone,String key){
        for(int a = 0;a<arrayList.size();a++){
            if(arrayList.get(a).getPhone().equals(phone)&&arrayList.get(a).getKey().equals(key)){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }

    //手机号注册
    public void enroll(){
        String [] phones = new String[9];
        int c = 1;
        for(int i = 1;i<=3;i++) {
            for (int a = 1; a <= 3; a++) {
                long b = 13900000000l;
                String phone = null;
                boolean flag = false;
                do {
                    phone = (long) (Math.random() * 100000000) + b + "";
                    for (int j = 0; j < arrayList.size(); j++) {
                        if (phone.equals(arrayList.get(j).getKey())) {
                            for(int k = 0;k< phones.length;k++){
                                if(phones[k].equals(phone)){
                                    flag = true;
                                    break;
                                }
                            }
                        } else {
                            flag = false;
                        }
                    }
                } while (flag);
                phones[c-1] = phone;
                System.out.print(c + "." + phone + "  ");
                c++;
            }
            System.out.println();
        }
        System.out.println("请输入你要选择的卡号（1-9）");
        int num = scanner.nextInt();
        System.out.println("1.话痨套餐 2.网虫套餐 3.超人套餐， 请选择套餐（输入序号）");
        int choose = scanner.nextInt();
        switch (choose){
            case 1:
                System.out.println("请输入姓名");
                String name = scanner.next();
                System.out.println("请输入密码");
                String key = scanner.next();
                System.out.println("请输入预存话费金额");
                int money = scanner.nextInt();
                if(money<58){
                    do{
                        System.out.println("你预存的手机话费不够本月的固定套餐费，请重新充值");
                        money = scanner.nextInt();
                    }while(money<58);
                }
                Person person = new Person(phones[num-1],key,"话痨套餐",name,money-58,58);
                System.out.println("注册成！卡号："+phones[num-1]+"用户名:"+name+" 当前余额:"+(money-58)+"。");
                System.out.println("话痨套餐:通话时间500分钟/月,短信条数30条/月，无上网流量");
                break;
            case 2:
                System.out.println("请输入姓名");
                name = scanner.next();
                System.out.println("请输入密码");
                key = scanner.next();
                System.out.println("请输入预存话费金额");
                money = scanner.nextInt();
                if(money<68){
                    do{
                        System.out.println("你预存的手机话费不够本月的固定套餐费，请重新充值");
                        money = scanner.nextInt();
                    }while(money<68);
                }
                person = new Person(phones[num-1],key,"话痨套餐",name,money-68,68);
                System.out.println("注册成！卡号："+phones[num-1]+"用户名:"+name+" 当前余额:"+(money-68)+"。");
                System.out.println("话痨套餐:通话时间无,短信条数无，上网流量3GB/月");
                break;
            case 3:
                System.out.println("请输入姓名");
                name = scanner.next();
                System.out.println("请输入密码");
                key = scanner.next();
                System.out.println("请输入预存话费金额");
                money = scanner.nextInt();
                if(money<78){
                    do{
                        System.out.println("你预存的手机话费不够本月的固定套餐费，请重新充值");
                        money = scanner.nextInt();
                    }while(money<78);
                }
                person = new Person(phones[num-1],key,"话痨套餐",name,money-78,78);
                System.out.println("注册成！卡号："+phones[num-1]+"用户名:"+name+" 当前余额:"+(money-78)+"。");
                System.out.println("话痨套餐:通话时间200分钟/月,短信条数50条/月，上网流量1GB/月");
                break;
            default:
                System.out.println("你输入的套餐不存在，请重新输入");
                do{
                    System.out.println("1.话痨套餐 2.网虫套餐 3.超人套餐， 请选择套餐（输入序号）");
                    choose = scanner.nextInt();
                }while(choose>=1&&choose<=3);
                break;
        }
    }

    //本月账单查询
    public void query1(String phone,String key){
        for(int a = 0;a<arrayList.size();a++){
            if(arrayList.get(a).getPhone().equals(phone)&&arrayList.get(a).getKey().equals(key)){
                System.out.println("****本月账单查询****");
                System.out.println("您的卡号:"+phone+",当月账单:");
                if(arrayList.get(a).getPackages().equals("超人套餐")){
                    System.out.println("套餐资费:"+78+"元");
                }else if(arrayList.get(a).getPackages().equals("网虫套餐")){
                    System.out.println("套餐资费:"+68+"元");
                }else{
                    System.out.println("套餐资费:"+58+"元");
                }
                System.out.println("合计:"+arrayList.get(a).getUse());
                System.out.println("账户余额:"+arrayList.get(a).getMoney());
            }
        }
    }

    //套餐余量查询
    public void query2(String phone,String key){
        for(int a = 0;a<arrayList.size();a++){
            if(arrayList.get(a).getPhone().equals(phone)&&arrayList.get(a).getKey().equals(key)){
                System.out.println("****套餐余量查询****");
                System.out.println("您的卡号:"+phone+",套餐内剩余:");
                if(arrayList.get(a).getPackages().equals("超人套餐")){
                    System.out.println("套餐资费:"+78+"元");
                    System.out.println("短信条数:"+50+"条");
                    System.out.println("上网流量:"+1+"GB");
                }else if(arrayList.get(a).getPackages().equals("网虫套餐")){
                    System.out.println("套餐资费:"+68+"元");
                    System.out.println("短信条数:"+0+"条");
                    System.out.println("上网流量:"+3+"GB");
                }else{
                    System.out.println("套餐资费:"+58+"元");
                    System.out.println("短信条数:"+50+"条");
                    System.out.println("上网流量:"+1+"GB");
                }
            }
        }
    }
}
