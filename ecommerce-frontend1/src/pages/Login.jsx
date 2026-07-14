import { useState } from "react";
import { useNavigate, Link } from "react-router-dom";
import api from "../services/api";

function Login() {

    const navigate = useNavigate();

    const [email,setEmail]=useState("");

    const [password,setPassword]=useState("");

    const login=()=>{

        api.post("/users/login",{

            email,
            password

        })

            .then(res=>{

                if (res.data.id) {

                    localStorage.setItem("userId", res.data.id);
                    localStorage.setItem("userId", res.data.id);
                    localStorage.setItem("userName", res.data.name);

                    alert("Login Successful");

                    navigate("/home");

                }

            })

            .catch(()=>{

                alert("Login Failed");

            });

    }

    return(

        <div className="container mt-5" style={{maxWidth:"400px"}}>

            <h2 className="text-center mb-4">Login</h2>

            <input
                className="form-control mb-3"
                placeholder="Email"
                onChange={(e)=>setEmail(e.target.value)}
            />

            <input
                type="password"
                className="form-control mb-3"
                placeholder="Password"
                onChange={(e)=>setPassword(e.target.value)}
            />

            <button
                className="btn btn-primary w-100"
                onClick={login}
            >

                Login

            </button>

            <p className="mt-3">

                Don't have an account?

                <Link to="/register">

                    Register

                </Link>

            </p>

        </div>

    );

}

export default Login;