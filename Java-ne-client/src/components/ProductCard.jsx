import React from 'react';

const ProductCard = ({ product, onAddToCart }) => {
  const { id, name, price, quantity } = product;

  const handleAddToCart = () => {
    onAddToCart(product);
  };

  return (
    <div className="max-w-sm rounded overflow-hidden shadow-lg bg-white">
      <div className="px-6 py-4">
        <div className="font-bold text-xl mb-2">{name}</div>
        <p className="text-gray-700 text-base mb-2">price: {price}</p>
        <p className="text-gray-700 text-base mb-2">quantity: {quantity?.quantity}</p>
      </div>
      <div className="px-6 pb-4">
        <button
          className="bg-[#10B981] text-white font-bold py-2 px-4 rounded"
          onClick={handleAddToCart}
        >
          Add to Cart
        </button>
      </div>
    </div>
  );
};

export default ProductCard;
