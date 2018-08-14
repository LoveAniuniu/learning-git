import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegDemo {
    public static void main(String[] args) {
//        String str ="adbadfd222323";
//        String reg = "\\d+";
//        Pattern pattern = Pattern.compile(reg);//对正则表达式进行编译
//        Matcher matcher = pattern.matcher(str);//匹配正则表达式
//        while (matcher.find()){
//            System.out.println(matcher.group());
//        }
        String str2 = "131kmsdbesttesetjklfdj";
        String reg = ".+sd(.+)jkl(.+)";
        Pattern pattern = Pattern.compile(reg);//对正则表达式进行编译
        Matcher matcher = pattern.matcher(str2);//匹配正则表达式
        while (matcher.find()){
            System.out.println(matcher.group());//匹配出满足条件的字符
            System.out.println(matcher.group(1));//匹配第一个字符
        }

    }
}
