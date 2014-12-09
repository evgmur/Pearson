package forms;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Class describe form with items
 */
public class ItemsForm extends PageForm {
	
	private static By TitleLocator = By.id("j-search_result");
	private List<WebElement> itemBtnInCart = driver.findElementsByCssSelector("form.j-to_basket > button");
	private List<WebElement> itemName = driver.findElementsByClassName("result__link");
	
	public ItemsForm(String formTitle) {
		super(TitleLocator, formTitle);
	}

	/**
	 * Put in cart method
	 * @param itemNumber - number of selected item
	 */
	public void PutInCart(int itemNumber){
		WebElement btnPutCart = itemBtnInCart.get(itemNumber);
		Actions actions = new Actions(driver);
		actions.moveToElement(btnPutCart,0,-39).build().perform();
		btnPutCart.click();
		logger.info("Button 'В корзину' :: Clicking");
	}
	
	/**
	 * Get name of selected item
	 * @param itemNumber - number of selected item
	 * @return String with selected item name
	 */
	public String getItemName(int itemNumber){
		WebElement element = itemName.get(itemNumber);
		String name = element.getText();
		return name;
	}
}
