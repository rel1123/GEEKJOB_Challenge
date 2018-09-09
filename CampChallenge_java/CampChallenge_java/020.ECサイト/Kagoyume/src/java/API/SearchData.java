/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import com.fasterxml.jackson.databind.JsonNode;
import java.io.Serializable;
import java.net.URL;
import java.util.Calendar;

/**
 * 1件分の検索結果を保存しておけるjavabeans
 * JsonNodeを渡せば結果を格納してくれるメソッドを持つ
 */
public class SearchData implements Serializable{
    public SearchData(){}

    private String name;
    private String description;
    private String headline;
    private String code;
    private String personId;
    private String productId;
    private String imageId;
    private String imageUrl;
    private double reviewRate;
    private int reviewCount;
    private int price;
    private int priceLabel;
    private String shippingCode;
    private String shippingName;
    private String brandsName;
    private String storeName;

    public String getName(){return this.name;}
    public void setName(String name){this.name = name;}

    public String getDescription(){return this.description;}
    public void setDescription(String description){this.description = description;}

    public String getHeadline(){return this.headline;}
    public void setHeadline(String headline){this.headline = headline;}

    public String getCode(){return this.code;}
    public void setCode(String code){this.code = code;}

    public String getPersonId(){return this.personId;}
    public void setPersonId(String personId){this.personId = personId;}

    public String getProductId(){return this.productId;}
    public void setProductId(String productId){this.productId = productId;}

    public String getImageId(){return this.imageId;}
    public void setImageId(String imageId){this.imageId = imageId;}
    
    public String getImageUrl(){return this.imageUrl;}
    public void setImageUrl(String imageUrl){this.imageUrl = imageUrl;}

    public double getReviewRate(){return this.reviewRate;}
    public void setReviewRate(double reviewRate){this.reviewRate = reviewRate;}

    public int getReviewCount(){return this.reviewCount;}
    public void setReviewCount(int reviewCount){this.reviewCount = reviewCount;}

    public int getPrice(){return this.price;}
    public void setPrice(int price){this.price = price;}

    public int getPriceLabel(){return this.priceLabel;}
    public void setPriceLabel(int priceLabel){this.priceLabel = priceLabel;}

    public String getShippingCode(){return this.shippingCode;}
    public void setShippingCode(String shippingCode){this.shippingCode = shippingCode;}

    public String getShippingName(){return this.shippingName;}
    public void setShippingName(String shippingName){this.shippingName = shippingName;}

    public String getBrandsName(){return this.brandsName;}
    public void setBrandsName(String brandsName){this.brandsName = brandsName;}

    public String getStoreName(){return this.storeName;}
    public void setStoreName(String storeName){this.storeName = storeName;}

    //APIデータをProductDataにマッピング
    //引数　JsonNode , 検索件数0~9
    public void SdAPIMapping(JsonNode jn,int i){
        this.setName(jn.get("ResultSet").get("0").get("Result").get(String.valueOf(i)).get("Name").asText());
        this.setDescription(jn.get("ResultSet").get("0").get("Result").get(String.valueOf(i)).get("Description").asText());
        this.setHeadline(jn.get("ResultSet").get("0").get("Result").get(String.valueOf(i)).get("Headline").asText());
        this.setCode(jn.get("ResultSet").get("0").get("Result").get(String.valueOf(i)).get("Code").asText());
        this.setPersonId(jn.get("ResultSet").get("0").get("Result").get(String.valueOf(i)).get("PersonId").asText());
        this.setProductId(jn.get("ResultSet").get("0").get("Result").get(String.valueOf(i)).get("ProductId").asText());
        this.setImageId(jn.get("ResultSet").get("0").get("Result").get(String.valueOf(i)).get("Image").get("Id").asText());
        this.setImageUrl(jn.get("ResultSet").get("0").get("Result").get(String.valueOf(i)).get("Image").get("Small").asText());
        this.setReviewRate(jn.get("ResultSet").get("0").get("Result").get(String.valueOf(i)).get("Review").get("Rate").asDouble());
        this.setReviewCount(jn.get("ResultSet").get("0").get("Result").get(String.valueOf(i)).get("Review").get("Count").asInt());
        this.setPrice(Integer.valueOf(jn.get("ResultSet").get("0").get("Result").get(String.valueOf(i)).get("Price").get("_value").asText()));
        this.setPriceLabel(jn.get("ResultSet").get("0").get("Result").get(String.valueOf(i)).get("PriceLabel").get("DefaultPrice").asInt());
        this.setShippingCode(jn.get("ResultSet").get("0").get("Result").get(String.valueOf(i)).get("Shipping").get("Code").asText());
        this.setShippingName(jn.get("ResultSet").get("0").get("Result").get(String.valueOf(i)).get("Shipping").get("Name").asText());
        this.setBrandsName(jn.get("ResultSet").get("0").get("Result").get(String.valueOf(i)).get("Brands").get("Name").asText());
        this.setStoreName(jn.get("ResultSet").get("0").get("Result").get(String.valueOf(i)).get("Store").get("Name").asText());
    }
    
    
 }
