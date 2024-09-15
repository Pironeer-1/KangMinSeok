package org.Game;

import org.Enemy.Enemy;
import org.Enemy.enemyActive;
import org.Player.Player;
import org.Player.playerActive;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collections.list;
import static java.util.Locale.filter;

//Main클래스의 모든 메소드
public class Game {
    playerActive pa = new playerActive();
    enemyActive ea = new enemyActive();
    Scanner sc = new Scanner(System.in);
    private int status_point = 13;
    private Player[] player_list;
    Enemy enemy;
    Random random = new Random();


    public void set_player(){
        int list_num;
        while (true){
            try{
                System.out.print("플레이어 인원을 정하세요: ");
                list_num = sc.nextInt();
                if(list_num <= 0){
                    System.out.println("플레이어 인원은 1 이상이어야 합니다.");
                    continue;
                }
                break;
            }
            catch(Exception e){
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
            }
        }
        player_list = new Player[list_num];
        for(int i = 0; i < list_num; i++){
            Player player = new Player();
            pa.status_set(player, status_point);
            player_list[i] =  player;
        }
    }

    public void set_enemy(){
        enemy = new Enemy(player_list.length);

    }

    public boolean turn_check(){
        player_list = Arrays.stream(player_list)
                .filter(player -> player.getHp() > 0)
                .toArray(Player[]::new);
        if(player_list.length == 0 || enemy.getHp() == 0){
            return false;
        }
        else{
            return true;
        }
    }

    public Player select_target_player(){
        return player_list[random.nextInt(player_list.length)];
    }

    public void game() {
        set_player();
        set_enemy();

        while(turn_check()){

            for(int index = 0; index < player_list.length; index++){
                pa.attack(player_list[index], enemy, index);
                if (enemy.getHp() == 0){
                    break;
                }
            }
            if(turn_check()) {
                Player target_player = select_target_player();
                int target_index = Arrays.asList(player_list).indexOf(target_player);

                ea.attack(enemy, target_player, target_index);
            }else{
                break;
            }
        }

        if (enemy.getHp() <= 0){
            System.out.println("축하합니다! 승리하셨습니다!");
        }
        else{
            System.out.println("아쉽지만 패배하셨습니다.");
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.game();
    }
}


