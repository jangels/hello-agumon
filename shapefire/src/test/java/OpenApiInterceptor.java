import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

/**
 * 拦截session参数并校验
 *
 * @author liuzhenhua
 * @since 2017-05-09
 */
@Component
@Slf4j
public class OpenApiInterceptor  {




    public static void main(String[] args) {
        //签名验签
        long timestamp = System.currentTimeMillis();
        String signStr = "syskstoon" + timestamp + "EEC2A34353F04AB89338A4347E73C511";
        System.out.println(timestamp);
        String md5Sign = DigestUtils.md5Hex(signStr).toUpperCase();
        System.out.println(md5Sign);
    }

}
