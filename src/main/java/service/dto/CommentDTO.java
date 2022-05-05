package service.dto;

import lombok.*;
import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CommentDTO {
    private Integer id;

    private String commentDescription;

    private Integer score;

    private LocalDate date;

    private LocalTime time;

    private String customerFullName;

    private String expertFullName;

    private String orderDescription;
}
