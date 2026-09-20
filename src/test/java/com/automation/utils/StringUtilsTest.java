package com.automation.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringUtilsTest {

    @Test
    void shouldIdentifyBlankString() {
        Assertions.assertTrue(StringUtils.isBlank("   "));

        Assertions.assertTrue(StringUtils.isBlank(null));

        Assertions.assertFalse(StringUtils.isBlank("hello"));
    }

    @Test
    void shouldNormalizeWhitespace() {
        Assertions.assertEquals("Hello World", StringUtils.normalizeWhitespace("   Hello     World   "));
    }
}
