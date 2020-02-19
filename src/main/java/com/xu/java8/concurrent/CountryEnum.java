package com.xu.java8.concurrent;

import lombok.Getter;

public enum CountryEnum {
    ONE(1,"楚"),TWO(2,"齐"),THREE(3,"燕"),FOUR(4,"赵"),FIVE(5,"魏"),SIX(6,"韩");

    @Getter private Integer retCode;
    @Getter private String retMessage;

    CountryEnum(Integer retCode, String retMessage) {
        this.retCode = retCode;
        this.retMessage = retMessage;
    }

    public  static CountryEnum forEachCountEnum(int index){
        CountryEnum[] countryEnums = CountryEnum.values();
        for (CountryEnum countryEnum : countryEnums) {
            if (index == countryEnum.retCode) {
                return countryEnum;
            }
        }
        return null;
    }
}
