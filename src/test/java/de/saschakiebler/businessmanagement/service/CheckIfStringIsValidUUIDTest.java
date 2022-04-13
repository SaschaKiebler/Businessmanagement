package de.saschakiebler.businessmanagement.service;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static de.saschakiebler.businessmanagement.service.CheckIfStringIsValidUUID.*;
import static org.junit.jupiter.api.Assertions.*;

class CheckIfStringIsValidUUIDTest {

    @Test
    void test_checkIfStringIsValidUUID_for_invalid_input() {
        assertFalse(checkIfStringIsValidUUID("as"));
    }

    @Test
    void test_checkIfStringIsValidUUID_for_valid_input() {
        assertTrue(checkIfStringIsValidUUID(UUID.randomUUID().toString()));
    }

    @Test
    void test_checkIfStringIsValidUUID_for_empty_input() {
        assertFalse(checkIfStringIsValidUUID(""));
    }
}