package coffee.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Entry {
    private Integer total;
    private Integer numWhite;
    private Double percentWhite;
    private Integer numBlack;
    private Double percentBlack;
    private String colourLast;
}
