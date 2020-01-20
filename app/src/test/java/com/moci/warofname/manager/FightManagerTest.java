package com.moci.warofname.manager;

import com.moci.warofname.entity.NameHero;

import org.junit.Test;

/**
 * @author : Cygnusmoci
 * @create : 2020-01-17 17:28
 * @description :
 */
public class FightManagerTest {
    private static NameHero p1;
    private static NameHero p2;

    @Test
    public void fight(){
        p1 = new NameHero("铅笔");
        p2 = new NameHero("英杰");
        int[] order = {0};
        System.out.println("双方属性如下");
        System.out.println(p1);
        System.out.println(p2);
        while (p1.getHp()>0 && p2.getHp() > 0){
            String result = FightManager.getInstance().fight(p1,p2,order);
            System.out.println(result);
        }
        String deathname = p1.getHp()>=0? p2.getName():p1.getName();
        System.out.println(deathname+"被打死了。");
    }

}