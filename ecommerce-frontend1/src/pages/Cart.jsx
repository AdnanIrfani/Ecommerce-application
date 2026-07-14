import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import Navbar from "../components/Navbar";
import api from "../services/api";

function Cart() {

    const navigate = useNavigate();

    useEffect(() => {

        if (!localStorage.getItem("userId")) {

            navigate("/");

        }

    }, []);
    const [cartItems, setCartItems] = useState([]);

    const userId = localStorage.getItem("userId");

    useEffect(() => {
        loadCart();
    }, []);

    const loadCart = () => {
        api.get(`/cart/${userId}`)
            .then(res => setCartItems(res.data))
            .catch(err => console.log(err));
    };

    const removeItem = (cartId) => {

        api.delete(`/cart/${cartId}`)
            .then(() => {
                alert("Item Removed");
                loadCart();
            });

    };

    const buyNow = () => {

        api.post(`/orders/buy/${userId}`)
            .then(res => {

                alert(res.data);

                navigate("/orders");

            });

    };

    const total = cartItems.reduce(
        (sum, cart) => sum + (cart.item.price * cart.quantity),
        0
    );

    return (

        <>
            <Navbar />

            <div className="container mt-4">

                <h2>Your Cart</h2>

                <table className="table table-bordered mt-3">

                    <thead>

                    <tr>

                        <th>Item</th>

                        <th>Item Desc</th>

                        <th>Price</th>

                        <th>Quantity</th>

                        <th>Total</th>

                        <th>Action</th>

                    </tr>

                    </thead>

                    <tbody>

                    {cartItems.map(cart => (

                        <tr key={cart.id}>

                            <td>{cart.item.item_name}</td>

                            <td>{cart.item.item_desc}</td>
                            <td>₹{cart.item.price}</td>

                            <td>{cart.quantity}</td>

                            <td>₹{cart.item.price * cart.quantity}</td>

                            <td>

                                <button
                                    className="btn btn-danger btn-sm"
                                    onClick={() => removeItem(cart.id)}
                                >
                                    Remove
                                </button>

                            </td>

                        </tr>

                    ))}

                    </tbody>

                </table>

                <h4>Total : ₹{total}</h4>

                <button
                    className="btn btn-success mt-3"
                    onClick={buyNow}
                    disabled={cartItems.length === 0}
                >
                    Buy Now
                </button>

            </div>

        </>

    );

}

export default Cart;