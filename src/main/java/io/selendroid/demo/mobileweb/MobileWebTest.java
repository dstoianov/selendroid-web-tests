/*
 * Copyright 2012-2014 eBay Software Foundation and selendroid committers.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package io.selendroid.demo.mobileweb;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MobileWebTest extends BaseTest {

    @Test
    public void shouldSearchWithEbay() {
        // And now use this to visit ebay
        driver.get("http://m.ebay.de");
        // Find the text input element by its id
        WebElement element = driver.findElement(By.id("kw"));
        // Enter something to search for
        element.sendKeys("Nexus 5 32");
        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();
        takeScreenshot();
        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());
        driver.quit();
    }

    @Test
    public void rozetkaTest() {
        driver.get("http://m.rozetka.ua/");

        WebElement search = driver.findElement(By.cssSelector(".f-search-text"));
        search.sendKeys("nexus 5");

        WebElement buttonSearch = driver.findElement(By.cssSelector(".f-search-submit-wrap"));
        buttonSearch.click();

        List<WebElement> elements = driver.findElements(By.cssSelector("#items section"));
        elements.get(0).click();
    }
}
