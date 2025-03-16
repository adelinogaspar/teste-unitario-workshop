package br.com.itau.workshop.util;

import java.util.UUID;

public class Util {

    static public String geraId() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
