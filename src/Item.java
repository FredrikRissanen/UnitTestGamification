public class Item {
	private String type;
	private String brand;
	private int size;
	
	public Item (String itemType) {
		this.type = itemType;
	}
	
	public Item (String itemType, String itemBrand, int itemSize) {
		this.type = itemType;
		this.brand = itemBrand;
		this.size = itemSize;
	}
	
	public static String getType(Item item) {
		return item.type;	
	} 
	
	public String getBrand(){		
		return brand;
	}

	public void setBrand(String itemBrand){		
		this.brand = itemBrand;
	}
	
	public static String getBrand(Item item) {
		return item.brand;	
	} 
	
	
	public static Integer getSize(Item item) {
		return item.size;	
	} 
	
	public Integer getSize(){		
		return size;
	}

	public void setSize(int itemSize){		
		this.size = itemSize;
	}
}
