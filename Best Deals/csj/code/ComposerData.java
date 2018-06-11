
import java.util.*;


public class ComposerData {
    
    private HashMap composers = new HashMap();
    

    public HashMap getComposers() {
        return composers;
    }
    
    public ComposerData() {
        
ArrayList<Product> prod = AjaxUtility.selectProduct();
Product name;
for(int m=0;m<prod.size();m++)
{
    name=prod.get(m);
    composers.put(m, new Composer(name.getId(),name.getName())); 
}
        
    }

}
