package de.saschakiebler.businessmanagement.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecognizeIllegalInputStatementsTest {



    @Test
    void test_recognizeAnySQLRelevantWords_for_non_sql_relevant_input() {
        assertEquals(true, RecognizeIllegalInputStatements.recognizeAnySQLRelevantWords("Peter Meier, a Person"));
    }

    @Test
    void test_recognizeAnySQLRelevantWords_for_sql_injection_input_upper_case() {
        assertEquals(false, RecognizeIllegalInputStatements.recognizeAnySQLRelevantWords("DROP DATABASE"));
    }

    @Test
    void test_recognizeAnySQLRelevantWords_for_sql_relevant_input_with_semicolon() {
        assertEquals(false, RecognizeIllegalInputStatements.recognizeAnySQLRelevantWords("Peter Meier, a Person;"));
    }

    @Test
    void test_recognizeAnySQLRelevantWords_for_sql_injection_attack_with_select_statement() {
        assertEquals(false, RecognizeIllegalInputStatements.recognizeAnySQLRelevantWords("'SELECT * FROM client;"));
    }
    @Test
    void test_recognizeAnySQLRelevantWords_for_sql_injection_input_lower_case() {
        assertEquals(false, RecognizeIllegalInputStatements.recognizeAnySQLRelevantWords("';DROP DATABASE;"));
    }
}