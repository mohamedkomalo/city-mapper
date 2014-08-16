package com.orange.citymapper.parsers;

import static org.junit.Assert.*;

import java.util.regex.Pattern;

import org.junit.Test;

public class RegexParserTests {

	@Test
	public void testParseNormalRegEx() {
		String regexPattern = "bla bla (\\S+) (\\S+)";
		String normalText = "bla bla komalo bomba";
		
		String[] variables = new RegexParser().extractVariables(normalText, Pattern.compile(regexPattern));

		assertEquals("komalo", variables[0]);
		assertEquals("bomba", variables[1]);
	}

}
