package com.dieblich.handball.gatecom;

import java.io.IOException;

class GatecomException extends Exception {
    GatecomException(String s) {
        super(s);
    }

    GatecomException(String s, IOException e) {
        super(s, e);
    }
}
