package io.helidon.empdept.mono.mp;

import io.helidon.microprofile.server.Server;

public class Main {
    private static Server server;
    private static String serverUrl;


    public static void main(String[] args) {
        server = Server.create().start();
        serverUrl = "http://localhost:" + server.port();
    }


}
