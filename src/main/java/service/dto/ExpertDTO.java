package service.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ExpertDTO {
    private Integer id;

    private String expertFullName;

    private String serviceName;

    private String categoryName;

}
