public interface ISponsor {
    public void addSponsor(String name,Double rate);

    public void replace(String key, Double value);

    public boolean contains(String key);

    public Double get(String key);

    public Double getSponsoredRate(String url);
}
