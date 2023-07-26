package info.infokom.vaadin_calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public String divide(String value1, String value2) {
        // divide value1 by value2 and return the result
        return ((Double) (Double.parseDouble(value1) / Double.parseDouble(value2))).toString();
    }

    /**
     * Hier soll der Code für die Berechnung stehen.
     */

    public String sum(String value1, String value2){
        return String.valueOf(Double.valueOf(value1) + Double.valueOf(value2));
    }
}
