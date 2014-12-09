package forms;

import org.openqa.selenium.By;

/**
 * Class describe Home page
 */
public class HomePageForm extends PageForm {
	
	private static By TitleLocator = By.id("PromoBlock");

	public HomePageForm() {
		super(TitleLocator, "Home page");
	}

}
