package at.nacs.twitterboard.logic;

import at.nacs.twitterboard.persistence.domain.Tweet;
import at.nacs.twitterboard.persistence.repository.TweetRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class TwitterTest {

    @Autowired
    Twitter twitter;

    @MockBean
    TweetRepository repository;

    @Test
    void findAll() {
        twitter.findAll();
        verify(repository).findByOrderByTimestampDesc();
    }

    @Test
    void findOne() {
        String user = "Test user";
        twitter.findOne(user);
        verify(repository).findByUserOrderByTimestampDesc(user);
    }

    @Test
    void save() {
        Tweet tweet = new Tweet();
        assertThat(tweet.getTimestamp()).isNull();

        twitter.save(tweet);

        assertThat(tweet.getTimestamp()).isNotNull();
        verify(repository).save(tweet);
    }

    @Test
    void testThatLikeFindsATweet() {
        Tweet tweet = new Tweet();
        String id = "existing-id";
        when(repository.findById(id))
                .thenReturn(Optional.of(tweet));
        assertThat(tweet.getLikes()).isEqualTo(0);

        twitter.like(id);

        assertThat(tweet.getLikes()).isEqualTo(1);
        verify(repository).save(any(Tweet.class));
    }

    @Test
    void testThatLikeDoesNotFindATweet() {
        String id = "not-existing-id";
        when(repository.findById(id))
                .thenReturn(Optional.empty());

        twitter.like(id);

        verify(repository, times(0)).save(any(Tweet.class));
    }

    @Test
    void testCommentOnExistingTweet() {
        Tweet tweet = new Tweet();
        String id = "existing-tweet-id";
        when(repository.findById(id))
                .thenReturn(Optional.of(tweet));
        assertThat(tweet.getComments()).isEmpty();

        String comment = "comment";
        twitter.comment(id, comment);

        assertThat(tweet.getComments()).isNotEmpty();
        assertThat(tweet.getComments().size()).isEqualTo(1);
        assertThat(tweet.getComments()).contains(comment);
        verify(repository).save(tweet);
    }

    @Test
    void testCommentOnNonExistingTweet() {
        String id = "non-existing-tweet-id";
        when(repository.findById(id))
                .thenReturn(Optional.empty());

        String comment = "comment";
        twitter.comment(id, comment);

        verify(repository, times(0)).save(any(Tweet.class));
    }
}