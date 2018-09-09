/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import com.fasterxml.jackson.databind.JsonNode;
import java.io.Serializable;

/**
 *
 * @author stsno
 */
public class ItemData implements Serializable{
    public ItemData(){}

    private String code;
    private String name;
    private String headine;
    private String description;
    private String janCode;
    private String imageSmall;
    private String imageMedium;
    private String imageExlmage;
    private double reviewRate;
    private int reviewCount;
    private int price;
    private int priceLabel;
    private int priceLabelSaleLimit;
    private int point;
    private int shippingCode;
    private String shippingName;
    private String releaseDate;
    private String storeId;
    private String storeName;
    private String sellerType;
    private double storeRatingsRate;
    private double storeRatingsDetailRate;
    private int storeRatingsCount;
    private String storeImageMedium;
    private String storeSameDayDeliveryAreasArea;
    private String caption;
    private String oneComment;

    public String getCode(){return this.code;}
    public void setCode(String code){this.code = code;}

    public String getName(){return this.name;}
    public void setName(String name){this.name = name;}

    public String getHeadine(){return this.headine;}
    public void setHeadine(String headine){this.headine = headine;}

    public String getDescription(){return this.description;}
    public void setDescription(String description){this.description = description;}

    public String getJanCode(){return this.janCode;}
    public void setJanCode(String janCode){this.janCode = janCode;}

    public String getImageSmall(){return this.imageSmall;}
    public void setImageSmall(String imageSmall){this.imageSmall = imageSmall;}

    public String getImageMedium(){return this.imageMedium;}
    public void setImageMedium(String imageMedium){this.imageMedium = imageMedium;}

    public String getImageExlmage(){return this.imageExlmage;}
    public void setImageExlmage(String imageExlmage){this.imageExlmage = imageExlmage;}

    public double getReviewRate(){return this.reviewRate;}
    public void setReviewRate(double reviewRate){this.reviewRate = reviewRate;}

    public int getReviewCount(){return this.reviewCount;}
    public void setReviewCount(int reviewCount){this.reviewCount = reviewCount;}

    public int getPrice(){return this.price;}
    public void setPrice(int price){this.price = price;}

    public int getPriceLabel(){return this.priceLabel;}
    public void setPriceLabel(int priceLabel){this.priceLabel = priceLabel;}

    public int getPriceLabelSaleLimit(){return this.priceLabelSaleLimit;}
    public void setPriceLabelSaleLimit(int priceLabelSaleLimit){this.priceLabelSaleLimit = priceLabelSaleLimit;}

    public int getPoint(){return this.point;}
    public void setPoint(int point){this.point = point;}

    public int getShippingCode(){return this.shippingCode;}
    public void setShippingCode(int shippingCode){this.shippingCode = shippingCode;}

    public String getShippingName(){return this.shippingName;}
    public void setShippingName(String shippingName){this.shippingName = shippingName;}

    public String getReleaseDate(){return this.releaseDate;}
    public void setReleaseDate(String releaseDate){this.releaseDate = releaseDate;}

    public String getStoreId(){return this.storeId;}
    public void setStoreId(String storeId){this.storeId = storeId;}

    public String getStoreName(){return this.storeName;}
    public void setStoreName(String storeName){this.storeName = storeName;}

    public String getSellerType(){return this.sellerType;}
    public void setSellerType(String sellerType){this.sellerType = sellerType;}

    public double getStoreRatingsRate(){return this.storeRatingsRate;}
    public void setStoreRatingsRate(double storeRatingsRate){this.storeRatingsRate = storeRatingsRate;}

    public double getStoreRatingsDetailRate(){return this.storeRatingsDetailRate;}
    public void setStoreRatingsDetailRate(double storeRatingsDetailRate){this.storeRatingsDetailRate = storeRatingsDetailRate;}

    public int getStoreRatingsCount(){return this.storeRatingsCount;}
    public void setStoreRatingsCount(int storeRatingsCount){this.storeRatingsCount = storeRatingsCount;}

    public String getStoreImageMedium(){return this.storeImageMedium;}
    public void setStoreImageMedium(String storeImageMedium){this.storeImageMedium = storeImageMedium;}

    public String getStoreSameDayDeliveryAreasArea(){return this.storeSameDayDeliveryAreasArea;}
    public void setStoreSameDayDeliveryAreasArea(String storeSameDayDeliveryAreasArea){this.storeSameDayDeliveryAreasArea = storeSameDayDeliveryAreasArea;}

    public String getCaption(){return this.caption;}
    public void setCaption(String caption){this.caption = caption;}

    public String getOneComment(){return this.oneComment;}
    public void setOneComment(String oneComment){this.oneComment = oneComment;}

    //APIデータをProductDataにマッピング
    //引数　JsonNode
    public void SdAPIMapping(JsonNode jn){
        //Lがぬけてる直し
        this.setCode(jn.get("ResultSet").get("0").get("Result").get("0").get("Code").asText());
        this.setName(jn.get("ResultSet").get("0").get("Result").get("0").get("Name").asText());
        this.setHeadine(jn.get("ResultSet").get("0").get("Result").get("0").get("Headline").asText());
        this.setDescription(jn.get("ResultSet").get("0").get("Result").get("0").get("Description").asText());
        this.setJanCode(jn.get("ResultSet").get("0").get("Result").get("0").get("JanCode").asText());
        this.setImageSmall(jn.get("ResultSet").get("0").get("Result").get("0").get("Image").get("Small").asText());
        this.setImageMedium(jn.get("ResultSet").get("0").get("Result").get("0").get("Image").get("Medium").asText());
//        this.setImageExlmage(jn.get("ResultSet").get("0").get("Result").get("0").get("").get("Count").asText());
        this.setReviewRate(jn.get("ResultSet").get("0").get("Result").get("0").get("Review").get("Rate").asDouble());
        this.setReviewCount(jn.get("ResultSet").get("0").get("Result").get("0").get("Review").get("Count").asInt());
        this.setPrice(jn.get("ResultSet").get("0").get("Result").get("0").get("Price").get("_value").asInt());
        this.setPriceLabel(jn.get("ResultSet").get("0").get("Result").get("0").get("PriceLabel").get("DefaultPrice").asInt());
//        this.setPriceLabelSaleLimit(jn.get("ResultSet").get("0").get("Result").get("0").get("PriceLabel").get("Inventiries").get("Inventory").get("Quantity").asInt());
        this.setPoint(jn.get("ResultSet").get("0").get("Result").get("0").get("Point").get("Amount").asInt());
        this.setShippingCode(jn.get("ResultSet").get("0").get("Result").get("0").get("Shipping").get("Code").asInt());
        this.setShippingName(jn.get("ResultSet").get("0").get("Result").get("0").get("Shipping").get("Name").asText());
        this.setReleaseDate(jn.get("ResultSet").get("0").get("Result").get("0").get("ReleaseDate").asText());
        this.setStoreId(jn.get("ResultSet").get("0").get("Result").get("0").get("Store").get("Id").asText());
        this.setStoreName(jn.get("ResultSet").get("0").get("Result").get("0").get("Store").get("Name").asText());
        this.setSellerType(jn.get("ResultSet").get("0").get("Result").get("0").get("Store").get("SellerType").asText());
        this.setStoreRatingsRate(jn.get("ResultSet").get("0").get("Result").get("0").get("Store").get("Ratings").get("Rate").asInt());
        this.setStoreRatingsDetailRate(jn.get("ResultSet").get("0").get("Result").get("0").get("Store").get("Ratings").get("DetailRate").asDouble());
        this.setStoreRatingsCount(jn.get("ResultSet").get("0").get("Result").get("0").get("Store").get("Ratings").get("Total").asInt());
        this.setStoreImageMedium(jn.get("ResultSet").get("0").get("Result").get("0").get("Store").get("Image").get("Medium").asText());
        this.setStoreSameDayDeliveryAreasArea(jn.get("ResultSet").get("0").get("Result").get("0").get("Store").get("SameDayDelivery").get("Areas").asText());
        this.setCaption(jn.get("ResultSet").get("0").get("Result").get("0").get("Caption").asText());
        this.setOneComment(jn.get("ResultSet").get("0").get("Result").get("0").get("Abstract").asText());
    }
 
 

 }
