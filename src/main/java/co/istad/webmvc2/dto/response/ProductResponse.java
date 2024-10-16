package co.istad.webmvc2.dto.response;

import java.math.BigDecimal;

public record ProductResponse(
    String code,
    String name,
    BigDecimal price
) {
}
