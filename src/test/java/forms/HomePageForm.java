package forms;

import org.openqa.selenium.By;

public class HomePageForm extends PageForm {
	
	private static By TitleLocator = By.id("PromoBlock");

	public HomePageForm() {
		super(TitleLocator, "Home page");
	}
	
	

}
