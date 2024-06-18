package Resources;

public class ProductDTO {
 private int product_id;   
 private int farmer_id;   
 private String product_name;   
 private String variety;   
 private int qty;   
 private String date;
 private int cost;
 private int  _1qtyprice;
 private int availability;

    public ProductDTO(){
        
    }
   
    public ProductDTO(String product_name, String variety,int qty,String date,int cost,int _1qtyprice) {
        this.product_name = product_name;
        this.variety=variety;
        this.qty=qty;
        this.date=date;
        this.cost=cost;
        this._1qtyprice=_1qtyprice;


    }

    public ProductDTO(int int1, String string, String string2, String string3, String string4) {
        //TODO Auto-generated constructor stub
    }

    public ProductDTO(int int1) {
        //TODO Auto-generated constructor stub
    }

    public int getAvailability() {
        return this.availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public int getProduct_id() {
        return this.product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getFarmer_id() {
        return this.farmer_id;
    }

    public void setFarmer_id(int farmer_id) {
        this.farmer_id = farmer_id;
    }

    public String getProduct_name() {
        return this.product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getVariety() {
        return this.variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public int getQty() {
        return this.qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCost() {
        return this.cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int get_1qtyprice() {
        return this._1qtyprice;
    }

    public void set_1qtyprice(int _1qtyprice) {
        this._1qtyprice = _1qtyprice;
    }

    // public static ConsumerDAO getInstance() {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'getInstance'");
    // }


}
