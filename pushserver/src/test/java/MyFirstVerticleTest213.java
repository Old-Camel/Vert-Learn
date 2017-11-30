import com.yunzainfo.pitcher.pushserver.client;
import io.vertx.core.Vertx;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(VertxUnitRunner.class)
public class MyFirstVerticleTest213
{
    private Vertx vertx;

    @Before
    public void setUp(TestContext context) {
        System.out.println("11");
        vertx = Vertx.vertx();
        vertx.deployVerticle(client.class.getName(),
            context.asyncAssertSuccess());
        System.out.println("2");
    }

    @After
    public void tearDown(TestContext context)
    {
        vertx.close(context.asyncAssertSuccess());
        //}
    }
        @Test
        public void testMyApplication (TestContext context){
        //final Async async = context.async();
        /*vertx.createHttpClient().getNow(8080, "localhost", "/",
                response ->
                {
                    response.handler(body ->
                    {
                        System.out.println(body.toString());
                        context.assertTrue(body.toString().contains("Hello"));
                        async.complete();
                    });
                });*/
        System.out.println("启动成功");
    }
}

