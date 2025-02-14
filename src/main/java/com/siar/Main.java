package com.siar;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class Main {

    public static void main(String[] args) {
        Quarkus.run(DemoServer.class, args);
    }

    public static class DemoServer implements QuarkusApplication {

        @Override
        public int run(String... args) throws Exception {
            System.out.println("########################");
            System.out.println("####### Running! #######");
            System.out.println("########################");
            Quarkus.waitForExit();
            return 0;
        }
    }
}
