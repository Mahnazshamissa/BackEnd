package at.nacs.basketball;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Configuration
public class Tournament {

    @Bean
    ApplicationRunner applicationRunner(TeamLoader teamLoader) {
        return args -> {
            System.out.println("-------------------------------------");
            System.out.println("Welcome to the street basketball tournament!\n" +
                    "These are the teams who signed up:");
            Set<BasketballTeam> basketball = teamLoader.getTeams();
            basketball.stream()
                    .forEach(e -> System.out.println("Team: " + e.getName() + " | Players: " + e.getPlayers()));
        };
    }

    @Bean
    ApplicationRunner applicationRunner2(TeamLoader teamLoader) {
        return args -> {
            Set<BasketballTeam> basketball = teamLoader.getTeams();
            Deque<BasketballTeam> teams = new ArrayDeque<>(basketball);
            System.out.println("-------------------------------------");

            while (teams.size() > 1) {
                BasketballTeam team1 = teams.poll();
                BasketballTeam team2 = teams.poll();
                System.out.println(team1.getName() + " plays vs " + team2.getName());
                List<BasketballTeam> play = new ArrayList<>();
                play.add(team1);
                play.add(team2);
                BasketballTeam winner = playBasketbal(play);
                teams.addLast(winner);
                System.out.println("And " + winner.getName() + " wins this match!");
            }
            System.out.println("The tournament's winning team is " + teams.poll().getName());

        };

    }

    private BasketballTeam playBasketbal(List<BasketballTeam> teams) {
        Random random = new Random();
        int position = random.nextInt(2);
        return teams.get(position);
    }

}
