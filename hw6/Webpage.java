import java.util.Comparator;
import java.util.LinkedList;

class Webpage implements Comparable<Webpage>{
  public String url;
  private String title;
  private String body;
  private LinkedList<String> referencedURLs;
  public Double rank=0.0;
  
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


  public int compareTo(Webpage page){
    if(this.rank>page.rank)
      return -1;
    if(this.rank<page.rank)
      return 1;
    else
      return 0;
  }

  public void addRank(Double newRank){
    this.rank=this.rank+newRank;
  }

  //Counts how many references there are to other pages excluding self links
  public LinkedList<String> referencedURLsMinusSelfLinks(){
      LinkedList<String> urls=new LinkedList<>();

      for(String w: referencedURLs){
          if (w.equals(this.url))
              urls=urls;
          else
              urls.add(w);
      }

      return urls;
  }




}