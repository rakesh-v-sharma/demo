import * as React from 'react';
import { Routes } from 'react-router-dom';
import { Route } from 'react-router-dom';


import {Items} from '../components/Items';
// import Cart from "../cart/Cart2";



export const ShoppingCartRoutes = () => {
	return (
		<Routes>
			{/* <Route path="/cart" ><Cart /></Route> */}
			<Route path='/' element={<Items/>}/>
		</Routes>
	);
}