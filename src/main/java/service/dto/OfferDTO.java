package service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OfferDTO {
    private Integer id;

    private String expertFullName;

    private String customerFullName;

    private String orderDescription;

    private String serviceName;

    private Integer customerSuggestionPrice;

    private Integer expertSuggestionPrice;

    private Integer durationOfWork;

    private LocalTime startWorkTime;
}
