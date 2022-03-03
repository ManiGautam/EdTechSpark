package com.manijee.edtechspark.repository;

import com.manijee.edtechspark.model.CartSavedErrorResponsemodel;

public interface OnCartItemSaved {
    void onSaveCartResponse(CartSavedErrorResponsemodel cartSavedErrorResponsemodel);
    void onSaveToCartFail(String msg);
}
