package com.example.ensiasea.Response;

import java.util.ArrayList;
import java.util.List;

import com.example.ensiasea.Entity.NFTitem;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(value = Include.NON_NULL)
public class NftItemResponse extends Response {
    private int count;
    private List<NFTitem> data;
    @JsonIgnore
    private NFTitem nftItem;

    public NftItemResponse(Boolean success, String messageError, String messageSuccess, int count, List<NFTitem> data,
            NFTitem nftItem) {
        super(success, messageError, messageSuccess);
        this.count = count;
        this.data = data;
        this.nftItem = nftItem;
        if (this.data == null && this.nftItem != null) {
            this.data = new ArrayList<>();
            this.data.add(nftItem);
            this.setCount(this.getData().size());
        }
    }
}
