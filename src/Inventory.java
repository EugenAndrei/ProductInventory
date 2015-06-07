import java.util.ArrayList;
import java.util.List;

public class Inventory {
	private List<Product> ProductList;
	
	public Inventory(){
		this.ProductList = new ArrayList<>();
	}
	
	public Inventory(List<Product> ProductList){
		this.ProductList = ProductList;
	}
	
	public List<Product> ProductList() {
        return ProductList;
    }
	
	public int addProduct(Product p){
		this.ProductList.add(p);
		return count();
	}
	
	public int count(){
		return this.ProductList.size();
	}
	
	public Product getProduct(int index){
		if ( index < 0 || index >= count()){
			return null;
		}
		return this.ProductList.get(index);
	}
}
