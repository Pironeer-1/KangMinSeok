package org.Enemy;

public class Enemy {
    private int max_hp;
    private int hp;
    private int ad = 25;
    private int ad_defence =7;
    private int ap_defence =7;

    public Enemy(int playerNum) {
        this.max_hp = 100 * playerNum;
        this.hp = 100 * playerNum;
    }

    public int getMax_hp() {
        return max_hp;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }


    public int getAd() {
        return ad;
    }

    public void setAd(int ad) {
        this.ad = ad;
    }

    public int getAd_defence() {
        return ad_defence;
    }

    public void setAd_defence(int ad_defence) {
        this.ad_defence = ad_defence;
    }

    public int getAp_defence() {
        return ap_defence;
    }

    public void setAp_defence(int ap_defence) {
        this.ap_defence = ap_defence;
    }

}
