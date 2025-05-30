package edu.tucn.ispse.lecture13.utils.model;

/**
 * RECORDS ARE IMMUTABLE!
 * Records provide: all args constructor, getters, hashCode(), equals() and toString()
 *
 * @author Radu Miron
 * @version 1
 */
public record Address(Integer id, String street, String city, String country) {
}
