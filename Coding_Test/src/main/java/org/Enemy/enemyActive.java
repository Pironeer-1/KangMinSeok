package org.Enemy;

import org.Player.Player;
import org.Player.playerActive;

import java.util.Random;

//Enemy클래스의 모든 메소드
public class enemyActive {
    Random random = new Random();
    final static playerActive pa = new playerActive();
    public void decrease_hp(Enemy e, int damage){
        e.setHp(Math.max(e.getHp() - damage , 0 ));
    }
    public void basic_attack(Enemy e, Player p, int player_index){
        pa.decrease_hp(p, e.getAd());
        System.out.println((player_index + 1) + "번 유저에게 " + e.getAd() + "의 데미지. 적의 공격으로 현재 남은 체력은 " + p.getHp() + "입니다.");
    }
    public void heal_self(Enemy e){
        int healing_amount = 7;
        if (e.getMax_hp() < e.getHp() + healing_amount){
            System.out.println("적이 회복했지만 적은 이미 최대체력입니다.");
        }
        else{
            e.setHp(e.getHp() + healing_amount);
            System.out.println("적의 회복으로 현재 적의 체력은 " + e.getHp() + "입니다.");
        }
    }
    public void attack(Enemy e, Player p, int player_index){
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("적의 차례입니다.");
        System.out.println();

        int enemy_action = random.nextInt(10) + 1;

        if (enemy_action == 1){
            System.out.println("적은 섣불리 움직이지 못하고 있습니다.");
            System.out.println();
        }
        else if (enemy_action >= 2 && enemy_action <= 8){
            basic_attack(e ,p , player_index);
        }
        else{
            heal_self(e);
        }
    }
}
