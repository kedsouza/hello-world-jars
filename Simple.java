import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpContext;
import java.io.OutputStream;
import java.io.IOException;

public class Simple {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        
        HttpServer server = HttpServer.create();
        server.bind(new java.net.InetSocketAddress("0.0.0.0", 80), 0);
        server.createContext("/", new MyHandler());

        server.start();
    }
}

class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response = "Hello, World!";
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }