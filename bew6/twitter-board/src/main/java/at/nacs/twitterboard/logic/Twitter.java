package at.nacs.twitterboard.logic;

import at.nacs.twitterboard.persistence.domain.Tweet;
import at.nacs.twitterboard.persistence.repository.TweetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class Twitter {

    private final TweetRepository tweetRepository;

    public List<Tweet> findAll(){
        return tweetRepository.findByOrderByTimestampDesc();
    }

    public List<Tweet> findOne (String user){
        return tweetRepository.findByUserOrderByTimestampDesc(user);
    }

    public Tweet save(Tweet tweet){
        tweet.setTimestamp(LocalDateTime.now());
        return tweetRepository.save(tweet);
    }

    public void like(String id){
        Optional<Tweet> byId = tweetRepository.findById(id);
        if (byId.isEmpty()){
            return;
        }
        Tweet tweet = byId.get();
        int likes = tweet.getLikes();
        tweet.setLikes(likes+1);
        tweetRepository.save(tweet);

    }

    public void comment(String id, String comment) {
        Optional<Tweet> byId = tweetRepository.findById(id);
        if (byId.isEmpty()) {
            return;
        }
        Tweet tweet = byId.get();
        tweet.getComments().add(comment);
        tweetRepository.save(tweet);
    }

}
