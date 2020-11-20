package ant.dto;

import ant.model.Coordinate;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IncomingDTO {

    //@JsonProperty("login")
    private int[][] map;
    private int[] start_coords;
    private int[] current_target;
    private String permition;
    private String description;

    public Coordinate getStart_coords() {
        return new Coordinate(start_coords);
    }

    public Coordinate getCurrent_target() {
        return new Coordinate(current_target);
    }
}
