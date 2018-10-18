package co.com.blummer.quotevent.webservices;

import co.com.blummer.quotevent.webservices.Calculator;
/**
 *
 * @author cochoa
 */
public class Consumo {
    
    public int add(int intA, int intB) {
        Calculator service = new Calculator();
        CalculatorSoap port = service.getCalculatorSoap();
        return port.add(intA, intB);
    }
    
   
    public int divide(int intA, int intB) {
        Calculator service = new Calculator();
        CalculatorSoap port = service.getCalculatorSoap();
        return port.divide(intA, intB);
    }

    
}
