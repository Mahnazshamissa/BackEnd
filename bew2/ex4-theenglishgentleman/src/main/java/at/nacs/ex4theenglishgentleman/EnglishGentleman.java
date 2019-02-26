package at.nacs.ex4theenglishgentleman;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Scope("prototype")
public class EnglishGentleman {

    private final Monocle monocle;
    private final Lighter lighter;

    @Getter
    private boolean smoked;
    @Getter
    private boolean read;

    public void smoke(Cigar cigar) throws CigarWasNotLitException {
        // use the lighter to light the cigar
        // smoke the cigar
        // remember that he smoked a cigar
        lighter.light(cigar);
        cigar.smoke();
        smoked=true;

    }


    public void read(Newspaper newspaper) {
        // use the monocle to read the newspaper
        // remember that he read a newspaper

        monocle.read(newspaper);
        read=true;

    }


    public boolean hadAGoodDay() {
        return smoked && read;
    }

}
