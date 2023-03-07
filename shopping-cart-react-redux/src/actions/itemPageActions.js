import {createSlice, createAsyncThunk} from "@reduxjs/toolkit";
import axios from 'axios';
export const SET_ITEMS = "SET_ITEMS";
export const setHomePageProducts = json => ({
	type: SET_ITEMS,
	items: json
})
export const fetchItems = createAsyncThunk(
	'items/fetchItems',
	async () => {
		const response = await axios.get("http://localhost:8080/api/items")
		return response?.data;
	}
)

const initialState = {
	status: null,
	data: []
}

const itemsSllice = createSlice({
	name: 'itemsSlice',
	initialState,
	extraReducers: {
		[fetchItems.pending] : (state) => {
			state.status = 'Pending';
		},
		[fetchItems.fulfilled]: (state, action) => {
			state.status = 'fulFilled';
			state.data = action.payload
		},
		[fetchItems.rejected]: (state) => {
			state.status = 'Rejected';
		}
	}
})
export default itemsSllice.reducer;