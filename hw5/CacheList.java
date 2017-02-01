import java.io.FileNotFoundException;
import java.util.LinkedList;

public class CacheList implements ICache{
    private LinkedList<Cache> caches=new LinkedList<Cache>();


    // runs through list of caches to find cache with given query
    public Cache findCache(String query) {
        for(Cache c: caches){
            if(c.getQuery().equals(query))
                return c;
        }
        return null;
    }

    // adds new cache to the list of caches
    public void addNew(Cache c){
        caches.add(c);
    }

    // adds new webpage to relavent caches
    public void addSiteToCaches(Webpage w){
        for(Cache c: caches){
            String key = c.getQuery();
            String title = w.getTitle().toLowerCase();
            String body = w.getBody().toLowerCase();

            if (w.getTitle().contains(key))
                c.getWebpages().add(w);
            else {
                if (w.getBody().contains(key))
                    c.getWebpages().add(w);
            }
        }
    }

    // checks if query has already been seen
    public boolean queryAlreadySeen(String query){
        for(Cache c: caches){
            if(c.getQuery().equals(query))
                return true;
        }
        return false;
    }
}
