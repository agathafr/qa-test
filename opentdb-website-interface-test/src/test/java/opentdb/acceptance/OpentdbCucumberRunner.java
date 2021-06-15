package opentdb.acceptance;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

// Essa classe é responsável pela integração entre o Cucumber e o Junit
@RunWith(Cucumber.class) // Anotação do Junit responsável pela integração
@CucumberOptions(features = "classpath:features") // Mostra para o Cucumber onde estão os arquivos de funcionalidades (.feature)
public class OpentdbCucumberRunner {
	
	
}
