package stepDef;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FirstSteps {
	
	int a;
	int b;
	int c;
	
	@Given("i assign first value")
	public void i_assign_first_value() {
	   
		 a = 10;
	}

	@And("i assign   second value")
	public void i_assign_second_value() {
	  
		b = 20;
		
	}

	@When("i multiply")
	public void i_multiply() {
		
		c = a*b;
	    
	}

	@Then("i see the total")
	public void i_see_the_total() {
		
		System.out.println(c);
	    
	}
	
	@Given("I assign first {int}")
	public void i_assign_first_value(int value) {
	    a = value;
	}

	@When("I assign second {int}")
	public void i_assign_second_value2(int value2) {
	    b = value2;
	}

	@Then("then I recive")
	public void then_i_recive_total() {
	    c = a*b;
	    System.out.println(c);
	}

}
