package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class Constans {

    //FROM: https://seanwasere.com/generate-random-hex/
    public static final String SECRET_KEY = "2edd384d40c5a2f4a812dd0468269eb4550bb862eab83c8ee4b640e0d5eccf55";
    public static final Integer TOKEN_EXPIRED = 1000 * 60 * 24 * 4;

}
