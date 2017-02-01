import java.util.LinkedList;

class Webpage {
  public String url;
  private String title;
  private String body;
  private LinkedList<String> referencedURLs;
  
  // The constructor converts title and body to lowercase, to ease
  //  other computations later
  Webpage(String locator, String title, String body,
          LinkedList<String> referencedURLs) {
    this.url = locator;
    this.title = title.toLowerCase();
    this.body = body.toLowerCase();
    this.referencedURLs = referencedURLs;
  }

  public String getTitle(){
    return this.title;
  }

  public String getBody(){
    return this.body;
  }

  public LinkedList<String> getReferencedURLs(){
    return this.referencedURLs;
  }

}