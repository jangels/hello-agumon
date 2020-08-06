import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
class FooService{
    // 该方法有事务注解
    @Transactional
    public void methodB(){
        //...
    }

    // 注意：该方法没有事务注解
    public void methodA(){
        // 这里调用了同一个对象的另一个方法 methodB(), 虽然 methodB 上使用了
        // 注解 @Transactional, 但事实上却无效
        this.methodB();
    }
}
