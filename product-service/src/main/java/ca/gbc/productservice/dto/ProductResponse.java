package ca.gbc.productservice.dto;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProductResponse {
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
}
