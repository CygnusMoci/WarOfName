package com.moci.warofname.entity;

/**
 * @author : Cygnusmoci
 * @create : 2020-01-10 15:20
 * @description :
 */
public class nameHero {
    private String name;
    private int hp;
    private int mp;
    private int att;
    private int def;
    private skill[] skills;

    public nameHero(String name) {
        this.name = name;
        init();
    }

    private void init(){
        int len = name.length();
        int[] temp = new int[len];
        for (int i = 0; i <len ; i++) {
            temp[i] = name.charAt(i);
        }
        String sign = sign(temp);
        this.hp = toInt(sign.substring(0,4));
        this.mp = toInt(sign.substring(5,8));
        this.att = toInt(sign.substring(9,12));
        this.def = toInt(sign.substring(13,15));
    }

    private String sign(int[] arr){
        int len = arr.length;
        StringBuffer strSign = new StringBuffer();
        for (int i = 0; i < len; i++) {
            strSign.append(arr[i]);
        }
        String sign = strSign.toString()+"4396";
        while (sign.length()<20){
            sign+=sign;
        }
        return sign;
    }

    private int toInt(String str){
        if(str == null || str.length() == 0) return -1;
        return Integer.parseInt(str);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAtt(int att) {
        this.att = att;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public void setSkills(skill[] skills) {
        this.skills = skills;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public String getName() {
        return name;
    }

    public int getAtt() {
        return att;
    }

    public int getDef() {
        return def;
    }

    public skill[] getSkills() {
        return skills;
    }

    @Override
    public String toString() {
        return
                "{ 姓名 = '" + name + '\'' +
                ", 生命值 = " + hp +
                ", 魔法值 = " + mp +
                ", 攻击力 = " + att +
                ", 防御力 = " + def +
                '}';
    }
}
