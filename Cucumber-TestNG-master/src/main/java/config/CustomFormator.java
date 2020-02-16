package config;

import java.util.List;

import gherkin.formatter.Formatter;
import gherkin.formatter.model.Background;
import gherkin.formatter.model.Examples;
import gherkin.formatter.model.Feature;
import gherkin.formatter.model.Scenario;
import gherkin.formatter.model.ScenarioOutline;
import gherkin.formatter.model.Step;

public class CustomFormator implements Formatter {

    public CustomFormator() {}


	@Override
	public void syntaxError(String state, String event, List<String> legalEvents, String uri, Integer line) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void uri(String uri) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void feature(Feature feature) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void scenarioOutline(ScenarioOutline scenarioOutline) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void examples(Examples examples) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startOfScenarioLifeCycle(Scenario scenario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void background(Background background) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void scenario(Scenario scenario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void step(Step step) {
		System.out.println(step.getName());
		// TODO Auto-generated method stub
		
	}

	@Override
	public void endOfScenarioLifeCycle(Scenario scenario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void done() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eof() {
		// TODO Auto-generated method stub
		
	}
}
