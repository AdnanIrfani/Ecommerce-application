import { useEffect, useState } from "react";
import Navbar from "../components/Navbar";
import api from "../services/api";
import {useNavigate} from "react-router-dom";

function Orders() {

    const navigate = useNavigate();

    useEffect(() => {

        if (!localStorage.getItem("userId")) {

            navigate("/");

        }

    }, []);

    const [orders, setOrders] = useState([]);

    const userId = localStorage.getItem("userId");

    useEffect(() => {
        loadOrders();
    }, []);

    const loadOrders = () => {

        api.get(`/orders/${userId}`)
            .then(res => setOrders(res.data))
            .catch(err => console.log(err));

    };

    const grandTotal = orders.reduce(
        (sum, order) => sum + order.totalAmount,
        0
    );
    return (

        <>
            <Navbar />

            <div className="container mt-4">

                <h2>My Orders</h2>

                {orders.length === 0 ? (

                    <h5 className="text-center mt-5">
                        No Orders Found
                    </h5>

                ) : (

                    <table className="table table-bordered mt-3">

                        <thead>

                        <tr>

                            <th>Order ID</th>
                            <th>Date</th>
                            <th>Total Amount</th>

                        </tr>

                        </thead>

                        <tbody>

                        {orders.map(order => (

                            <tr key={order.id}>

                                <td>{order.id}</td>

                                <td>{order.orderDate}</td>

                                <td>₹{order.totalAmount}</td>

                            </tr>

                        ))}

                        </tbody>

                    </table>

                )}
                <div className="card mt-3">
                    <div className="card-body text-end">
                        <h4>Total Spent: ₹{grandTotal}</h4>
                    </div>
                </div>

            </div>

        </>

    );

}

export default Orders;