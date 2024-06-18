package Resources;

public class SellDTO {
    private int user_id;
    private int product_id;
    private int qty;
    private int totalprice;
    private String  date;
    private int sell_id;
    private String username;
    private String productname;
    private String variety;
    


    public SellDTO(int user_id, int product_id, int qty, int totalprice, String date, int sell_id){
        this.user_id = user_id;
        this.product_id = product_id;
        this.qty = qty;
        this.totalprice=totalprice;
        this.date = date;
        this.sell_id = sell_id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProductname() {
        return this.productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getVariety() {
        return this.variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public SellDTO() {
        //TODO Auto-generated constructor stub
    }

    public int getUser_id() {
        return this.user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getProduct_id() {
        return this.product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getQty() {
        return this.qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getTotalprice() {
        return this.totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getSell_id() {
        return this.sell_id;
    }

    public void setSell_id(int sell_id) {
        this.sell_id = sell_id;
    }
    
}
