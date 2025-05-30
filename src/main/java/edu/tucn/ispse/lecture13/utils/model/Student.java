package edu.tucn.ispse.lecture13.utils.model;

import java.util.Date;

/**
 * RECORDS ARE IMMUTABLE!
 * Records provide: all args constructor, getters, hashCode(), equals() and toString()
 *
 * @author Radu Miron
 * @version 1
 */
public record Student(Integer id, String firstName, String lastName, Date dateOfBirth) {
}
