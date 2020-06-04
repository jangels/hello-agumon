package guava;

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

    /**
     * 测试 FreeMarker 渲染
     *
     * @throws Exception
     */
    @Test
    public void testRender() throws Exception {

        String tempString = "hello ${name}, " +
                "hello ${user.name}";

        Map<String, Object> model = new HashMap<>();
        model.put("name", "lzh");

        Map<String, Object> user = new HashMap<>();

        user.put("name", "childName");
        model.put("user", user);

        StringWriter result = new StringWriter();

        Template t = new Template("name", new StringReader(tempString), new Configuration());

        t.process(model, result);

        System.out.println(result.toString());

    }
}
