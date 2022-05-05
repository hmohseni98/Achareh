package service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.enumration.OrderStatus;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDTO {
    private Integer id;

    private String customerFullName;

    private String expertFullName;

    private String serviceName;

    private String orderDescription;

    private Integer expertSuggestionPrice;

    private String address;

    private LocalDate workDate;

    private LocalTime workTime;

    private OrderStatus orderStatus;

}
