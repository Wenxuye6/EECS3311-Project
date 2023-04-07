import org.junit.Test;
import util.CheckDigitUtil;

public class TestDigit {
    @Test
    public void test() {
        System.out.println(CheckDigitUtil.check("1.80"));
        System.out.println(CheckDigitUtil.check("0"));
        System.out.println(CheckDigitUtil.check("60.00"));
    }
}
