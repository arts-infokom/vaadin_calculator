package info.infokom.vaadin_calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public String add(String value1, String value2){
        int result = Integer.parseInt(value1) + Integer.parseInt(value2);

        return String.valueOf(result);
    }

    /**
     * Hier soll der Code für die Berechnung stehen.
     */
}
