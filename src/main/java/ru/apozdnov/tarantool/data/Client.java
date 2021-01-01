package ru.apozdnov.tarantool.data;


import lombok.Data;
import org.springframework.stereotype.Service;
import org.tarantool.Iterator;
import org.tarantool.TarantoolClient;
import org.tarantool.TarantoolClientConfig;
import org.tarantool.TarantoolClientImpl;

import java.util.Collections;

@Data
public class Client {

    public void initClient(){
        TarantoolClientConfig config = new TarantoolClientConfig();
//        config.username = "guest";
//        config.password = "";
        config.username = "good";
        config.password = "secret";
        TarantoolClient client = new TarantoolClientImpl("wks16:3301", config);

        client.syncOps().select("tester", "primary", Collections.singletonList(1), 0, 1, Iterator.EQ);
        System.out.println("Ok2021");
        System.out.println(client.syncOps().select("tester", "primary", Collections.singletonList(1), 0, 1, Iterator.EQ));
        }

    public static void main(String[] args) {
        Client client = new Client();
        client.initClient();
    }
}
