import React from 'react';

const Cart = ({ cartItems }) => {
  //console.log(cartItems);
  return (
    <div>
      <h2>Cart</h2>
      {cartItems.length > 0 ? (
        <ul>
          {cartItems.map((item) => (
            <li key={item.code}>
              {item.name} - Quantity: {item.quantity}
            </li>
          ))}
        </ul>
      ) : (
        <p>No items in the cart</p>
      )}
    </div>
  );
};

export default Cart;
