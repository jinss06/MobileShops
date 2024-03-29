package mobileshop.edu.huatec.com.mobileshop2.http.entity;

import java.io.Serializable;

public class GoodsEntity implements Serializable {
    private int goods_id;
    private String name;
    private double price;
    private String mktprice;
    private String small;
    private int mkt_enable;
    private String briefGoodsCat;
    private String briefRrand;

    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getMktprice() {
        return mktprice;
    }

    public void setMktprice(String mktprice) {
        this.mktprice = mktprice;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public int getMkt_enable() {
        return mkt_enable;
    }

    public void setMkt_enable(int mkt_enable) {
        this.mkt_enable = mkt_enable;
    }

    public String getBriefGoodsCat() {
        return briefGoodsCat;
    }

    public void setBriefGoodsCat(String briefGoodsCat) {
        this.briefGoodsCat = briefGoodsCat;
    }

    public String getBriefRrand() {
        return briefRrand;
    }

    public void setBriefRrand(String briefRrand) {
        this.briefRrand = briefRrand;
    }

    @Override
    public String toString(){
        return "GoodEntity{"+
                "goods_id="+goods_id+
                ",name="+name+'\''+
                ",price="+price+
                ",mktprice="+mktprice+'\''+
                ",small="+small+'\''+
                ",mkt_enable="+mkt_enable+
                ",briefGoodsCat"+briefGoodsCat+'\''+
                ",briefBrand="+briefRrand+'\''+
                "}";
    }
}
