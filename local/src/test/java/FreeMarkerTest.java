import freemarker.template.Configuration;
import freemarker.template.Template;
import org.junit.Test;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lzh on 2019/3/1.
 */
public class FreeMarkerTest {


    public static final String HTTP_ADMANAGET_700_SYSTOON_COM = "http://admanaget700.systoon.com";
    public static final String TOON_TYPE = "202";

    /**
     * 测试 FreeMarker 渲染
     *
     * @throws Exception
     */
    @Test
    public void testRender() throws Exception {

        String tempString = "${host}/pc/index.html?toonType=${toonType}";

        Map<String, Object> model = new HashMap<>();
        model.put("host", HTTP_ADMANAGET_700_SYSTOON_COM);
        model.put("toonType", TOON_TYPE);

        StringWriter result = new StringWriter();

        Template t = new Template("adManage", new StringReader(tempString), new Configuration());
        t.process(model, result);
        System.out.println("启动页:\t" + result.toString());
        System.out.println("弹框:\t" + result.toString()+"#/popupList");
        System.out.println("静态:\t" + result.toString()+"#/staticList");
    }
}
