import { useEffect, useState } from "react";
import api from "../services/api";
import Navbar from "../components/Navbar";
import ItemCard from "../components/ItemCard";
import {useNavigate} from "react-router-dom";

function Home() {
    const navigate = useNavigate();

    useEffect(() => {

        if (!localStorage.getItem("userId")) {

            navigate("/");

        }

    }, []);

    const [items, setItems] = useState([]);

    const userId = localStorage.getItem("userId");

    useEffect(() => {
        getItems();
    }, []);

    const getItems = () => {
        api.get("/items")
            .then(res => {
                setItems(res.data);
            });
    };

    const addToCart = (itemId) => {

        api.post(`/cart/add?userId=${userId}&itemId=${itemId}&quantity=1`)
            .then(() => {
                alert("Added to Cart");
            })
            .catch(() => {
                alert("Error");
            });

    };

    return (
        <>
            <Navbar />

            <div className="container mt-4">
                <h3 className="mb-4">
                    Welcome {localStorage.getItem("userName")} to our online store!
                </h3>

                <h2 className="mb-4">Available Items</h2>

                <div className="row">

                    {items.map(item => (

                        <ItemCard
                            key={item.id}
                            item={item}
                            addToCart={addToCart}
                        />

                    ))}

                </div>

            </div>
        </>
    );

}

export default Home;