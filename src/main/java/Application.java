import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;

public class Application {


    private static Vertx vertx = Vertx.vertx();

    public static void main(String[] args) {

        Router router = Router.router(vertx);

        router.route().handler(BodyHandler.create());
        router.get("/files").handler(Application::filesReponse);
        router.get("/").handler(Application::randResonse);


        vertx.createHttpServer()
                .requestHandler(router::accept)
                .listen(8080);
    }


    private static void filesReponse(RoutingContext context) {
        HttpServerResponse response = context.response();
        response.end("cute");
    }

    private static void randResonse(RoutingContext context) {
        HttpServerResponse response = context.response();
        int i = (int) (Math.random() * 100);
        response.end(i+"");
    }
}
