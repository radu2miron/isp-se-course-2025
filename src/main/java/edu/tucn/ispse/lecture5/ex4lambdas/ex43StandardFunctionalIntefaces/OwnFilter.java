package edu.tucn.ispse.lecture5.ex4lambdas.ex43StandardFunctionalIntefaces;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
@FunctionalInterface
public interface OwnFilter {

    boolean doFilter(Computer computer);
}
