package com.ite.itea.domain;

import com.ite.itea.application.dto.ProductDTO;
import com.ite.itea.application.dto.OrderDTO;
import com.ite.itea.application.dto.ReceiptDTO;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class CheckoutCalculator {

    public ReceiptDTO calculatePrice(OrderDTO orderDto) {
        var price = getPrice(orderDto);
        var text = getText(orderDto, price);

        return new ReceiptDTO(price, text);
    }

    private String getText(OrderDTO orderDto, long priceInCents) {
        var text = "itea \n";

        for (ProductDTO productDTO : orderDto.productDTOs()) {
            text += convertToText(productDTO);
        }

        text += "Total " + formatPrice(priceInCents);

        return text;
    }

    private String convertToText(ProductDTO productDTO) {
        if (productDTO.getAmount() <= 0) {
            return "";
        }

        final var productName = productDTO.getName();
        final var price = formatPrice(productDTO.getPriceInCents());
        final var amount = productDTO.getAmount();
        return MessageFormat.format("{0} {1} * {2}\n", productName, price, amount);
    }

    private String formatPrice(long priceInCents) {
        var currencyFormat = NumberFormat.getCurrencyInstance(Locale.GERMANY);
        var decimalPrice = BigDecimal.valueOf(priceInCents).movePointLeft(2);
        return currencyFormat.format(decimalPrice);
    }

    private long getPrice(OrderDTO orderDto) {
        return orderDto.productDTOs().stream()
                .mapToLong(product -> product.getAmount() * product.getPriceInCents())
                .sum();
    }
}
