package test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import webdriver.BaseTest;
import webdriver.elements.BaseElement;
import forms.CartForm;
import forms.HomePageForm;
import forms.ItemsForm;

public class TC_01_putInCart extends BaseTest {
	private BaseElement menuItem, menuSubItem;
	private int itemNumberToPut;
	
	@Parameters({"itemNumToPut"})
	@BeforeClass
	private void getParameters(int itemNumToPut){
		this.itemNumberToPut = itemNumToPut;
	}

	public void runTest() {
		int step=1;
			
		logger.step(step++);
		browser.navigate("http://www.21vek.by");
		HomePageForm homePageForm = new HomePageForm();
		
		logger.step(step++);
		menuItem = homePageForm.getLnkComputers();
		homePageForm.NavigateTo(menuItem);
		menuSubItem = homePageForm.getLnkNotebooks();
		ItemsForm itemsForm = homePageForm.NavigateToItemsForm(menuSubItem, "Ноутбуки");
		
		logger.step(step++);
		itemsForm.PutInCart(itemNumberToPut);
		
		logger.step(step++);
		String selectedItemName = itemsForm.getItemName(itemNumberToPut);
		CartForm cartForm = itemsForm.NavigateToCartForm();
		Boolean checkResult = cartForm.CheckItemInCart(selectedItemName);
		doAssert(checkResult,"Item successfully added to the cart","Item not founded in the cart");
		

	}

}
