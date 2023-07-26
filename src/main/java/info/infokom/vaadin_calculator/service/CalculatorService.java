package info.infokom.vaadin_calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {


    public String minus(String a, String b) {
        return String.valueOf(Double.valueOf(a) - Double.valueOf(b));
    }
}
