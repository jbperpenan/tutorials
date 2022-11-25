package org.jbp.csc611.mc01.scraper;

import org.jbp.csc611.mc01.repository.UrlRepository;
import org.jbp.csc611.mc01.repository.entity.Url;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class WebsiteLinksCrawlerService {

    @Autowired
    private UrlRepository urlRepository;

    private WebDriver driver;

    public List<Url> initWebsiteCrawlerConfig(String websiteUrl){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);

        return executeLinksCrawler(websiteUrl);
    }

    private List<Url> executeLinksCrawler(String websiteUrl) {
        Set<String> domainLinks = new HashSet<>();
        List<Url> urls = new LinkedList<>();

        try {
            driver.get(websiteUrl);

            List<WebElement> links = driver.findElements(By.tagName("a"));

            for(int i=0;i<links.size();i++)
            {
                WebElement E1= links.get(i);
                String link = E1.getAttribute("href");
                if(link != null && link.startsWith(websiteUrl)){
                    domainLinks.add(link);
                }
            }

            domainLinks.stream()
                    .forEach(link -> urls.add(new Url(link,null,"PENDING")));
            urlRepository.saveAll(urls);

        } catch (Exception e) {
            e.printStackTrace();
        }
        Collections.shuffle(urls);
        return urls;
    }
}
