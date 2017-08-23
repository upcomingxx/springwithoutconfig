import com.self.config.SpringConfig;
import com.self.service.DBService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 作者：boys
 * 创建时间：2017-08-23 17:37
 * 类描述：
 * 修改人：
 * 修改时间：
 */
public class Startup {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        DBService dbService = (DBService) context.getBean("dbService");

        dbService.addData();

        System.out.println(dbService.getOne());
    }
}
