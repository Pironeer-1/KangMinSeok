package org.Player;

import org.Enemy.Enemy;
import org.Enemy.enemyActive;
import java.util.Random;
import java.util.Scanner;

import static java.lang.System.exit;

// Player 클래스의 모든 메소드
public class playerActive {
    Scanner sc = new Scanner(System.in);
    Random random = new Random();
    final static enemyActive ea = new enemyActive();

    public void decrease_hp(Player p, int damage){
        p.setHp(Math.max(p.getHp() - damage, 0));
    }

    public void status_set(Player p, int point){
        System.out.println("------------------------------------------------------------------------------");
        System.out.println(point + "만큼의 스테이터스를 추가합니다. 체력, 공격력, 마법력 순으로 입력하세요\n(1 포인트 당 체력 = 3, 공격력 = 1, 마법력 = 1 증가)");
        System.out.println();

        System.out.println("플레이어의 기본 스탯은 체력: 50, 공격력: 10, 마법력: 5입니다.");
        System.out.println();

        int hp;
        int ad;
        int ap;
        while (true){
            while (true) {
                try {
                    hp = sc.nextInt();
                    ad = sc.nextInt();
                    ap = sc.nextInt();
                    break;
                }
                catch (Exception e){
                    System.out.println("hp, ad, ap는 정수로 입력해야 합니다. 다시 입력해주세요.");
                    continue;
                }
            }
            if (hp + ad + ap == point){
                p.setHp(p.getHp() + hp * 3);
                p.setAd(p.getAd() + ad);
                p.setAp(p.getAp() + ap);
                System.out.println("체력 : " + p.getHp() + ", 공격력: " + p.getAd() + ", 마법력: " + p.getAp());
                break;
            }
            else{
                System.out.println("입력한 능력치의 총합이 " + point + "와 같아야 합니다. 다시 입력해주세요.");
                continue;
            }
        }

    }

    public void check_status(Player p, Enemy e) {
        System.out.println("현재 유저: 체력 " + p.getHp() + ", 공격력 " + p.getAd() + ", 마법력 " + p.getAp());
        System.out.println("적: 체력 " + e.getHp() + ", 공격력 " + e.getAd() + ", 방어력 " + e.getAd_defence() + ", 마법방어력 " + e.getAp_defence());

        int damage = p.getAd() - e.getAd_defence();
        ea.decrease_hp(e, damage);
        System.out.println("일반 공격으로 " + damage + "의 데미지를 주었습니다.");
    }

    public void basic_attack(Player p, Enemy e) {
        int critical_point = random.nextInt(10) + 1;
        int damage = p.getAd() - e.getAd_defence();

        if (critical_point > 2){
            ea.decrease_hp(e, damage);
            System.out.println("일반 공격으로 " + damage + "의 데미지를 주었습니다.");
        }else{
            damage *= 2;
            ea.decrease_hp(e, damage);
            System.out.println("치명타가 적용되어 " + damage + "의 데미지를 주었습니다.");
        }
    }

    public void magic_attack(Player p, Enemy e){
        int damage = p.getAp()*2 - e.getAp_defence();
        ea.decrease_hp(e, damage);
        System.out.println("마법 공격으로 " + damage + "의 데미지를 주었습니다.");
    }

    public void heal_self(Player p){
        int heal_point = random.nextInt(10) + 5;
        p.setHp(p.getHp() + heal_point);
        System.out.println("체력을 회복합니다. 현재 hp는 " + p.getHp() + "입니다.");
    }

    public void attack(Player p, Enemy e, int player_index){
        String input_key;
        int input_num = 0;
        while (true) {
            try {
                System.out.println("------------------------------------------------------------------------------");
                System.out.println((player_index + 1) + "번 플레이어의 차례입니다. 행동을 선택하세요. (1: 스테이터스 확인 + 일반 공격, 2: 기본 공격, 3: 마법 공격, 4: 체력 회복, exit: 종료)");
                System.out.println();

                input_key = sc.next();
                if (input_key.equals("exit")) {
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                }
                input_num = Integer.valueOf(input_key);
                if (input_num < 1 || input_num > 4) {
                    System.out.println("1~4 사이의 정수를 입력해주세요.");
                    continue;
                }
                break;
            } catch (Exception exception) {
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
            }
        }
        if(input_num == 1){
            check_status(p, e);
        }
        else if(input_num == 2){
            basic_attack(p, e);
        }
        else if(input_num == 3){
            magic_attack(p, e);
        }
        else if(input_num == 4) {
            heal_self(p);
        }
    }
}
