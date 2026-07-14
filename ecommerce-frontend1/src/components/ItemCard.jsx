function ItemCard({ item, addToCart }) {
    return (
        <div className="col-md-4 mb-4">
            <div className="card h-100 shadow-sm">

                <img
                    src="https://via.placeholder.com/300x200"
                    className="card-img-top"
                    alt={item.name}
                />

                <div className="card-body">

                    <h5>{item.name}</h5>

                    <p>{item.description}</p>

                    <h4 className="text-success">₹{item.price}</h4>

                    <button
                        className="btn btn-primary w-100"
                        onClick={() => addToCart(item.id)}
                    >
                        Add To Cart
                    </button>

                </div>

            </div>
        </div>
    );
}

export default ItemCard;