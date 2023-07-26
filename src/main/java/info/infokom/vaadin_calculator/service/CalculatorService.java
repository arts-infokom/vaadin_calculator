package info.infokom.vaadin_calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    /**
     * Hier soll der Code für die Berechnung stehen.
     */

    public String sum(String value1, String value2){
        return String.valueOf(Double.valueOf(value1) + Double.valueOf(value2));
    }
}
