package com.company.Objects;

public enum Status {
    available("available"),
    pending("pending"),
    sold("sold");

    private final String status;

    Status(String status) {
        this.status = status;
    }

    @Override
    public String toString(){
        return status;
    }
}
