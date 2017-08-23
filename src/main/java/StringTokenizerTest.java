import java.util.StringTokenizer;

/**
 * 作者：boys
 * 创建时间：2017-08-18 17:20
 * 类描述：
 * 修改人：
 * 修改时间：
 */
public class StringTokenizerTest {

    public static void main(String[] args) {

        StringTokenizer test = new StringTokenizer("j-phone, one;tow,sort\tniyou", ",;\t");


        while (test.hasMoreTokens()) {
            System.out.println("count0=" + test.countTokens());
            System.out.println("carry=" + test.nextToken());
            System.out.println("count1=" + test.countTokens());

        }
    }
}
