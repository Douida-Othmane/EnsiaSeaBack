package com.example.ensiasea.Response;

import java.util.ArrayList;
import java.util.List;

import com.example.ensiasea.Entity.Offer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(value = Include.NON_NULL)
public class OfferResponse extends Response {
    private int count;
    private List<Offer> data;
    @JsonIgnore
    private Offer offer;

    public OfferResponse(Boolean success, String messageError, String messageSuccess, int count, List<Offer> data,
            Offer offer) {
        super(success, messageError, messageSuccess);
        this.count = count;
        this.data = data;
        this.offer = offer;
        if (this.data == null && this.offer != null) {
            this.data = new ArrayList<>();
            this.data.add(offer);
            this.setCount(this.getData().size());
        }
    }
}
