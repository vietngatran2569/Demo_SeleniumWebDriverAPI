package javascriptExecutor;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TC_Excercise {
	@Test
	public void TC_001() {
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.now.vn/");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// step2
		String[] expected = { "All", "Đồ ăn", "Đồ uống", "Đồ chay", "Bánh kem", "Tráng miệng", "Homemade", "Vỉa hè",
				"Pizza/Burger", "Món gà", "Món lẩu", "Sushi", "Mì phở", "Cơm hộp" };

		WebElement text_All = driver.findElement(By.xpath("//span[contains(text(),'All')]"));
		assertEquals(expected[0], text_All.getText());
		WebElement text_DoAn = driver
				.findElement(By.xpath("//span[contains(text(),'Đồ ăn')][@class=\"category-item \"]"));
		assertEquals(expected[1], text_DoAn.getText());
		WebElement text_DoUong = driver.findElement(By.xpath("//span[contains(text(),'Đồ uống')]"));
		assertEquals(expected[2], text_DoUong.getText());
		WebElement text_DoChay = driver.findElement(By.xpath("//span[contains(text(),'Đồ chay')]"));
		assertEquals(expected[3], text_DoChay.getText());
		WebElement text_Pizza = driver.findElement(By.xpath("//span[contains(text(),'Pizza/Burger')]"));
		assertEquals(expected[8], text_Pizza.getText());

		long size = (long) js.executeScript("return document.getElementsByClassName(\"category-item \").length");
		assertEquals(size, expected.length);
		System.out.println(size);

		// step3
		// driver.findElement(By.xpath("//div[@class='col pl-2 pr-2 txt-elipsis']")).click();
		// step 4

//*Using selenium		
//		WebElement input_DiaChiGiaoHang = driver.findElement(By.xpath("//input[@type='text'][@id='address']"));
//		input_DiaChiGiaoHang.sendKeys("Ha Noi");
//	    WebElement x=driver.findElement(By.xpath("//span[@class='close'][@data-dismiss='modal'][text()='x']"));
//	    x.click();
//*Using javascript Executor
//		Alert alert = driver.switchTo().alert();
//		driver.switchTo().alert().sendKeys("Ha Noi");
//		alert.dismiss();

		// step 5
		driver.findElement(By.id("local-dropdown")).click();
		;
		WebElement webE = driver.findElement(By.xpath("//div[@class='dropdown-item']/span[text()='Hà Nội']"));
		webE.click();

		WebElement searchHome = driver.findElement(By.id("txtSearchHome"));
		searchHome.sendKeys("green lands");
		WebElement btnClickSearch = driver.findElement(By.xpath("//button[@class=\"btn btn-search\"]"));
		btnClickSearch.click();
		// step 6
		String verifyString = driver.findElement(By.xpath(
				"//div[@class=\"no-result-search\"]/p[text()='Now không tìm thấy kết quả cho từ khóa “green lands” của bạn']"))
				.getText();
		assertEquals(verifyString, "Now không tìm thấy kết quả cho từ khóa “green lands” của bạn");

		// step 7
		driver.findElement(By.xpath("//span[@class=\"btn-delete-tag\"]")).click();
		;
		String verifyX = driver.findElement(By.xpath("//div[@class=\"result\"]")).getText();
		assertEquals("100 Kết quả", verifyX);

	}
}
