import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author 9527
 * @version 1.0
 * @date 2020-11-7 17:17
 */
public class Test {

    @org.junit.Test
    public void  test(){

        List list =  null;
        boolean empty = CollectionUtils.isEmpty(list);
        System.out.println(empty);
        //boolean empty = list.isEmpty();
    }
}
