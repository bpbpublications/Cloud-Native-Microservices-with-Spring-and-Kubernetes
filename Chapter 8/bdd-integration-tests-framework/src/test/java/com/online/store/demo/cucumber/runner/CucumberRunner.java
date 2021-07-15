package com.online.store.demo.cucumber.runner;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.rules.SpringClassRule;

import com.online.store.demo.Application;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * This class is configured to run all cucumber feature describe by <i>feature</i> option in {@link CucumberOptions}.
 *
 * @author rajiv.srivastava
 */

@RunWith(Cucumber.class)
@CucumberOptions(features = { "classpath:features/" }, 
				plugin = { "pretty", "html:target/site/cucumber-pretty","json:target/cucumber.json" }, 
				tags = {"~@ignore" }, 
				glue = { "cucumber.api.spring", "com.online.store.demo.steps"},
				strict = false
				//,dryRun=true
				)
@ContextConfiguration(classes = Application.class)
public class CucumberRunner {
	public static final SpringClassRule SPRING_CLASS_RULE = new SpringClassRule();

}