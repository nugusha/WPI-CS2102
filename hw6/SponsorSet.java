import java.util.HashMap;

public class SponsorSet implements ISponsor {
    private HashMap<String, Double> sponsors= new HashMap<>();

    public boolean contains(String key){
        return sponsors.containsKey(key.toLowerCase());
    }

    public void replace(String key, Double value){
        sponsors.replace(key.toLowerCase(), value);
    }

    public void addSponsor(String name,Double rate){
        sponsors.put(name.toLowerCase(), rate);
    }

    public Double get(String key){
        return sponsors.get(key);
    }

    public Double getSponsoredRate(String url){
        Double payment=0.0;
        for(String s: sponsors.keySet()){
            if(url.contains(s))
                payment=payment+sponsors.get(s);
        }
        return payment;
    }





}
