import java.util.LinkedList;

public class Cache{
    private String query;
    private LinkedList<Webpage> webpages;

    public Cache(String query, LinkedList<Webpage> webpages){
        this.query=query;
        this.webpages=webpages;
    }

    public String getQuery(){
        return this.query;
    }

    // add webpage to cache's list of webpages
    public void addWebpage(Webpage w){
        webpages.add(w);
    }

    public LinkedList<Webpage> getWebpages(){
        return this.webpages;
    }
}
