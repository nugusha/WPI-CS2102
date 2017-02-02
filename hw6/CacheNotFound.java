public class CacheNotFound extends Exception {
    String query;

    CacheNotFound(String query){
        this.query=query;
    }
}
