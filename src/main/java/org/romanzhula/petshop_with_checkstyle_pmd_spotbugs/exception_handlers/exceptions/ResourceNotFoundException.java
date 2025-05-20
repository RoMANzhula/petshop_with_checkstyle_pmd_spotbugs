package org.romanzhula.petshop_with_checkstyle_pmd_spotbugs.exception_handlers.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }

}
