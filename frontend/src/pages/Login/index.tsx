import axios from 'axios';
import React, {  useState } from 'react';
import { BASE_URL } from '../../services/api';
import "./styles.css";




function Login() {

    const [email, setEmail]= useState('');
    const [senha, setSenha]= useState('');

    function handleSubmit(){
        axios.post(`${BASE_URL}/login`)
        .then(Response =>
             console.log(Response.data));
    }

   

    return (
        <form className="container" onSubmit={handleSubmit}>
            <div className="form-group">
                <label htmlFor="">Usuário</label>
                <input type="email" value={email} onChange={e => setEmail(e.target.value)} />
            </div>

            <div className="form-group">
                <label htmlFor=" ">Senha</label>
                <input type="text" value={senha} onChange={e => setSenha(e.target.value)} />
            </div>

            <div className="form-group">
                <button type="submit">Entrar</button>
            </div>

        </form>
    );
 }


 export default Login;