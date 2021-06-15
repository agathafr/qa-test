package opentdb.acceptance;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

// Essa classe � respons�vel pela integra��o entre o Cucumber e o Junit
@RunWith(Cucumber.class) // Anota��o do Junit respons�vel pela integra��o
@CucumberOptions(features = "classpath:features") // Mostra para o Cucumber onde est�o os arquivos de funcionalidades (.feature)
public class OpentdbCucumberRunner {
	
	
}
