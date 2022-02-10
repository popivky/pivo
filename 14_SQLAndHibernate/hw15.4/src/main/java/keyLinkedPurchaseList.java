import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import java.io.Serializable;

@EqualsAndHashCode
@ToString

public class keyLinkedPurchaseList implements Serializable {

    public keyLinkedPurchaseList(int studentId, int courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    @Getter
    @Setter
    @Column(name = "student_id")
    private int studentId;

    @Getter
    @Setter
    @Column(name = "course_id")
    private int courseId;


}
