package at.nacs.twitterboard.communication;

import at.nacs.twitterboard.logic.Twitter;
import at.nacs.twitterboard.persistence.domain.Tweet;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tweets")
@RequiredArgsConstructor
public class TweetsEndpoint {

    private final Twitter twitter;

    @GetMapping
    public List<Tweet> get(){
        return twitter.findAll();
    }

    @GetMapping("/user/{user}")
    public List<Tweet> getOne(@PathVariable String user){
        return twitter.findOne(user);
    }

    @PostMapping
    public Tweet post(@RequestBody Tweet tweet){
        return twitter.save(tweet);
    }

    @PutMapping("/{id}/likes")
    public void like(@PathVariable String id) {
        twitter.like(id);
    }

    @PutMapping("/{id}/comments")
    public void comment(@PathVariable String id, @RequestBody String comment) {
        twitter.comment(id, comment);
    }

}
