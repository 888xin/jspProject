package com.lhx.entity;

/**
 * Created by lhx on 15-1-16 上午10:30
 *
 * @project jspProject
 * @package com.lhx.entity
 * @Description
 * @blog http://blog.csdn.net/u011439289
 * @email 888xin@sina.com
 * @github https://github.com/888xin
 */
public class Word {
    //次数
    private int number ;
    //名称
    private String name ;

    public Word(){}

    public Word(int number, String name){
        this.number = number ;
        this.name = name ;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
