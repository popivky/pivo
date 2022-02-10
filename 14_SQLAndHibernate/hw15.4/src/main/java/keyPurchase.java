import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import java.io.Serializable;

@EqualsAndHashCode
@ToString
public class keyPurchase implements Serializable {

    public keyPurchase() {
    }

    public keyPurchase(String studentName, String courseName) {
        this.studentName = studentName;
        this.courseName = courseName;
    }

    @Getter
    @Setter
    @Column(name = "student_name")
    private String studentName;
    @Getter
    @Setter
    @Column(name = "course_name")
    private String courseName;



}
