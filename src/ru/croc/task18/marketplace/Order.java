package ru.croc.task18.marketplace;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<Integer> userIdList;
    private List<Integer> productIdList;

    public Order(List<Integer> userIdList, List<Integer> productIdList) {
        this.userIdList = new ArrayList<>(userIdList);
        this.productIdList = new ArrayList<>(productIdList);
    }

    public List<Integer> getUserId() {
        return new ArrayList<>(userIdList);
    }

    public List<Integer> getProductId() {
        return new ArrayList<>(productIdList);
    }

}
