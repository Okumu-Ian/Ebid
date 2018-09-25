package models;

import java.io.Serializable;

public class PurchasesModel implements Serializable {
    private String image_url;
    private String date_bought;
    private String product_seller;
    private String order_id;
    private String price_bought;
    private String product_names;

    public String getProduct_names() {
        return product_names;
    }

    public PurchasesModel() {
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getDate_bought() {
        return date_bought;
    }

    public void setDate_bought(String date_bought) {
        this.date_bought = date_bought;
    }

    public String getProduct_seller() {
        return product_seller;
    }

    public void setProduct_seller(String product_seller) {
        this.product_seller = product_seller;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getPrice_bought() {
        return price_bought;
    }

    public void setPrice_bought(String price_bought) {
        this.price_bought = price_bought;
    }
}
