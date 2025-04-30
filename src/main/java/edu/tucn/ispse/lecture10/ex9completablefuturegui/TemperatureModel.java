package edu.tucn.ispse.lecture10.ex9completablefuturegui;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public record TemperatureModel(CurrentUnits current_units, Current current) {
}

record Current(float temperature_2m){
}

record CurrentUnits(String temperature_2m){
}
