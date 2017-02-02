public interface ICache {

    public Cache findCache(String query);

    public void addNew(Cache c);

    public void addSiteToCaches(Webpage w);

    public boolean queryAlreadySeen(String query);
}
