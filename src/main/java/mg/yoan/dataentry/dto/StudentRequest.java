package mg.yoan.dataentry.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class StudentRequest {
    private String Reference;
    private String FirstName;
    private String LastName;
    private Integer Age;
}
