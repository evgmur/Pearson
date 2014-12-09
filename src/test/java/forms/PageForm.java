package forms;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import webdriver.BaseForm;
import webdriver.elements.BaseElement;
import webdriver.elements.Button;
import webdriver.elements.Label;

/**
 * Class describe base page of 21vek.by
 */
public class PageForm extends BaseForm {
	
	public RemoteWebDriver driver = browser.getDriver();
	
	protected Button btnCart = new Button(By.className("clearfix"),"Button Корзина");
	protected Label lnkComputers = new Label(By.xpath("//span[@class='nav__link'][contains(.,'Компьютеры')]"),"Menu item Компьютеры");
	protected Label lnkNotebooks = new Label(By.xpath("//div[@class='l-nav-subgroup']//a[contains(.,'Ноутбуки')]"),"Menu  sub-item Ноутбуки");
	
	public PageForm(By locator, String formTitle) {
		super(locator, formTitle);
	}
	
	/**
	 * Get link "Компьютеры"
	 * @return Labek link "Компьютеры"
	 */
	public Label getLnkComputers(){
		return lnkComputers;
	}
	
	/**
	 * Get link "Ноутбуки"
	 * @return Label link "Ноутбуки
	 */
	public Label getLnkNotebooks(){
		return lnkNotebooks;
	}
	
	/**
	 * Navigate to element of page
	 * @param element - element of page 
	 */
	public void NavigateTo(BaseElement element){
		element.click();
	}
	
	/**
	 * Navigate to element of page, when new ItemsForm created
	 * @param element - element of page
	 * @param formName - name of created form
	 * @return new ItemsForm
	 */
	public ItemsForm NavigateToItemsForm(BaseElement element, String formName){
		element.click();
		return new ItemsForm(formName);
	}
	
	/**
	 * Navigate to cart page
	 * @return new Cart form
	 */
	public CartForm NavigateToCartForm(){
		btnCart.click();
		return new CartForm();
	}
}
