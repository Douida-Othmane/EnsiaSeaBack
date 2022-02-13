package com.example.ensiasea.Response;

import java.util.ArrayList;
import java.util.List;

import com.example.ensiasea.Entity.Wallet;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(value = Include.NON_NULL)
public class WalletResponse extends Response {
    private int count;
    private List<Wallet> data;
    @JsonIgnore
    private Wallet wallet;

    public WalletResponse(Boolean success, String messageError, String messageSuccess, int count, List<Wallet> data,
            Wallet wallet) {
        super(success, messageError, messageSuccess);
        this.count = count;
        this.data = data;
        this.wallet = wallet;
        if (this.data == null && this.wallet != null) {
            this.data = new ArrayList<>();
            this.data.add(wallet);
            this.setCount(this.getData().size());
        }
    }
}
