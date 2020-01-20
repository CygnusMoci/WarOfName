package com.moci.warofname.manager;

import com.moci.warofname.entity.NameHero;

import java.util.Random;

/**
 * @author : Cygnusmoci
 * @create : 2020-01-13 09:53
 * @description :
 */
public class FightManager {
    private static FightManager instance;
    private int damage;
    private String damageResult;
    private boolean antiAtt;

    public static FightManager getInstance() {
        if (instance == null) {
            instance = new FightManager();
        }
        return instance;
    }

    public String fight(NameHero p1, NameHero p2, int[] order){

        String result = "战斗失败";
        if(order == null || order.length <= 0){
            return result;
        }

        if(order[0]!= 0 && order[0] != 1){
            return result;
        }

        NameHero att_p = p1;
        NameHero def_p = p2;
        int ord = order[0];
        if(ord == 1){
            att_p = p2;
            def_p = p1;
        }
        damage = attDamageResult(att_p.getAtt(),def_p.getDef());
        if(antiAtt){
            damageResult = "奋起反抗"+"造成了"+damage+"点伤害";
            antiAtt = false;
        }else {
            damageResult = damage>0?("造成了"+damage+"点伤害") : "然而并没有造成伤害";
        }

        result = fightResult(att_p, def_p);
        damage = damage>0?damage: 0;
        def_p.setHp(def_p.getHp()-damage);
        order[0] = -order[0] +1;
        return  result;
    }

    private int attDamageResult(int att,int def){
        int ret = 0;
        if(att > def){
            ret = (int)(Math.random() * (att - def));

            return ret;
        }

        if(new Random().nextInt(10) < 1){
            antiAtt = true;
            ret = att*10-def;

            return ret;
        }

        return ret;
    }

    private int skillDamageResult(NameHero p1, NameHero p2){
        return 0;
    }

    private String fightResult(NameHero att, NameHero def){
        String result = "";
        int attCode = new Random().nextInt(5);
        switch (attCode){
            case 0:
                result = att.getName()+"乘其不备，锤了"+def.getName()+"一拳"+", "+damageResult;
                break;
            case 1:
                result = att.getName()+"抬手就是一巴掌扇在"+def.getName()+"脸上"+", "+damageResult;
                break;
            case 2:
                result = att.getName()+"一jio甩到"+def.getName()+"腰子上"+", "+damageResult;
                break;
            case 3:
                result = att.getName()+"捅了"+def.getName()+"屁眼"+", "+damageResult;
                break;
            case 4:
                result = att.getName()+"一记上勾拳命中"+def.getName()+", "+damageResult;
                break;
        }

        return result;
    }
}
