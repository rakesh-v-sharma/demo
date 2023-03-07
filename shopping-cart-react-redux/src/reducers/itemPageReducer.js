import {
	SET_ITEMS
} from '../actions/itemPageActions';

const defaultItems = {
	items:[]
}
export const itemPageReducer = (state = defaultItems, action) => {
	switch (action.type) {
		case SET_ITEMS:
			return Object.assign({}, state, {
				items: action.items
			})
		default:
			return state
	}
}