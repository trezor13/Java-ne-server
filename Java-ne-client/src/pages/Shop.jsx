import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import { API_URL } from '../utils/api';
import Navbar from '../components/Navbar';
import ProductCard from '../components/ProductCard';
import Cart from '../components/Cart';

function Shop() {
  const navigate = useNavigate();
  const token = localStorage.getItem('token');
  const [products, setProducts] = useState([]);
  const [cartItems, setCartItems] = useState([]);

  const fetchProducts = async () => {
    try {
      const response = await axios.get(API_URL + '/product/all', {
        headers: {
          Authorization: `Bearer ${token}`,
        },
      });
      setProducts(response?.data);
    } catch (error) {
      console.log(error);
    }
  };

  useEffect(() => {
    if (!token) {
      navigate('/login');
    }
    fetchProducts();
    setCartItems(JSON.parse(localStorage.getItem('cartItems')) || []);
  }, [navigate, token]);

  const handleAddToCart = (product) => {
    // Retrieve existing cart items from local storage
    const existingCartItems = JSON.parse(localStorage.getItem('cartItems')) || [];

    // Check if the product is already in the cart
    const existingProduct = existingCartItems.find((item) => item.id === product.id);

    if (existingProduct) {
      // Increment the quantity if the product already exists in the cart
      existingProduct.quantity++;
    } else {
      // Add the product to the cart with an initial quantity of 1
      existingCartItems.push({ ...product, quantity: 1 });
    }

    // Save the updated cart items in local storage
    localStorage.setItem('cartItems', JSON.stringify(existingCartItems));

    // Update the cart items state
    setCartItems(existingCartItems);
  };

  const handleCheckout = async () => {
    try {
      const cart = cartItems.reduce((map, item) => {
        map[item.id] = item.quantity;
        return map;
      }, {});
      console.log(cart);

      const response = await axios.post(API_URL + '/product/purchase', cart, {
        headers: {
          Authorization: `Bearer ${token}`,
        },
      });

      // Handle the response after checkout (e.g., show success message, clear cart, etc.)
      console.log('Checkout successful');
      console.log(response.data);

      // Clear the cart by removing the cart items from local storage
      localStorage.removeItem('cartItems');
      setCartItems([]);
    } catch (error) {
      console.log('Checkout failed');
      console.log(error);
    }
  };

  return (
    <div>
      <Navbar />
      <div className="mt-12">
        {products.length > 0 ? (
          <div className="grid grid-cols-1 md:grid-cols-3 gap-4">
            {products.map((product) => (
              <ProductCard key={product.id} product={product} onAddToCart={handleAddToCart} />
            ))}
          </div>
        ) : (
          <p className="text-center">No products found</p>
        )}
      </div>
      <Cart cartItems={cartItems} />
      <div className="flex justify-center mt-4">
      <button
          className="bg-[#10B981] text-white font-bold py-2 px-4 rounded"
          onClick={handleCheckout}
        >
          Checkout
        </button>
      </div>
    </div>
  );
}

export default Shop;
