package java8;

import lombok.Data;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@Data
public class OptionalStreamTest {

    @Test
    public void test1() {

        assertThat(Optional.of(1).get(), is(1));

        assertThat(Optional.ofNullable(null).orElse("A"), is("A"));

        System.out.println(Optional.empty().orElse("LLL"));

    }


    @Test
    public void filesExample() throws IOException {
        //无限深度，递归遍历文件夹
        try (Stream<Path> pathStream = Files.walk(Paths.get("."))) {
            pathStream.filter(Files::isRegularFile) //只查普通文件
                    .filter(FileSystems.getDefault().getPathMatcher("glob:**/*.java")::matches) //搜索java源码文件
                    .forEach(System.out::println); //打印所有的行
        }
    }

    @Test
    public void testIntStream() {

        /*IntStream.rangeClosed(1,1000).forEach(i->{
            System.out.println(i);
        });

        IntStream.rangeClosed(1,100).parallel().forEach(i->{
            System.out.println(LocalDateTime.now() + " : " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) { }
        });
*/

        IntStream.rangeClosed(1, 100).parallel().forEach(i -> {
            System.out.println(i);
        });
    }

    @Test
    public void testStream() {
        Stream.of("i", "love", "u").forEach(System.out::println);
    }
}
