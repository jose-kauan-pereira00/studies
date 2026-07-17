package basic;

public class SwitchCase{
    public static void main(String[] args){
        int x = 0, k = 4;
        switch (k){
            case 1: x = x + 1;
            break;
            case 2: x = x + 90;
            break;
            default: x = x + 1000;
        }
        System.out.println(x);
    }
}
