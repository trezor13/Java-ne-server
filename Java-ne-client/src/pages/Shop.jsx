import React,{useEffect,useState} from 'react'
import Navbar from '../components/Navbar'
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import { API_URL } from '../utils/api';
import ProductCard from '../components/ProductCard';
import Cart from '../components/Cart';

function Shop() {
  const navigate = useNavigate();
  const token = localStorage.getItem("token")
  const [products, setProducts] = useState([])

  const fetchProducts = async () => {
  try {
    const response = await axios.get(API_URL + "/product/all", {
      headers: {
        Authorization: `Bearer ${token}` // Use template literal to concatenate the token properly
      }
    });
    console.log(response.data);
    setProducts(response?.data);
  } catch (error) {
    console.log(error);
  }
};

  useEffect(()=>{
    //redirect to login form when no token found
    if(!token){
      navigate('/login');
    }
    // console.log("Bearer "+token);
    //make get request to fetch all products
    fetchProducts();

  },[token])

  return (

    <div>
      <Navbar/>
        <div className='mt-12'>
          {products.length > 0 ? (
            <div className='grid grid-cols-1 md:grid-cols-3 gap-4'>
              {products.map((product) => (
                <ProductCard key={product.id} product={product}/>
              ))}
              </div>
          ) : (
            <p className='text-center'>No products found</p>
          )}
        </div>
        <Cart/>
    </div>
  )
}

export default Shop