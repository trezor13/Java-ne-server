import React from 'react';

const Cart = ({ cartItems }) => {
  return (
    <div>
      <h2>Cart</h2>
      {cartItems.length > 0 ? (
        <ul>
          {cartItems.map((item) => (
            <li key={item.id}>
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
