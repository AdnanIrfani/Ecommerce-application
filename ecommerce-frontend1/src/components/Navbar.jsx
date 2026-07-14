import { Link, useNavigate } from "react-router-dom";

function Navbar() {

    const navigate = useNavigate();

    const logout = () => {
        localStorage.clear();
        navigate("/");
    };

    return (

        <nav className="navbar navbar-expand-lg navbar-dark bg-primary">

            <div className="container">

                <Link className="navbar-brand" to="/home">
                    ShopEasy
                </Link>

                <div>

                    <Link className="btn btn-light me-2" to="/home">
                        Home
                    </Link>

                    <Link className="btn btn-light me-2" to="/cart">
                        Cart
                    </Link>

                    <Link className="btn btn-light me-2" to="/orders">
                        Orders
                    </Link>

                    <button
                        className="btn btn-danger"
                        onClick={logout}
                    >
                        Logout
                    </button>

                </div>

            </div>

        </nav>

    );

}

export default Navbar;