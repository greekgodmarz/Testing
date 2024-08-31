
package com.marz.lang;


/**
 *
 * @author Relivian
 */
import io.undertow.Handlers;
import io.undertow.Undertow;
import io.undertow.UndertowOptions;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.server.handlers.PathHandler;
import io.undertow.server.handlers.resource.FileResourceManager;
import io.undertow.server.handlers.resource.ResourceHandler;
import io.undertow.util.StatusCodes;
import java.io.File;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import java.io.InputStream;
import java.security.KeyStore;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;



/**
 * This is a simple webserver demo.
 * Create the needed keystore using this command:
 * mkdir src/main/resources; keytool -genkeypair -alias undertow -keyalg RSA -keysize 2048 -validity 365 -keystore src/main/resources/webserver.keystore -storepass password -keypass password -dname "CN=localhost"
 * 
 * @author av
 */
public class WebServer {
    static void printUsage(int httpPort, int httpsPort) {
        System.out.println("\nUSAGE: )"+WebServer.class.getSimpleName()+" [-option value]");
        System.out.println("    options:");
        System.out.println("      p - secure (http) port (default: "+httpsPort+"), -1 to disable");
        System.out.println("      s - secure (https) port (default: "+httpsPort+")");
        System.exit(1);
    }
   
    public static void main(String[] args) throws Exception {
        int httpPort = 8080;
        int httpsPort = 8443;
        for (int i=0; i<args.length; i++) {
            switch (args[i]) {
                case "-p": 
                    if (i+1 >= args.length) throw new RuntimeException("parameter "+args[i]+" expects value");
                    httpPort = Integer.parseInt(args[++i]);
                    break;
                case "-s": 
                    if (i+1 >= args.length) throw new RuntimeException("parameter "+args[i]+" expects value");
                    httpsPort = Integer.parseInt(args[++i]);
                    break;
                case "-h":
                case "--help":
                    printUsage(httpPort, httpsPort); // exits
                default:;
            }
        }
      
      
        // Load SSL context
        SSLContext sslContext = createSSLContext(loadKeyStore("webserver.keystore", "password"), "password");

        Undertow.Builder builder = Undertow.builder();

        if (httpPort != -1) {
            builder.addHttpListener(httpPort, "0.0.0.0");
        }

        builder.addHttpsListener(httpsPort, "0.0.0.0", sslContext)        
            .setServerOption(UndertowOptions.ENABLE_HTTP2, true)
            .setHandler(createPathHandler())    
            .build();
        Undertow server = builder.build();
        server.start();
    }

    private static SSLContext createSSLContext(KeyStore keyStore, String password) throws Exception {
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
        keyManagerFactory.init(keyStore, password.toCharArray());
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(keyManagerFactory.getKeyManagers(), null, null);
        return sslContext;
    }

    private static KeyStore loadKeyStore(String name, String password) throws Exception {
        try (InputStream stream = WebServer.class.getClassLoader().getResourceAsStream(name)) {
            if (stream == null) {
                throw new IllegalArgumentException("Keystore not found: " + name);
            }
            KeyStore loadedKeystore = KeyStore.getInstance("JKS");
            loadedKeystore.load(stream, password.toCharArray());
            return loadedKeystore;
        }
    }

    private static PathHandler createPathHandler() {
        return Handlers.path()
            .addPrefixPath("/", createResourceHandler());  // Handles unknown paths
    }    
    
    private static ResourceHandler createResourceHandler() {
        // Create a ResourceHandler to serve static files from the ./web directory
        ResourceHandler resourceHandler = new ResourceHandler(new FileResourceManager(new File("./web"), 1024))
            .setDirectoryListingEnabled(true)  // Enables directory listing if no index file is found
            .setWelcomeFiles("index.html");  // Sets the default file to serve
        return resourceHandler;
    }

    
    static class DefaultHandler implements HttpHandler {
        @Override
        public void handleRequest(HttpServerExchange exchange) {
            exchange.setStatusCode(StatusCodes.NOT_FOUND);
            exchange.getResponseSender().send("Not Found");
        }
    }    
   
}
