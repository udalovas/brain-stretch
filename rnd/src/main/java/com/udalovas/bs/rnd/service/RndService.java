package com.udalovas.bs.rnd.service;

import com.udalovas.bs.rnd.model.RndValue;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RndService {

    public char getRndChar() {
        return  (char)(new Random().nextInt(26) + 'a');
    }
}
