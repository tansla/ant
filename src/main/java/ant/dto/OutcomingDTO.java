package ant.dto;

import ant.model.Coordinate;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OutcomingDTO {

    private final  String antKey = "F583CB63-3A8D-3269-A7F7-598D6DE5D83C";
    private int[] next_step_coords;

    public void setNext_step_coords(Coordinate next_step_coords) {
        this.next_step_coords = new int[2];
        this.next_step_coords[0] = next_step_coords.getX();
        this.next_step_coords[1] = next_step_coords.getY();
    }


}
