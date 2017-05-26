package com.uas.cloud.mall.admin.domain;

/**
 * 楼层项
 *
 * @author yangck
 * @create 2017-02-27 15:23
 */
public class Item {

    private Long id;
    private String name;
    private String body;
    private String pictureUrl;
    private String hrefUrl;
    private Integer orderNumber;
    /**
     * tiny、small、medium、large
     */
    private String size;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getHrefUrl() {
        return hrefUrl;
    }

    public void setHrefUrl(String hrefUrl) {
        this.hrefUrl = hrefUrl;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", body='" + body + '\'' +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", hrefUrl='" + hrefUrl + '\'' +
                ", orderNumber=" + orderNumber +
                ", size='" + size + '\'' +
                '}';
    }
}
