package sousou;

import java.util.Scanner;

//操作系统
public class OperatingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Background background = new Background();
        background.create();
        int choose = -1;
        int num = -1;
        do{
            System.out.println("*******************欢迎使用嗖嗖业务移动大厅*******************");
            System.out.println("1.用户登录 2.用户注册 3.使用嗖嗖 4.话费充值 5.资费说明 6.退出系统");
            System.out.println("请选择:");
            choose = scanner.nextInt();
            switch(choose){
                case 1:
                    System.out.println("请输入手机号");
                    String phone = scanner.next();
                    System.out.println("请输入密码");
                    String key = scanner.next();
                    if(background.login(phone,key)){
                        System.out.println("**********嗖嗖移动用户菜单**********");
                        System.out.println("1.本月账单查询");
                        System.out.println("2.套餐余量查询");
                        System.out.println("3.打印消费详单");
                        System.out.println("4.套餐变更");
                        System.out.println("5.办理退网");
                        System.out.println("请输入1-5.输入其他的返回上一级");
                        num = scanner.nextInt();
                        switch (num){
                            case 1:
                                background.query1(phone,key);
                                break;
                            case 2:
                                background.query2(phone,key);
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                            case 5:
                                break;
                            default:
                                continue;
                        }
                    }else{
                        System.out.println("你输入的手机号或密码有误");
                    }
                    break;
                case 2:
                    background.enroll();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    System.out.println("感谢你的使用，退出成功");
                    break;
                default:
                    break;
            }
        }while(choose!=6);
    }
}
