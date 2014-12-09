package forms;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 *	Class describe cart page
 */
public class CartForm extends PageForm {

	private static By TitleLocator = By.xpath("//div[@id='content'][contains(.,'Оформление заказа')]"); 
	private List<WebElement> basketListOfNames = driver.findElementsByXPath("//td[@class='basket__item cr-basket__name']/a");
	
	public CartForm() {
		super(TitleLocator, "Cart form 'Корзина'");
	}
	
	/**
	 * Check that item added to the cart
	 * @param itemName - name of item
	 * @return Boolean result of check
	 */
	public Boolean CheckItemInCart(String itemName){
		String elementName;
		
		for(WebElement element: basketListOfNames){
			elementName = element.getText();
			if(elementName.equals(itemName)) return true;
		}
		return false;
	}
	
}
