package org.rapid7.trools.example;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;

import javax.rules.InvalidRuleSessionException;
import javax.rules.StatelessRuleSession;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.rapid7.trools.annotation.InjectRuleSession;
import org.rapid7.trools.annotation.RuleContext;
import org.rapid7.trools.drools.DroolsJUnit4ClassRunner;

/**
 * Demonstrates creating a unit test with the trools framework using Drools under JSR-94.
 *
 * @author Derek Abdine
 * @see <a href="http://www.jessrules.com/docs/71/jsr94.html">The Jess JSR94 documentation</a>
 */
@RunWith(DroolsJUnit4ClassRunner.class)
@RuleContext(resourceURI = "org/rapid7/trools/drools/example/simple-test.drl")
public class StatelessExampleTest {
    @Test
    public void statelessExample() throws InvalidRuleSessionException,
	    RemoteException {
	// when
	List results = m_ruleSession.executeRules(Arrays.asList(new Person().setName("Bill")));

	// then
	assertEquals("hello world", results.get(0));
    }

    @InjectRuleSession
    private StatelessRuleSession m_ruleSession;
}
