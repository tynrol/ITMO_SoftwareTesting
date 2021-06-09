import org.openqa.selenium.*;


public class Utils {


    public Utils() {
        System.setProperty("webdriver.gecko.driver","src\\main\\resources\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver","src\\main\\resources\\chromedriver.exe");
    }

    int firstLength, secondLength;

    public boolean addImageByLink(WebDriver webDriver, String path){
        webDriver.get("https://fastpic.ru/my.php");
        firstLength = webDriver.findElements(By.xpath("//*[@id=\"manage-form\"]/div")).size();
        webDriver.get("https://fastpic.ru");
        webDriver.manage().window().setSize(new Dimension(1536, 824));
        webDriver.findElement(By.xpath("//a[contains(text(),\'[ по ссылке ]\')]")).click();
        webDriver.findElement(By.xpath("//textarea[@id=\'upload_files\']")).click();
        webDriver.findElement(By.xpath("//textarea[@id=\'upload_files\']")).sendKeys(path);
        webDriver.findElement(By.xpath("//input[@id=\'uploadButton\']")).click();
        webDriver.get("https://fastpic.ru/my.php");
        secondLength = webDriver.findElements(By.xpath("//*[@id=\"manage-form\"]/div")).size();
        return secondLength == firstLength + 1;
    }

    public boolean addImageByUpload(WebDriver webDriver, String path){
        webDriver.get("https://fastpic.ru/my.php");
        firstLength = webDriver.findElements(By.xpath("//*[@id=\"manage-form\"]/div")).size();
        webDriver.get("https://fastpic.ru");
        webDriver.manage().window().setSize(new Dimension(1536, 824));
        webDriver.findElement(By.xpath("//a[contains(text(),\'[ с компьютера ]\')]")).click();
        webDriver.findElement(By.xpath("//*[@id=\'file\']")).sendKeys(path);
        webDriver.findElement(By.xpath("//input[@id=\'uploadButton\']")).click();
        webDriver.get("https://fastpic.ru/my.php");
        secondLength = webDriver.findElements(By.xpath("//*[@id=\"manage-form\"]/div")).size();
        System.out.println(secondLength);
        return secondLength == firstLength + 1;
    }

    public boolean rotatateImage (WebDriver webDriver, String path, String deg){
        webDriver.get("https://fastpic.ru/my.php");
        firstLength = webDriver.findElements(By.xpath("//*[@id=\"manage-form\"]/div")).size();
        uploadImage(webDriver, path);
        webDriver.findElement(By.xpath("//input[@id=\'check_orig_rotate\']")).click();
        webDriver.findElement(By.xpath("//select[@id=\'orig-rotate\']")).click();
        {
            WebElement dropdown = webDriver.findElement(By.id("orig-rotate"));
            dropdown.findElement(By.xpath("//option[. = '"+deg+"']")).click();
        }
        webDriver.findElement(By.xpath("//select[@id=\'orig-rotate\']")).click();
        webDriver.findElement(By.xpath("//input[@id=\'uploadButton\']")).click();
        webDriver.get("https://fastpic.ru/my.php");
        secondLength = webDriver.findElements(By.xpath("//*[@id=\"manage-form\"]/div")).size();
        return secondLength == firstLength+1;
    }

    public boolean reduceImage(WebDriver webDriver, String path, String pix) {
        webDriver.get("https://fastpic.ru/my.php");
        firstLength = webDriver.findElements(By.xpath("//*[@id=\"manage-form\"]/div")).size();
        uploadImage(webDriver, path);
        webDriver.findElement(By.xpath("//input[@id=\'check_orig_resize\']")).click();
        if (pix.contains(" (")) {
            webDriver.findElement(By.xpath("//select[@id=\'orig-resize-helper\']")).click();
            {
                WebElement dropdown = webDriver.findElement(By.id("orig-resize-helper"));
                dropdown.findElement(By.xpath("//option[. = '"+pix+"']")).click();
            }
            webDriver.findElement(By.xpath("//select[@id=\'orig-resize-helper\']")).click();
        }
        else {
            webDriver.findElement(By.xpath("//input[@id=\'check_orig_resize\']")).click();
            webDriver.findElement(By.cssSelector(".f-image-opts")).click();
            webDriver.findElement(By.xpath("//input[@id=\'orig-resize\']")).clear();
            webDriver.findElement(By.xpath("//input[@id=\'orig-resize\']")).sendKeys(pix);
        }
        webDriver.findElement(By.id("check_thumb")).click();
        webDriver.findElement(By.id("thumb-size")).click();
        webDriver.findElement(By.xpath("//input[@id=\'uploadButton\']")).click();
        webDriver.get("https://fastpic.ru/my.php");
        System.out.println(webDriver.findElement(By.xpath("//*[@id=\"manage-form\"]/div[1]/a/img")).getAttribute("width"));
        secondLength = webDriver.findElements(By.xpath("//*[@id=\"manage-form\"]/div")).size();
        if(secondLength == firstLength+1){
            return (
                    webDriver.findElement(By.xpath("//*[@id=\"manage-form\"]/div[1]/a/img")).getAttribute("src").endsWith("jpeg")
            );
        }
        return false;
    }

    //изображение будет сжато в jpeg
    public boolean intoJPEG(WebDriver webDriver, String path){
        webDriver.get("https://fastpic.ru/my.php");
        firstLength = webDriver.findElements(By.xpath("//*[@id=\"manage-form\"]/div")).size();
        uploadImage(webDriver, path);
        webDriver.findElement(By.cssSelector(".optimization > label")).click();
        webDriver.findElement(By.cssSelector(".optimization")).click();
        webDriver.findElement(By.xpath("//input[@id=\'jpeg-quality\']")).sendKeys("60");
        webDriver.findElement(By.xpath("//input[@id=\'uploadButton\']")).click();
        webDriver.get("https://fastpic.ru/my.php");
        secondLength = webDriver.findElements(By.xpath("//*[@id=\"manage-form\"]/div")).size();
        if(secondLength == firstLength+1){
            return (
                    webDriver.findElement(By.xpath("//*[@id=\"manage-form\"]/div[1]/a/img")).getAttribute("src").endsWith("jpeg")
            );
        }
        return false;
    }

    //изображение будет сжато в jpeg и ограничено размером 1200px по большей стороне
    public boolean intoPoster(WebDriver webDriver, String path){
        webDriver.get("https://fastpic.ru/my.php");
        firstLength = webDriver.findElements(By.xpath("//*[@id=\"manage-form\"]/div")).size();
        uploadImage(webDriver, path);
        webDriver.findElement(By.xpath("//input[@name=\'check_poster\']")).click();
        webDriver.findElement(By.xpath("//input[@id=\'uploadButton\']")).click();
        webDriver.get("https://fastpic.ru/my.php");
        secondLength = webDriver.findElements(By.xpath("//*[@id=\"manage-form\"]/div")).size();
        if(secondLength == firstLength+1){
            return (
                    webDriver.findElement(By.xpath("//*[@id=\"manage-form\"]/div[1]/a/img")).getAttribute("src").endsWith("jpeg")
            );
        }
        return false;
    }

    public void uploadImage(WebDriver webDriver, String path){
        webDriver.get("https://fastpic.ru/");
        webDriver.findElement(By.xpath("//a[contains(text(),\'[ по ссылке ]\')]")).click();
        webDriver.findElement(By.xpath("//textarea[@id=\'upload_files\']")).click();
        webDriver.findElement(By.xpath("//textarea[@id=\'upload_files\']")).sendKeys(path);
        webDriver.findElement(By.xpath("//a[contains(text(),\'[ отключить все эффекты ]\')]")).click();
    }

    public void addImageWithPreviewEmpty(WebDriver webDriver, String path){
        webDriver.findElement(By.xpath("//a[contains(text(),\'[ по ссылке ]\')]")).click();
        webDriver.findElement(By.xpath("//textarea[@id=\'upload_files\']")).click();
        webDriver.findElement(By.xpath("//textarea[@id=\'upload_files\']")).sendKeys(path);
        webDriver.findElement(By.cssSelector("label:nth-child(7) > #check_thumb")).click();

        webDriver.findElement(By.xpath("//input[@id=\'uploadButton\']")).click();
    }

    public void addImageWithPreview1(WebDriver webDriver, String path, String noteOrSize){
        webDriver.findElement(By.xpath("//a[contains(text(),\'[ по ссылке ]\')]")).click();
        webDriver.findElement(By.xpath("//textarea[@id=\'upload_files\']")).click();
        webDriver.findElement(By.xpath("//textarea[@id=\'upload_files\']")).sendKeys(path);
        if (!isNumeric(noteOrSize)) {
            webDriver.findElement(By.cssSelector("label:nth-child(4) > #check_thumb")).click();
            webDriver.findElement(By.xpath("//input[@id=\'thumb_text\']")).click();
            webDriver.findElement(By.xpath("//input[@id=\'thumb_text\']")).sendKeys(noteOrSize);
        }
        else {
            webDriver.findElement(By.cssSelector("label:nth-child(7) > #check_thumb")).click();
            webDriver.findElement(By.xpath("//input[@id=\'check-thumb-size-vertical\']")).click();
            webDriver.findElement(By.cssSelector(".preview-size")).click();
            webDriver.findElement(By.xpath("//input[@id=\'thumb-size\']")).sendKeys(noteOrSize);
        }
        webDriver.findElement(By.xpath("//input[@id=\'uploadButton\']")).click();
    }

    public void addImageWithPreview2(WebDriver webDriver, String path, String note, String size){
        webDriver.findElement(By.xpath("//a[contains(text(),\'[ по ссылке ]\')]")).click();
        webDriver.findElement(By.xpath("//textarea[@id=\'upload_files\']")).click();
        webDriver.findElement(By.xpath("//textarea[@id=\'upload_files\']")).sendKeys(path);
        if (note.equals("")){
            webDriver.findElement(By.id("check_thumb")).click();
            webDriver.findElement(By.id("thumb-size")).click();
        }
        else {
            webDriver.findElement(By.cssSelector("label:nth-child(4) > #check_thumb")).click();
            webDriver.findElement(By.xpath("//input[@id=\'thumb_text\']")).click();
            webDriver.findElement(By.xpath("//input[@id=\'thumb_text\']")).sendKeys(note);
        }
        webDriver.findElement(By.id("thumb-size")).sendKeys(size);
        webDriver.findElement(By.id("check-thumb-size-vertical")).click();
        webDriver.findElement(By.xpath("//input[@id=\'uploadButton\']")).click();
    }

    public static boolean isNumeric(String str){
        try {
            Integer.parseInt(str);
        } catch(NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
