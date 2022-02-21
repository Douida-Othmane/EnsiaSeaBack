package com.example.ensiasea.Response;

import java.util.ArrayList;
import java.util.List;

import com.example.ensiasea.Models.PriceHistory;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(value = Include.NON_NULL)
public class PriceHistoryResponse extends Response {
    private int count;
    private List<PriceHistory> data;
    @JsonIgnore
    private PriceHistory priceHistory;

    public PriceHistoryResponse(Boolean success, String messageError, String messageSuccess, int count,
            List<PriceHistory> data,
            PriceHistory priceHistory) {
        super(success, messageError, messageSuccess);
        this.count = count;
        this.data = data;
        this.priceHistory = priceHistory;
        if (this.data == null && this.priceHistory != null) {
            this.data = new ArrayList<>();
            this.data.add(priceHistory);
            this.setCount(this.getData().size());
        }
    }
}
