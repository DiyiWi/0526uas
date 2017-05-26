package com.uas.cloud.mall.admin.domain;

import java.util.ArrayList;

/**
 * 楼层
 *
 * @author yangck
 * @create 2017-02-25 17:23
 */
public class Floor {

    private String id;

    /**
     * 用途
     */
    private String usedFor;

    private String name;

    /**
     * 楼层序号
     */
    private Integer floorNumber;


    private ArrayList<Item> items;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsedFor() {
        return usedFor;
    }

    public void setUsedFor(String usedFor) {
        this.usedFor = usedFor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Floor{" +
                "id='" + id + '\'' +
                ", usedFor='" + usedFor + '\'' +
                ", name='" + name + '\'' +
                ", floorNumber=" + floorNumber +
                ", items=" + items +
                '}';
    }
}
