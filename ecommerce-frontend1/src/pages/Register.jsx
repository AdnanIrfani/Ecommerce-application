import { useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../services/api";

function Register(){

    const navigate=useNavigate();

    const[name,setName]=useState("");

    const[email,setEmail]=useState("");

    const[password,setPassword]=useState("");

    const register=()=>{

        api.post("/users/register",{

            name,

            email,

            password

        })

            .then(res=>{

                alert(res.data);

                navigate("/");

            });

    }

    return(

        <div className="container mt-5" style={{maxWidth:"400px"}}>

            <h2>Create Account</h2>

            <input
                className="form-control mb-3"
                placeholder="Name"
                onChange={(e)=>setName(e.target.value)}
            />

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
                className="btn btn-success w-100"
                onClick={register}
            >

                Register

            </button>

        </div>

    )

}

export default Register;