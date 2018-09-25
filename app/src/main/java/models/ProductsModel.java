package models;

import java.io.Serializable;

public class ProductsModel implements Serializable {


    private String timer,image_url,product_name,product_price;

    public ProductsModel(String timer, String image_url, String product_name, String product_price) {
        this.timer = timer;
        this.image_url = image_url;
        this.product_name = product_name;
        this.product_price = product_price;
    }

    public ProductsModel() {
    }

    public String getTimer() {
        return timer;
    }

    public void setTimer(String timer) {
        this.timer = timer;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_price() {
        return product_price;
    }

    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }
}
